//Eloy Miota
// Añadido imagenes para cada enemigo
// Aumento de las pociones maximsa a 5 y por el sistemas de drops se puede aumentar el numero maximo de pociones
// Cada vez que derrotas a un enemigo te puede dejar algun drop y 1 pocion asegurada para facilitar el progreso
// Sistema de experiencia y nivel del jugador escalando las estadisticas
// Escalado de los enemigos segun las estadisticas del jugador
// Cada vez que pierdes o ganas aparecen dos botones de volver a jugar y cerrar 

package entregaJuego;

import java.awt.EventQueue;
import java.util.regex.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.Icon;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class entregaJuego {

	private JFrame frmJuegoDeLa;
	private JTextField tfNombre;

	int numeroEnemigos = 0, turnos = 0;
	int ataqueEnemigo, defensaEnemigo;
	Random numeroRandom = new Random();
	Jugador j = new Jugador();
	Enemigo e = new Enemigo();

	/**
	 * Launch the application.
	 */
	boolean comprobarExpReg(String palabra, String er) {
		Pattern pat = Pattern.compile(er);
		Matcher mat = pat.matcher(palabra);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	void combate(Jugador j, Enemigo e) {

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entregaJuego window = new entregaJuego();
					window.frmJuegoDeLa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public entregaJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJuegoDeLa = new JFrame();
		frmJuegoDeLa.getContentPane().setForeground(new Color(51, 51, 51));
		frmJuegoDeLa.setTitle("Juego de la gruta");
		frmJuegoDeLa.setBounds(100, 100, 999, 551);
		frmJuegoDeLa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoDeLa.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 339, 234, 163);
		frmJuegoDeLa.getContentPane().add(scrollPane);
		scrollPane.setVisible(false);

		JTextArea taTurnos = new JTextArea();
		taTurnos.setEditable(false);
		scrollPane.setViewportView(taTurnos);
		taTurnos.setVisible(false);

		JLabel lblEstadisticas = new JLabel("Tus estadisticas");
		lblEstadisticas.setForeground(Color.WHITE);
		lblEstadisticas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setBounds(264, 339, 133, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas);
		lblEstadisticas.setVisible(false);

		JLabel lblEstadisticas1 = new JLabel("Nombre:");
		lblEstadisticas1.setBounds(286, 366, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas1);
		lblEstadisticas1.setVisible(false);
		lblEstadisticas1.setForeground(Color.WHITE);

		JLabel lblEstadisticas2 = new JLabel("Vida:");
		lblEstadisticas2.setBounds(286, 393, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas2);
		lblEstadisticas2.setVisible(false);
		lblEstadisticas2.setForeground(Color.WHITE);

		JLabel lblEstadisticas3 = new JLabel("Ataque:");
		lblEstadisticas3.setBounds(286, 420, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas3);
		lblEstadisticas3.setVisible(false);
		lblEstadisticas3.setForeground(Color.WHITE);

		JLabel lblEstadisticas4 = new JLabel("Defensa:");
		lblEstadisticas4.setBounds(286, 446, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas4);
		lblEstadisticas4.setVisible(false);
		lblEstadisticas4.setForeground(Color.WHITE);

		JLabel lblEstadisticas5 = new JLabel("Experiencia:");
		lblEstadisticas5.setBounds(286, 473, 86, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticas5);
		lblEstadisticas5.setVisible(false);
		lblEstadisticas5.setForeground(Color.WHITE);

		JLabel lblExperiencia = new JLabel("");
		lblExperiencia.setBounds(371, 473, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblExperiencia);
		lblExperiencia.setVisible(false);
		lblExperiencia.setForeground(Color.WHITE);

		JLabel labelDefensa = new JLabel("");
		labelDefensa.setBounds(361, 446, 70, 15);
		frmJuegoDeLa.getContentPane().add(labelDefensa);
		labelDefensa.setVisible(false);
		labelDefensa.setForeground(Color.WHITE);

		JLabel labelAtaque = new JLabel("");
		labelAtaque.setBounds(361, 420, 70, 15);
		frmJuegoDeLa.getContentPane().add(labelAtaque);
		labelAtaque.setVisible(false);
		labelAtaque.setForeground(Color.WHITE);

		JLabel labelVida = new JLabel("");
		labelVida.setBounds(361, 393, 70, 15);
		frmJuegoDeLa.getContentPane().add(labelVida);
		labelVida.setVisible(false);
		labelVida.setForeground(Color.WHITE);

		JLabel labelNombre = new JLabel("");
		labelNombre.setBounds(361, 366, 70, 15);
		frmJuegoDeLa.getContentPane().add(labelNombre);
		labelNombre.setVisible(false);
		labelNombre.setForeground(Color.WHITE);

		JLabel lblEstadisticasE = new JLabel("Estadisticas enemigas");
		lblEstadisticasE.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEstadisticasE.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticasE.setBounds(403, 339, 195, 15);
		frmJuegoDeLa.getContentPane().add(lblEstadisticasE);
		lblEstadisticasE.setVisible(false);
		lblEstadisticasE.setForeground(Color.WHITE);

		JLabel lblEstadisticasE1 = new JLabel("Nombre:");
		lblEstadisticasE1.setBounds(429, 367, 70, 13);
		frmJuegoDeLa.getContentPane().add(lblEstadisticasE1);
		lblEstadisticasE1.setVisible(false);
		lblEstadisticasE1.setForeground(Color.WHITE);

		JLabel lblEstadisticasE2 = new JLabel("Vida:");
		lblEstadisticasE2.setBounds(429, 394, 45, 13);
		frmJuegoDeLa.getContentPane().add(lblEstadisticasE2);
		lblEstadisticasE2.setVisible(false);
		lblEstadisticasE2.setForeground(Color.WHITE);

		JLabel lblEstadisticasE3 = new JLabel("Ataque:");
		lblEstadisticasE3.setBounds(429, 421, 70, 13);
		frmJuegoDeLa.getContentPane().add(lblEstadisticasE3);
		lblEstadisticasE3.setVisible(false);
		lblEstadisticasE3.setForeground(Color.WHITE);

		JLabel lblEstadisticasE4 = new JLabel("Defensa:");
		lblEstadisticasE4.setBounds(429, 447, 70, 13);
		frmJuegoDeLa.getContentPane().add(lblEstadisticasE4);
		lblEstadisticasE4.setVisible(false);
		lblEstadisticasE4.setForeground(Color.WHITE);

		JLabel lblNombreE = new JLabel("");
		lblNombreE.setBounds(497, 367, 101, 13);
		frmJuegoDeLa.getContentPane().add(lblNombreE);
		lblNombreE.setVisible(false);
		lblNombreE.setForeground(Color.WHITE);

		JLabel lblVidaE = new JLabel("");
		lblVidaE.setBounds(497, 394, 71, 13);
		frmJuegoDeLa.getContentPane().add(lblVidaE);
		lblVidaE.setVisible(false);
		lblVidaE.setForeground(Color.WHITE);

		JLabel lblAtaqueE = new JLabel("");
		lblAtaqueE.setBounds(497, 421, 45, 13);
		frmJuegoDeLa.getContentPane().add(lblAtaqueE);
		lblAtaqueE.setVisible(false);
		lblAtaqueE.setForeground(Color.WHITE);

		JLabel lblDefensaE = new JLabel("");
		lblDefensaE.setBounds(497, 447, 45, 13);
		frmJuegoDeLa.getContentPane().add(lblDefensaE);
		lblDefensaE.setVisible(false);
		lblDefensaE.setForeground(Color.WHITE);

		JLabel lblEnemigo = new JLabel("");
		lblEnemigo.setBounds(321, 67, 346, 267);
		frmJuegoDeLa.getContentPane().add(lblEnemigo);
		ImageIcon imagen = new ImageIcon("img/" + String.valueOf(numeroEnemigos) + ".gif");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblEnemigo.getWidth(), lblEnemigo.getHeight(),
				Image.SCALE_DEFAULT));
		lblEnemigo.setIcon(icono);
		lblEnemigo.setVisible(false);

		JButton btnAtacar = new JButton("Atacar");

		btnAtacar.setBounds(810, 367, 139, 135);
		frmJuegoDeLa.getContentPane().add(btnAtacar);
		btnAtacar.setVisible(false);

		JButton btnPocion = new JButton(
				"Usar poción " + String.valueOf(j.getNumeroPotis()) + "/" + String.valueOf(j.getMaximasPotis()));

		btnPocion.setBounds(606, 367, 178, 135);

		frmJuegoDeLa.getContentPane().add(btnPocion);
		btnPocion.setVisible(false);

		tfNombre = new JTextField();
		tfNombre.addMouseListener(new MouseAdapter() {

		});
		tfNombre.setBounds(390, 145, 208, 19);
		frmJuegoDeLa.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblIntroduceTuNombre = new JLabel("Introduce tu nombre");
		lblIntroduceTuNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceTuNombre.setBounds(390, 126, 208, 15);
		frmJuegoDeLa.getContentPane().add(lblIntroduceTuNombre);

		JLabel lblErrorElNombre = new JLabel("Error el nombre tiene que empezar con mayúscula y entre 1 y 7 letras");
		lblErrorElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorElNombre.setForeground(Color.RED);
		lblErrorElNombre.setBounds(246, 176, 496, 15);
		frmJuegoDeLa.getContentPane().add(lblErrorElNombre);
		lblErrorElNombre.setVisible(false);

		JLabel lblGameover = new JLabel("");
		lblGameover.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameover.setBounds(330, 131, 328, 258);
		frmJuegoDeLa.getContentPane().add(lblGameover);
		lblGameover.setVisible(false);
		ImageIcon game = new ImageIcon("img/gameOver.jpeg");
		Icon ico = new ImageIcon(
				game.getImage().getScaledInstance(lblEnemigo.getWidth(), lblGameover.getHeight(), Image.SCALE_DEFAULT));
		lblGameover.setIcon(ico);

		JLabel lblNivelEstadistica = new JLabel("Nivel:");
		lblNivelEstadistica.setForeground(new Color(255, 255, 255));
		lblNivelEstadistica.setBounds(286, 494, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblNivelEstadistica);
		lblNivelEstadistica.setVisible(false);

		JLabel lblNivel = new JLabel("");
		lblNivel.setForeground(new Color(255, 255, 255));
		lblNivel.setBounds(371, 494, 70, 15);
		frmJuegoDeLa.getContentPane().add(lblNivel);
		lblNivel.setVisible(false);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmJuegoDeLa.dispose();
			}
		});

		JButton btnVolverAJugar = new JButton("Volver a jugar");
		btnVolverAJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPocion.setVisible(true);
				scrollPane.setVisible(true);
				taTurnos.setVisible(true);
				lblEstadisticas.setVisible(true);
				lblEstadisticas1.setVisible(true);
				lblEstadisticas2.setVisible(true);
				lblEstadisticas3.setVisible(true);
				lblEstadisticas4.setVisible(true);
				lblEstadisticas5.setVisible(true);
				lblEstadisticasE.setVisible(true);
				lblEstadisticasE1.setVisible(true);
				lblEstadisticasE2.setVisible(true);
				lblEstadisticasE3.setVisible(true);
				lblEstadisticasE4.setVisible(true);
				lblAtaqueE.setVisible(true);
				lblDefensaE.setVisible(true);
				lblNombreE.setVisible(true);
				lblVidaE.setVisible(true);
				btnAtacar.setVisible(true);
				lblEnemigo.setVisible(true);
				labelAtaque.setVisible(true);
				labelDefensa.setVisible(true);
				labelNombre.setVisible(true);
				labelVida.setVisible(true);
				lblExperiencia.setVisible(true);
				lblGameover.setVisible(false);
				btnCerrar.setVisible(false);
				btnVolverAJugar.setVisible(false);
				lblNivelEstadistica.setVisible(true);
				lblNivel.setVisible(true);
				int ataque, defensa;
				numeroEnemigos = 0;
				turnos = 0;
				ataque = 51 + numeroRandom.nextInt(50);
				defensa = 1 + numeroRandom.nextInt(49);
				ataqueEnemigo = 51 + numeroRandom.nextInt(50);
				defensaEnemigo = 1 + numeroRandom.nextInt(49);
				j.setNombre(tfNombre.getText());
				e.setNombre("Fantrasma");
				e.setAtaque(ataqueEnemigo);
				e.setDefensa(defensaEnemigo);
				e.setVida(500);
				j.setExperiencia(0);
				j.setMaxExp(100);
				j.setNumeroPotis(5);
				j.setMaximasPotis(5);
				j.setVida(500);
				j.setAtaque(ataque);
				j.setDefensa(defensa);
				j.setNivel(1);
				e.setExperiencia(50 + numeroRandom.nextInt(70));

				ImageIcon imagen = new ImageIcon("img/0.gif");
				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblEnemigo.getWidth(),
						lblEnemigo.getHeight(), Image.SCALE_DEFAULT));
				lblEnemigo.setIcon(icono);
				taTurnos.setText("");

				ImageIcon lose = new ImageIcon("img/gameOver.jpeg");
				Icon ico = new ImageIcon(lose.getImage().getScaledInstance(lblGameover.getWidth(),
						lblGameover.getHeight(), Image.SCALE_DEFAULT));
				lblGameover.setIcon(ico);
				lblNivel.setText(String.valueOf(j.getNivel()));
				labelAtaque.setText(String.valueOf(j.getAtaque()));
				labelDefensa.setText(String.valueOf(j.getDefensa()));
				labelNombre.setText(j.getNombre());
				labelVida.setText(String.valueOf(j.getVida()) + "/500");
				lblExperiencia.setText(String.valueOf(j.getExperiencia()) + "/" + (String.valueOf(j.getMaxExp())));
				lblAtaqueE.setText(String.valueOf(e.getAtaque()));
				lblDefensaE.setText(String.valueOf(e.getDefensa()));
				lblNombreE.setText(e.getNombre());
				lblVidaE.setText(String.valueOf(e.getVida()) + "/500");
				frmJuegoDeLa.getContentPane().setBackground(new Color(67, 117, 196));
				btnPocion.setEnabled(true);
				btnPocion.setText("Usar poción " + String.valueOf(j.getNumeroPotis()) + "/"
						+ String.valueOf(j.getMaximasPotis()));

			}
		});
		btnVolverAJugar.setBounds(88, 205, 215, 110);
		frmJuegoDeLa.getContentPane().add(btnVolverAJugar);
		btnVolverAJugar.setVisible(false);

		btnCerrar.setBounds(685, 205, 215, 110);
		frmJuegoDeLa.getContentPane().add(btnCerrar);
		btnCerrar.setVisible(false);

		JButton btnPulsaParaEmpezar = new JButton("Pulsa para empezar");
		btnPulsaParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comprobarExpReg(tfNombre.getText(), "^[A-Z]\\w{1,7}$")) {

					ataqueEnemigo = 51 + numeroRandom.nextInt(50);
					defensaEnemigo = 1 + numeroRandom.nextInt(49);
					j.setNombre(tfNombre.getText());
					e.setNombre("Fantrasma");
					e.setAtaque(ataqueEnemigo);
					e.setDefensa(defensaEnemigo);
					lblErrorElNombre.setVisible(false);
					btnPulsaParaEmpezar.setVisible(false);
					tfNombre.setVisible(false);
					lblIntroduceTuNombre.setVisible(false);
					btnPocion.setVisible(true);
					scrollPane.setVisible(true);
					taTurnos.setVisible(true);
					lblEstadisticas.setVisible(true);
					lblEstadisticas1.setVisible(true);
					lblEstadisticas2.setVisible(true);
					lblEstadisticas3.setVisible(true);
					lblEstadisticas4.setVisible(true);
					lblEstadisticas5.setVisible(true);
					lblEstadisticasE.setVisible(true);
					lblEstadisticasE1.setVisible(true);
					lblEstadisticasE2.setVisible(true);
					lblEstadisticasE3.setVisible(true);
					lblEstadisticasE4.setVisible(true);
					lblAtaqueE.setVisible(true);
					lblDefensaE.setVisible(true);
					lblNombreE.setVisible(true);
					lblVidaE.setVisible(true);
					btnAtacar.setVisible(true);
					lblEnemigo.setVisible(true);
					labelAtaque.setVisible(true);
					labelDefensa.setVisible(true);
					labelNombre.setVisible(true);
					labelVida.setVisible(true);
					lblExperiencia.setVisible(true);
					lblNivelEstadistica.setVisible(true);
					lblNivel.setVisible(true);

					labelAtaque.setText(String.valueOf(j.getAtaque()));
					labelDefensa.setText(String.valueOf(j.getDefensa()));
					labelNombre.setText(j.getNombre());
					labelVida.setText(String.valueOf(j.getVida()) + "/500");
					lblExperiencia.setText(String.valueOf(j.getExperiencia()) + "/" + (String.valueOf(j.getMaxExp())));
					lblAtaqueE.setText(String.valueOf(e.getAtaque()));
					lblDefensaE.setText(String.valueOf(e.getDefensa()));
					lblNombreE.setText(e.getNombre());
					lblNivel.setText(String.valueOf(j.getNivel()));

					lblVidaE.setText(String.valueOf(e.getVida()) + "/500");
					frmJuegoDeLa.getContentPane().setBackground(new Color(67, 117, 196));

				} else {
					lblErrorElNombre.setVisible(true);
				}
			}
		});
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dañoJugador, dañoEnemigo, lot;
				double escaladoDefensa = 0, escaladoAtaque = 0;
				int vida = 500, color1 = 0, color2 = 0, color3 = 0;
				String nombre = "x";

				dañoJugador = e.getAtaque() - j.getDefensa();
				if (dañoJugador <= 0) {
					dañoJugador = 0;
				} else {
					j.setVida(j.getVida() - dañoJugador);
				}
				dañoEnemigo = j.getAtaque() - e.getDefensa();
				if (dañoEnemigo <= 0) {
					dañoEnemigo = 0;

				} else {
					e.setVida(e.getVida() - dañoEnemigo);

				}
				if (j.getVida() <= 0) {
					btnPocion.setVisible(false);
					scrollPane.setVisible(false);
					taTurnos.setVisible(false);
					lblEstadisticas.setVisible(false);
					lblEstadisticas1.setVisible(false);
					lblEstadisticas2.setVisible(false);
					lblEstadisticas3.setVisible(false);
					lblEstadisticas4.setVisible(false);
					lblEstadisticas5.setVisible(false);
					lblEstadisticasE.setVisible(false);
					lblEstadisticasE1.setVisible(false);
					lblEstadisticasE2.setVisible(false);
					lblEstadisticasE3.setVisible(false);
					lblEstadisticasE4.setVisible(false);
					lblAtaqueE.setVisible(false);
					lblDefensaE.setVisible(false);
					lblNombreE.setVisible(false);
					lblVidaE.setVisible(false);
					btnAtacar.setVisible(false);
					lblEnemigo.setVisible(false);
					labelAtaque.setVisible(false);
					labelDefensa.setVisible(false);
					labelNombre.setVisible(false);
					labelVida.setVisible(false);
					lblExperiencia.setVisible(false);
					lblGameover.setVisible(true);
					btnCerrar.setVisible(true);
					btnVolverAJugar.setVisible(true);
					lblNivelEstadistica.setVisible(false);
					lblNivel.setVisible(false);

					frmJuegoDeLa.getContentPane().setBackground(new Color(1, 1, 1));

				} else if (e.getVida() <= 0) {
					numeroEnemigos++;
					j.setNumeroPotis(j.getNumeroPotis() + 1);
					if (j.getNumeroPotis() > j.getMaximasPotis()) {
						j.setMaximasPotis(j.getNumeroPotis());
					} else if (j.getNumeroPotis() == j.getMaximasPotis()) {
						j.setMaximasPotis(j.getNumeroPotis());

					}
					Random numeroRandom = new Random();
					lot = numeroRandom.nextInt(22);
					taTurnos.setText(taTurnos.getText() + "\nHas derrotado a " + e.getNombre());
					taTurnos.setText(
							taTurnos.getText() + "\nPor derrotar a " + e.getNombre() + "\nhas coseguido 1 pociones");

					switch (lot) {
					case 0:
					case 1:
					case 2:
					case 3:
					case 4:
						e.setExperiencia(e.getExperiencia() * 2);
						taTurnos.setText(taTurnos.getText() + "\nHas coseguido el doble de exp");
						break;
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
						j.setNumeroPotis(j.getNumeroPotis() + 2);
						if (j.getNumeroPotis() > j.getMaximasPotis()) {
							j.setMaximasPotis(j.getNumeroPotis());
						} else if (j.getNumeroPotis() == j.getMaximasPotis()) {
							j.setMaximasPotis(j.getNumeroPotis());

						}
						taTurnos.setText(taTurnos.getText() + "\nEl" + e.getNombre() + "soltado 2 pociones ");
						btnPocion.setEnabled(true);
						break;
					case 10:
					case 11:
					case 12:
					case 13:
					case 14:
						j.setAtaque(j.getAtaque() + 30);
						taTurnos.setText(taTurnos.getText() + "\nHas coseguido una espada \n(mas 30 de ataque)");
						labelAtaque.setText(String.valueOf(j.getAtaque()));
						break;
					case 15:
					case 16:
					case 17:
					case 18:
					case 19:
						j.setDefensa(j.getDefensa() + 20);
						taTurnos.setText(taTurnos.getText() + "\nHas coseguido un escudo \n(mas 20 de defensa)");
						labelDefensa.setText(String.valueOf(j.getDefensa()));
						break;
					case 20:
					case 21:
					case 22:
						j.setNumeroPotis(j.getMaximasPotis());
						taTurnos.setText(taTurnos.getText() + "\nSea restablecido en numero de pociones");
						btnPocion.setText("Usar poción " + String.valueOf(j.getNumeroPotis()) + "/"
								+ String.valueOf(j.getMaximasPotis()));

					}
					j.setExperiencia(j.getExperiencia() + e.getExperiencia());
					if (j.getExperiencia() >= j.getMaxExp()) {
						j.setExperiencia((j.getExperiencia() - j.getMaxExp()));
						j.setMaxExp(j.getMaxExp() * 2);
						lblExperiencia
								.setText(String.valueOf(j.getExperiencia()) + "/" + (String.valueOf(j.getMaxExp())));
						j.setAtaque((int) Math.round((j.getAtaque() * 1.3)));
						j.setDefensa((int) Math.round((j.getDefensa() * 1.3)));
						j.setNivel(j.getNivel() + 1);
						lblNivel.setText(String.valueOf(j.getNivel()));
						labelAtaque.setText(String.valueOf(j.getAtaque()));
						labelDefensa.setText(String.valueOf(j.getDefensa()));
						taTurnos.setText(
								taTurnos.getText() + "\nHas coseguido " + String.valueOf(e.getExperiencia() + " exp"));
						taTurnos.setText(taTurnos.getText() + "\nHas subido de nivel");

					} else {
						lblExperiencia
								.setText(String.valueOf(j.getExperiencia()) + "/" + (String.valueOf(j.getMaxExp())));
						taTurnos.setText(
								taTurnos.getText() + "\nHas coseguido " + String.valueOf(e.getExperiencia() + " exp"));

					}
					btnPocion.setText("Usar poción " + String.valueOf(j.getNumeroPotis()) + "/"
							+ String.valueOf(j.getMaximasPotis()));
					ImageIcon imagen = new ImageIcon("img/" + String.valueOf(numeroEnemigos) + ".gif");
					Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblEnemigo.getWidth(),
							lblEnemigo.getHeight(), Image.SCALE_DEFAULT));
					lblEnemigo.setIcon(icono);
					// niveles
					switch (j.getNivel()) {
					case 1:
						escaladoAtaque = 0.9;
						escaladoDefensa = 0.35;
						break;
					case 2:
						escaladoAtaque = 0.95;
						escaladoDefensa = 0.4;
						break;
					case 3:
						escaladoAtaque = 1.05;
						escaladoDefensa = 0.45;
						break;

					case 4:
						escaladoAtaque = 1.05;
						escaladoDefensa = 0.5;
						break;
					case 5:
						escaladoAtaque = 1.1;
						escaladoDefensa = 0.55;
						break;
					default:
						escaladoAtaque = 1.3;
						escaladoDefensa = 0.6;

					}
					// enemigos
					switch (numeroEnemigos) {
					case 0:
						nombre = "Fantrasma";
						color1 = 67;
						color2 = 117;
						color3 = 196;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
					case 1:
						nombre = "Esqueleto";
						color1 = 70;
						color2 = 64;
						color3 = 83;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 2:
						nombre = "Fantrasma ninja";
						color1 = 50;
						color2 = 60;
						color3 = 57;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 3:
						nombre = "Espectro";
						color1 = 111;
						color2 = 111;
						color3 = 111;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;

					case 4:
						nombre = "Invocador";
						color1 = 89;
						color2 = 86;
						color3 = 82;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 5:
						nombre = "Energyco";
						color1 = 4;
						color2 = 49;
						color3 = 71;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + 10 + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 6:
						nombre = "Caballero";
						color1 = 60;
						color2 = 57;
						color3 = 62;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + 10 + numeroRandom.nextInt(50)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 7:
						nombre = "Infernico";
						color1 = 4;
						color2 = 49;
						color3 = 71;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + 15 + numeroRandom.nextInt(60)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(49)));
						break;
					case 8:
						nombre = "Supenium";
						color1 = 74;
						color2 = 70;
						color3 = 70;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + 15 + numeroRandom.nextInt(60)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(50)));
						break;
					case 9:
						nombre = "Final Boss";
						color1 = 72;
						color2 = 72;
						color3 = 72;
						vida = 2000;
						ataqueEnemigo = ((int) Math
								.round((j.getDefensa() * escaladoAtaque) + 25 + numeroRandom.nextInt(70)));
						defensaEnemigo = ((int) Math
								.round((j.getAtaque() * escaladoDefensa) + numeroRandom.nextInt(60)));
						break;
					case 10:
						btnPocion.setVisible(false);
						scrollPane.setVisible(false);
						taTurnos.setVisible(false);
						lblEstadisticas.setVisible(false);
						lblEstadisticas1.setVisible(false);
						lblEstadisticas2.setVisible(false);
						lblEstadisticas3.setVisible(false);
						lblEstadisticas4.setVisible(false);
						lblEstadisticas5.setVisible(false);
						lblEstadisticasE.setVisible(false);
						lblEstadisticasE1.setVisible(false);
						lblEstadisticasE2.setVisible(false);
						lblEstadisticasE3.setVisible(false);
						lblEstadisticasE4.setVisible(false);
						lblAtaqueE.setVisible(false);
						lblDefensaE.setVisible(false);
						lblNombreE.setVisible(false);
						lblVidaE.setVisible(false);
						btnAtacar.setVisible(false);
						lblEnemigo.setVisible(false);
						labelAtaque.setVisible(false);
						labelDefensa.setVisible(false);
						labelNombre.setVisible(false);
						labelVida.setVisible(false);
						lblExperiencia.setVisible(false);
						lblGameover.setVisible(true);
						btnCerrar.setVisible(true);
						btnVolverAJugar.setVisible(true);
						lblNivelEstadistica.setVisible(false);
						lblNivel.setVisible(false);
						ImageIcon win = new ImageIcon("img/win.jpeg");
						Icon ico = new ImageIcon(win.getImage().getScaledInstance(lblGameover.getWidth(),
								lblGameover.getHeight(), Image.SCALE_DEFAULT));
						lblGameover.setIcon(ico);
						break;

					}
					frmJuegoDeLa.getContentPane().setBackground(new Color(color1, color2, color3));
					e.setVida(vida);
					e.setAtaque(ataqueEnemigo);
					e.setDefensa(defensaEnemigo);
					e.setNombre(nombre);
					lblAtaqueE.setText(String.valueOf(e.getAtaque()));
					lblDefensaE.setText(String.valueOf(e.getDefensa()));
					lblNombreE.setText(e.getNombre());

				}
				lblVidaE.setText(String.valueOf(e.getVida()) + "/" + vida);
				labelVida.setText(String.valueOf(j.getVida()) + "/500");
				turnos++;
				if (turnos == 1) {
					taTurnos.setText(taTurnos.getText() + "Turno " + String.valueOf(turnos) + "\n" + j.getNombre()
							+ " ha infligido " + String.valueOf(dañoEnemigo) + "\n" + e.getNombre() + " ha infligido "
							+ String.valueOf(dañoJugador));
				} else {
					taTurnos.setText(taTurnos.getText() + "\nTurno " + String.valueOf(turnos) + "\n" + j.getNombre()
							+ " ha infilgido " + String.valueOf(dañoEnemigo) + "\n" + e.getNombre() + " ha infilgido "
							+ String.valueOf(dañoJugador));
				}

			}
		});
		btnPocion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vida;
				if (j.getNumeroPotis() != 0) {
					if (j.getVida() < 500) {
						vida = j.getVida();
						j.setVida(j.getVida() + 100);
						if (j.getVida() > 500) {
							taTurnos.setText(taTurnos.getText() + "\nTe has curado " + String.valueOf((500 - vida))
									+ " de vida");
							j.setVida(500);
						} else {
							taTurnos.setText(taTurnos.getText() + "\nTe has curado 100 de vida");

						}
						j.setNumeroPotis(j.numeroPotis - 1);
						btnPocion.setText("Usar poción " + String.valueOf(j.getNumeroPotis()) + "/"
								+ String.valueOf(j.getMaximasPotis()));
					} else {
						taTurnos.setText(taTurnos.getText() + "\nNo te puedes curar mas de 500");
					}
				} else {
					taTurnos.setText(taTurnos.getText() + "\nNo te quedan pociones");
					btnPocion.setEnabled(false);

				}
				labelVida.setText(String.valueOf(j.getVida()) + "/500");
			}

		});
		btnPulsaParaEmpezar.setBounds(380, 203, 228, 25);
		frmJuegoDeLa.getContentPane().add(btnPulsaParaEmpezar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 21);
		frmJuegoDeLa.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mntmCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnArchivo.add(mntmCargar);
		mntmCargar.setMnemonic(KeyEvent.VK_C);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		mntmGuardar.setMnemonic(KeyEvent.VK_G);
		
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					File f=new File("Archivo.txt");
					PrintWriter p=new PrintWriter(f);
					p.println(j.getNombre());
					p.println(j.getVida());
					p.println(j.getAtaque());
					p.println(j.getDefensa());
					p.println(j.getExperiencia());
					p.println(j.getMaxExp());
					p.println(j.getNivel());
					p.println(j.getMaximasPotis());
					p.println(j.getNumeroPotis());
					p.println(e.getNombre());
					p.println(e.getAtaque());
					p.println(e.getDefensa());
					p.println(e.getVida());
					p.println(numeroEnemigos);
					p.close();

				} catch (FileNotFoundException e1) {
					File f =new File("Archivo.txt");
					try {
						f.createNewFile();
						PrintWriter p=new PrintWriter(f);
						p.println(j.getNombre());
						p.println(j.getVida());
						p.println(j.getAtaque());
						p.println(j.getDefensa());
						p.println(j.getExperiencia());
						p.println(j.getMaxExp());
						p.println(j.getNivel());
						p.println(j.getMaximasPotis());
						p.println(j.getNumeroPotis());
						p.println(e.getNombre());
						p.println(e.getAtaque());
						p.println(e.getDefensa());
						p.println(e.getVida());
						p.println(numeroEnemigos);

						p.close();
					}catch(IOException e2) {
						System.out.println("No se pudo crear");
					}
				}
				
			}
		});
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setMnemonic(KeyEvent.VK_S);
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmJuegoDeLa.dispose();
			}
		});
		mnSalir.add(mntmSalir);

	}
}
