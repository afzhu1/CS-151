import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActionTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

     // final int FIELD_WIDTH = 20;
    //  final JTextField textField = new JTextField(FIELD_WIDTH);
     // textField.setText("Click a button!");

      JButton zoomIn = new JButton("Zoom in");

      zoomIn.addActionListener(event ->
         textField.setText("Hello, World!"));

      JButton zoomOut = new JButton("Zoom out");

      goodbyeButton.addActionListener(event ->
         textField.setText("Goodbye, World!"));
      CarIcon car = new carIcon(100);
      JLabel car = new JLabel(car);
      
      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
