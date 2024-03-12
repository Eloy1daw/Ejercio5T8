package paint;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.RepaintManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Paint{

private JFrame frame;
private String[] formas = {"Linea","Rectangulo","Ovalo"}; 
private String[] colores={"Negro","Rojo","Verde","Azul","Amarillo"};
private Color[] colors= {Color.BLACK ,Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
private Figura l;
private final JLabel lblCordenadas = new JLabel("Cordenadas x:     y:     ");

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the application.
	 */
	public Paint() {
		initialize();

	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setAutoRequestFocus(false);
		
		
		
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		Lienzo lienzo= new Lienzo();
		lienzo.setBackground(Color.WHITE);
		frame.getContentPane().add(lienzo);
		lienzo.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		lblCordenadas.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCordenadas);
		
		JButton btnAtras = new JButton("Undo");
		panel.add(btnAtras);
		btnAtras.setSize(15,15);
		ImageIcon imagen1 = new ImageIcon("img/Undo-24.png");
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(btnAtras.getWidth(),
				btnAtras.getHeight(), Image.SCALE_DEFAULT));
		btnAtras.setIcon(icono1);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lienzo.atras();
			}
		});
		
		JButton btnAdelante = new JButton("Redo");
		panel.add(btnAdelante);
		btnAdelante.setSize(15,15);
		ImageIcon imagen2 = new ImageIcon("img/Redo-24.png");
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(btnAdelante.getWidth(),
				btnAdelante.getHeight(), Image.SCALE_DEFAULT));
		btnAdelante.setIcon(icono2);
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lienzo.adelante();

			}
		});
		
		JButton btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		btnLimpiar.setSize(15,15);
		ImageIcon imagen3 = new ImageIcon("img/Eraser-24.png");
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(btnLimpiar.getWidth(),
				btnLimpiar.getHeight(), Image.SCALE_DEFAULT));
		btnLimpiar.setIcon(icono3);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lienzo.borrar();

			}
		});
		
		JComboBox CbColores = new JComboBox();
		panel.add(CbColores);
		CbColores.setModel(new DefaultComboBoxModel(colores));
		CbColores.setSelectedIndex(0);
		
		JComboBox CbFiguras =new JComboBox();
		panel.add(CbFiguras);
		CbFiguras.setModel(new DefaultComboBoxModel(formas));
		CbFiguras.setSelectedIndex(0);
		
		JCheckBox chckbxRellena = new JCheckBox("Rellena");
		chckbxRellena.setBackground(SystemColor.controlHighlight);
		panel.add(chckbxRellena);
		
		lienzo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e){
				lblCordenadas.setText(String.valueOf("Cordenadas x: "+e.getX()+"  y: "+e.getY()));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				l.setX2(e.getX());
				l.setY2(e.getY());
				lblCordenadas.setText(String.valueOf("Cordenadas x: "+e.getX()+"  y: "+e.getY()));
				lienzo.actualizarFigura(l);

			}
		});	
		
		lienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switch (CbFiguras.getSelectedIndex()){
				case 0:
					l=new Linea(e.getX(),e.getY(),e.getX(),e.getY(),colors[CbColores.getSelectedIndex()]);
					break;
				case 1:
					l=new Rectangulo(e.getX(),e.getY(),e.getX(),e.getY(),colors[CbColores.getSelectedIndex()],chckbxRellena.isSelected());
					break;
				case 2:
					l=new Ovalo(e.getX(),e.getY(),e.getX(),e.getY(),colors[CbColores.getSelectedIndex()],chckbxRellena.isSelected());
					break;
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				l.setX2(e.getX());
				l.setY2(e.getY());
		        lienzo.agregarfigura(l);
			}
			
		});
		
	}
	
}

