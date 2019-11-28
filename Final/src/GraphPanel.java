import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
   A panel to draw a graph
*/
public class GraphPanel extends JComponent
{
   /**
      Constructs a graph panel.
      @param aToolBar the tool bar with the node and edge tools
      @param aGraph the graph to be displayed and edited
   */
   public GraphPanel(ToolBar aToolBar, Graph aGraph) {

      toolBar = aToolBar;
      labelEdge = new JButton("Label");
      labelEdge.setEnabled(false); // initially, no edges are selected
      toolBar.add(labelEdge); // add button to toolbar

      graph = aGraph;
      setBackground(Color.WHITE);

      addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
               Point2D mousePoint = event.getPoint();
               Node n = graph.findNode(mousePoint);
               Edge e = graph.findEdge(mousePoint);
               Object tool = toolBar.getSelectedTool();
               if (tool == null) { 
            	 //selection and deselection of edge
                  if (e != null) {
                     if(selected.contains(e)) {
                        selected.remove(e);
                     }
                     else {
                        labelEdge.setEnabled(true);
                        selected.add(e);
                     }
                  }
                  else if (n != null) {
                     //node selection
                     if(selected.contains(n) == false) {
                        labelEdge.setEnabled(false);
                        selected.add(n);
                        dragStartPoint = mousePoint;
                        dragStartBounds = n.getBounds();
                     }
                     // If the edge is already selected
                     else {
                        selected.remove(n);
                     }
                  }
                  // if both e and n are null, then nothing is selected, label button remains disabled
                  else {
                     labelEdge.setEnabled(false);
                  }
               }
               else if (tool instanceof Node) {
                  selected.clear(); // Select option in toolbar is not selected
                  labelEdge.setEnabled(false); //label button still not enabled

                  Node prototype = (Node) tool;
                  Node newNode = (Node) prototype.clone();
                  boolean added = graph.add(newNode, mousePoint);
                  if (added) {
                     selected.add(newNode);
                     dragStartPoint = mousePoint;
                     dragStartBounds = newNode.getBounds();
                  }
                  else if (n != null) {
                     selected.add(n);
                     dragStartPoint = mousePoint;
                     dragStartBounds = n.getBounds();
                  }
               }
               else if (tool instanceof Edge) {
                  selected.clear();
                  if (n != null) {
                     selected.add(e);
                     rubberBandStart = mousePoint;
                  }
               }
               lastMousePoint = mousePoint;
               repaint();
            }

            public void mouseReleased(MouseEvent event) {

               Object tool = toolBar.getSelectedTool();

               if (rubberBandStart != null) {
                  Point2D mousePoint = event.getPoint();
                  Edge prototype = (Edge) tool;
                  Edge newEdge = (Edge) prototype.clone();
                  if (graph.connect(newEdge, rubberBandStart, mousePoint)) {
                     selected.clear();
                     selected.add(newEdge);
                     labelEdge.setEnabled(true);
                  }
               }

               validate();
               repaint();

               lastMousePoint = null;
               dragStartBounds = null;
               rubberBandStart = null;
            }
         });

      addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent event) {

               // Identifying this node's travel so that we can make the other selected nodes move similarly
               Point2D mousePoint = event.getPoint();
               Node selectedNode = graph.findNode(mousePoint);

               if (dragStartBounds != null || selectedNode != null) {
                  // Calculating the travel of the node being moved so that we can replicate it for all selected nodes
                  Rectangle2D bounds = selectedNode.getBounds();
                  double xOffset = dragStartBounds.getX() - bounds.getX() + mousePoint.getX() - dragStartPoint.getX();
                  double yOffset = dragStartBounds.getY() - bounds.getY() + mousePoint.getY() - dragStartPoint.getY();

                  for(Object o : selected) {
                     if (o instanceof Node) {
                        Node n = (Node) o;
                        n.translate(xOffset, yOffset);
                     }
                  }
               }
               lastMousePoint = mousePoint;
               repaint();
            }
         });

      labelEdge.addActionListener(event-> {
         String labelText = JOptionPane.showInputDialog(this, "Label edge: ");
         String labelTextTrimmed = labelText.trim();

         if(labelTextTrimmed.length() != 0) {
            for (Object o : selected) {
               // Can only draw Labels/Annotations for edges
               if (o instanceof Edge) {
                  graph.addLabel(labelTextTrimmed, (Edge) o);
               }
            }
            repaint();
         }
      });
   }

   public void paintComponent(Graphics g) {

      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D bounds = getBounds();
      Rectangle2D graphBounds = graph.getBounds(g2);
      graph.draw(g2);

      for(Object o : selected) {
         if (o instanceof Node) {
            labelEdge.setEnabled(false);
            Rectangle2D grabberBounds = ((Node) o).getBounds();
            drawGrabber(g2, grabberBounds.getMinX(), grabberBounds.getMinY());
            drawGrabber(g2, grabberBounds.getMinX(), grabberBounds.getMaxY());
            drawGrabber(g2, grabberBounds.getMaxX(), grabberBounds.getMinY());
            drawGrabber(g2, grabberBounds.getMaxX(), grabberBounds.getMaxY());
         }

         if (o instanceof Edge) {
            labelEdge.setEnabled(true);
            Line2D line = ((Edge) o).getConnectionPoints();
            drawGrabber(g2, line.getX1(), line.getY1());
            drawGrabber(g2, line.getX2(), line.getY2());
         }

         if (rubberBandStart != null) {
            labelEdge.setEnabled(false);
            Color oldColor = g2.getColor();
            g2.setColor(PURPLE);
            g2.draw(new Line2D.Double(rubberBandStart, lastMousePoint));
            g2.setColor(oldColor);
         }
      }
   }


  

   /**
      Draws a single "grabber", a filled square
      @param g2 the graphics context
      @param x the x coordinate of the center of the grabber
      @param y the y coordinate of the center of the grabber
   */
   public static void drawGrabber(Graphics2D g2, double x, double y)
   {
      final int SIZE = 5;
      Color oldColor = g2.getColor();
      g2.setColor(PURPLE);
      g2.fill(new Rectangle2D.Double(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE));
      g2.setColor(oldColor);
   }

   public Dimension getPreferredSize()
   {
      Rectangle2D bounds
         = graph.getBounds((Graphics2D) getGraphics());
      return new Dimension(
         (int) bounds.getMaxX(),
         (int) bounds.getMaxY());
   }

   private Graph graph;
   private ToolBar toolBar;
   private JButton labelEdge;
   private Point2D lastMousePoint;
   private Point2D rubberBandStart;
   private Point2D dragStartPoint;
   private Rectangle2D dragStartBounds;
   private ArrayList<Object> selected = new ArrayList<>(); 
   private static final Color PURPLE = new Color(0.7f, 0.4f, 0.7f);
}
