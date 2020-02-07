import java.awt.*;
import java.awt.geom.Line2D;

public class Label {
	
	private String input;
	private Edge edge;
	
	public Label() {
	
	}
	
	public Label(String input, Edge edge)  {
		this.input = input;
		this.edge = edge;
	}
	
	public void draw(Graphics2D g2) {
		Line2D line = edge.getConnectionPoints();
		double x1 = line.getX1();
		double y1 = line.getY1();
	    double x2 = line.getX2();
	    double y2 = line.getY2();
	     
	    //get midpoint
	    int mX = (int)(x1 + x2) / 2;
	    int mY = (int)(y1 + y2) / 2;
	    g2.drawString(input, mX, mY);
	}
	
	public String getInput() {
		return this.input;
	}
	
	public Edge getEdge() {
		return this.edge;
	}
	
	public void setLabel(String input) {
		this.input = input;
	}
	
}
