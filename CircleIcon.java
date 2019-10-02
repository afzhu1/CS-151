import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

/**
 * An icon that has the shape of the planet Mars.
 */
public class CircleIcon implements Icon {
	/**
	 * Constructs a Mars icon of a given size.
	 * 
	 * @param aSize the size of the icon
	 */

	public CircleIcon(int aSize, Color color) {
		size = aSize;
		this.color = color;
	}

	public int getIconWidth() {
		return size;
	}

	public int getIconHeight() {
		return size;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		this.c = c;
		this.g = g2;
		Ellipse2D.Double planet = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(color);
		g2.fill(planet);
	}

	public void paintIcon(Component c, Graphics g, int x, int y, Color color) {
		Graphics2D g2 = (Graphics2D) g;
		this.c = c;
		this.g = g2;
		Ellipse2D.Double planet = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(color);
		g2.fill(planet);
	}

	private Color color;
	private int size;
	public Component c;
	public Graphics2D g;
}
