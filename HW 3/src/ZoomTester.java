import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ZoomTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

     // final int FIELD_WIDTH = 20;
    //  final JTextField textField = new JTextField(FIELD_WIDTH);
     // textField.setText("Click a button!");

      JButton zoomIn = new JButton("Zoom in");

   

      JButton zoomOut = new JButton("Zoom out");

    
      CarIcon car = new CarIcon(1000);
      JLabel carLabel = new JLabel(car);
      
      zoomIn.addActionListener(event -> car.zoomIn()
    	         );
      zoomOut.addActionListener(event -> car.zoomOut()
    	         );
      
      frame.setLayout(new FlowLayout());

      frame.add(zoomIn);
      frame.add(zoomOut);
      frame.add(carLabel);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
      Timer t = new Timer(100, event ->
      {
         carLabel.repaint();
      });
      t.start();
   }
}
