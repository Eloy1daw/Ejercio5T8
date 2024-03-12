package paint;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private ArrayList<Figura> figurasEntrada;
	private Figura figura;
	private int diferencia = 0;
	private boolean undo;

	public Lienzo() {
		figurasEntrada = new ArrayList<>();

	}

	public void agregarfigura(Figura f) {

		if (undo) {
			for (int i = figurasEntrada.size() - 1; i >= diferencia; i--) {
				figurasEntrada.remove(i);
			}
			undo = false;
		}
		figurasEntrada.add(f);
		figura = null;
		repaint();

		diferencia++;

	}

	public void actualizarFigura(Figura f) {
		figura = f;
		repaint();
	}

	public void borrar() {
		figurasEntrada.clear();
		diferencia = 0;
		repaint();
	}

	public void atras() {
		if (diferencia <= figurasEntrada.size() && diferencia >= 0) {
			diferencia--;
			repaint();
			undo = true;
		}
	}

	public void adelante() {
		if (diferencia < figurasEntrada.size()) {
			diferencia++;
			repaint();
		}

		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < diferencia; i++) {
			figurasEntrada.get(i).pintar(g);

		}
		if (figura != null) {
			figura.pintar(g);
		}

	}

}
