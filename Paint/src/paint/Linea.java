package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Linea extends Figura {

	public Linea() {
		super();
	}

	public Linea(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	@Override
	public void pintar(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
