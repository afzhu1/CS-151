import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class BusIcon implements Icon {
	 public BusIcon(int aWidth)
	   {
	      width = aWidth;
	   }
	   
	   public void zoomIn() {
		   width = width * 2;
	   }
	   
	   public void zoomOut() {
		   width = width / 2 ;
	   }
	   
	   public int getIconWidth()
	   {
	      return width;
	   }

	   public int getIconHeight()
	   {
	      return width / 2;
	   }

	   public void paintIcon(Component c, Graphics g, int x, int y)
	   {
	      Graphics2D g2 = (Graphics2D) g;
	      Rectangle2D.Double body
	            = new Rectangle2D.Double(x, y + width / 6, 
	                  width - 1, width / 6);
	      Ellipse2D.Double frontTire
	            = new Ellipse2D.Double(x + width / 6, y + width / 3, 
	                  width / 6, width / 6);
	      Ellipse2D.Double rearTire
	            = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
	                  width / 6, width / 6);

	      // The bottom of the front windshield
	      Point2D.Double r1
	            = new Point2D.Double(x + width / 6, y + width / 6);
	      // The front of the roof
	      Point2D.Double r2
	            = new Point2D.Double(x + width / 6, y);
	      
	      // The bottom of the front Window
	      Point2D.Double r5
	      		= new Point2D.Double(x + width / 3, y + width / 6);
	      // The top of the front window
	      Point2D.Double r6
    		= new Point2D.Double(x + width / 3, y);
	      // The bottom of the middle window
	      Point2D.Double r7
    		= new Point2D.Double(x + width / 1.5, y + width / 6);
	      // The top of the middle window
	      Point2D.Double r8
	      	= new Point2D.Double(x + width / 1.5, y);
	      
	      // The rear of the roof
	      Point2D.Double r3
	      	= new Point2D.Double(x + width-1 , y);
	      // The bottom of the rear windshield
	      Point2D.Double r4
          	= new Point2D.Double(x + width -1, y + width / 6);

	      Line2D.Double frontWindshield
	            = new Line2D.Double(r1, r2);
	      Line2D.Double roofTop
	            = new Line2D.Double(r2, r3);
	      Line2D.Double rearWindshield
	            = new Line2D.Double(r3, r4);
	      
	      Line2D.Double frontWindow
	      		= new Line2D.Double(r5, r6);
	      Line2D.Double middleWindow
          		= new Line2D.Double(r7, r8);

	      g2.fill(frontTire);
	      g2.fill(rearTire);
	      g2.setColor(Color.yellow);
	      g2.fill(body);
	      g2.draw(frontWindshield);
	      g2.draw(roofTop);
	      g2.draw(rearWindshield);
	      g2.draw(frontWindow);
	      g2.draw(middleWindow);

	   }

	   private int width;
}
