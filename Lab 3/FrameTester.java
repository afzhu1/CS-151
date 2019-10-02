import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		JButton redButton = new JButton("Repaint Red");
		JButton blueButton = new JButton("Repaint Blue");
		JButton greenButton = new JButton("Repaint Green");
		CircleIcon circle = new CircleIcon(50, Color.RED);
		JLabel label = new JLabel(circle);

		redButton.addActionListener(event -> circle.paintIcon(circle.c, circle.g, circle.getIconHeight(),
				circle.getIconWidth(), Color.RED));

		blueButton.addActionListener(event -> circle.paintIcon(circle.c, circle.g, circle.getIconHeight(),
				circle.getIconWidth(), Color.BLUE));

		greenButton.addActionListener(event -> circle.paintIcon(circle.c, circle.g, circle.getIconHeight(),
				circle.getIconWidth(), Color.GREEN));

		frame.setLayout(new FlowLayout());

		frame.add(redButton);
		frame.add(blueButton);
		frame.add(greenButton);
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
