package paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Poligonos extends Figura {
	private boolean relleno;

	Poligonos() {
		super();
		this.relleno = false;
	}

	Poligonos(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
		super(x1, y1, x2, y2, color);
		this.relleno = relleno;
	}

	public boolean isRelleno() {
		return relleno;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	public int getSupIzqX() {
		return Math.min(getX1(), getX2());
	}

	public int getSupIzqY() {
		return Math.min(getY1(), getY2());
	}

	public int getAnchura() {
		return Math.abs(getX1() - getX2());
	}

	public int getAltura() {
		return Math.abs(getY1() - getY2());
	}

	abstract public void pintar(Graphics g);
}
