import java.awt.*;
import java.util.*;

/**
   A simple graph with round nodes and straight edges.
*/
public class SimpleGraph extends Graph
{
   public Node[] getNodePrototypes()
   {
      Node[] nodeTypes =
         {
            new CircleNode(Color.BLACK),
            new CircleNode(Color.WHITE),
            new CircleNode(Color.RED)
         };
      return nodeTypes;
   }

   public Edge[] getEdgePrototypes()
   {
      Edge[] edgeTypes = 
         {
            new LineEdge()
         };
      return edgeTypes;
   }
}





