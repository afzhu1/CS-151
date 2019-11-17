import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class Hw4Question2
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final MoveableShape shape
            = new CarShape(0, 0, CAR_WIDTH);

      ShapeIcon icon = new ShapeIcon(shape,
            ICON_WIDTH, ICON_HEIGHT);
      
      final MoveableShape shape1
      = new CarShape(0, 0, CAR_WIDTH);

      ShapeIcon icon1 = new ShapeIcon(shape1,
    		  ICON_WIDTH, ICON_HEIGHT);
      
      final MoveableShape shape2
      = new CarShape(0, 0, CAR_WIDTH);

      ShapeIcon icon2 = new ShapeIcon(shape2,
    		  ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);
      
      final JLabel label1 = new JLabel(icon1);
      frame.setLayout(new FlowLayout());
      frame.add(label1);
      
      final JLabel label2 = new JLabel(icon2);
      frame.setLayout(new FlowLayout());
      frame.add(label2);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
      
      ExecutorService service = Executors.newCachedThreadPool();
      Runnable r1 = mover(shape, label, 10);
      Runnable r2 = mover(shape1, label1, 20);
      Runnable r3 = mover(shape2, label2, 200);
      service.execute(r1);
      service.execute(r2);
      service.execute(r3);
      service.shutdown();
   }

   public static Runnable mover(MoveableShape shape, JLabel label, int delay) {
	      // Milliseconds between timer ticks
	   return() -> {
	      Timer t = new Timer(delay, event ->
	         {
	            shape.move();
	            label.repaint();
	         });
	      t.start();
	   };
   }
   
   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
   
   
   
}


