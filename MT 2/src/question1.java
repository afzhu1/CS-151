import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class question1
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      JButton carButton = new JButton("Car");
      JButton busButton = new JButton("Bus");
      
      JButton zoomIn = new JButton("Zoom in");
      JButton zoomOut = new JButton("Zoom out");

    
      BusIcon bus = new BusIcon(1000);
      JLabel busLabel = new JLabel(bus);
      CarIcon car = new CarIcon(1000);
      JLabel carLabel = new JLabel(car);
      
      
      
      frame.setLayout(new FlowLayout());

      frame.add(carButton);
      frame.add(busButton);
      frame.add(zoomIn);
      frame.add(zoomOut);
      frame.add(carLabel);

      
      
      busButton.addActionListener(event -> frame.remove(carLabel)
  	         ); // if we press the busButton, we will always remove the car
      
      busButton.addActionListener(event -> frame.add(busLabel)
   	         ); // we will also add the bus
      
      carButton.addActionListener(event -> frame.remove(busLabel)
   	         ); //same logic for car, but flipped
       carButton.addActionListener(event -> frame.add(carLabel)
    	         );
      
       
       // we will keep the labels in sync in regard to how much zooming occurs
       zoomIn.addActionListener(event -> bus.zoomIn()
  	         );
    zoomOut.addActionListener(event -> bus.zoomOut()
  	         );
    zoomIn.addActionListener(event -> car.zoomIn()
 	         );
   zoomOut.addActionListener(event -> car.zoomOut()
 	         );
   
       
       frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
       
      Timer t = new Timer(100, event ->
      {
    	  // update constantly update labels and frame
         busLabel.repaint();
         carLabel.repaint();
         frame.revalidate();
         frame.repaint();
         
      });
      t.start();
   }
}
