package ejercicio5tema8;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio5tema8 {

	private JFrame frame;
	private JTable table;
	private JTextField tFcodigoC;
	private JTextField tFNombreC;
	private JTextField tFPrecioC;
	private JTextField tFUnidadesC;
	private JTextField tFNuevoPrecio;
	private JTextField tFaddStock;
	private JTextField tfVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5tema8 window = new Ejercicio5tema8();
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
	public Ejercicio5tema8() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public static void mostrar(DefaultTableModel model) {
		if (model.getRowCount() > 0) {
			model.setRowCount(0);
		}
		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Producto");
			while (rs.next()) {
				Object[] row = new Object[4];
				row[0] = rs.getInt("Codigo");
				row[1] = rs.getString("nombre");
				row[2] = rs.getDouble("precio");
				row[3] = rs.getInt("unidades");

				model.addRow(row);
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException ex) { // Caso erróneo
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Precio");
		model.addColumn("Unidades");
		table = new JTable(model);
		table.setBounds(22, 49, 340, 174);
		frame.getContentPane().add(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(22, 49, 349, 171);
		frame.getContentPane().add(scrollPane);
		mostrar(model);

		JButton btnMostrar = new JButton("Mostrar");

		btnMostrar.setBounds(136, 12, 117, 25);
		frame.getContentPane().add(btnMostrar);

		JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
		lblNuevoProducto.setBounds(22, 235, 116, 15);
		frame.getContentPane().add(lblNuevoProducto);

		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(22, 273, 64, 15);
		frame.getContentPane().add(lblCdigo);

		tFcodigoC = new JTextField();
		tFcodigoC.setBounds(99, 273, 76, 15);
		frame.getContentPane().add(tFcodigoC);
		tFcodigoC.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 302, 64, 15);
		frame.getContentPane().add(lblNombre);

		tFNombreC = new JTextField();
		tFNombreC.setBounds(99, 302, 76, 15);
		frame.getContentPane().add(tFNombreC);
		tFNombreC.setColumns(10);

		tFPrecioC = new JTextField();
		tFPrecioC.setColumns(10);
		tFPrecioC.setBounds(99, 331, 76, 15);
		frame.getContentPane().add(tFPrecioC);

		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setBounds(22, 331, 64, 15);
		frame.getContentPane().add(lblPrecio_1);

		JButton btnAnydir = new JButton("Añadir");

		btnAnydir.setBounds(22, 387, 117, 25);
		frame.getContentPane().add(btnAnydir);

		JLabel lblBorrarProducto = new JLabel("Borrar producto:");
		lblBorrarProducto.setBounds(253, 235, 118, 15);
		frame.getContentPane().add(lblBorrarProducto);

		JLabel lblEligeProducto = new JLabel("Elige producto:");
		lblEligeProducto.setBounds(208, 273, 118, 15);
		frame.getContentPane().add(lblEligeProducto);

		JComboBox cBIdproductoB = new JComboBox();
		cBIdproductoB.setBounds(323, 268, 64, 24);
		frame.getContentPane().add(cBIdproductoB);

		JButton btnBorrar = new JButton("Borrar");

		btnBorrar.setBounds(254, 297, 117, 25);
		frame.getContentPane().add(btnBorrar);

		JLabel lblIncrementar = new JLabel("Incrementar stock:");
		lblIncrementar.setBounds(469, 49, 149, 15);
		frame.getContentPane().add(lblIncrementar);

		JLabel lblActualizarPrecio = new JLabel("Actualizar precio:");
		lblActualizarPrecio.setBounds(253, 329, 134, 15);
		frame.getContentPane().add(lblActualizarPrecio);

		JLabel lblEligeProducto_1_1 = new JLabel("Elige producto:");
		lblEligeProducto_1_1.setBounds(208, 356, 118, 15);
		frame.getContentPane().add(lblEligeProducto_1_1);

		JComboBox cBIdproductoAP = new JComboBox();
		cBIdproductoAP.setBounds(323, 351, 64, 24);
		frame.getContentPane().add(cBIdproductoAP);

		JButton btnActualizarPrecio = new JButton("Actualizar precio");

		btnActualizarPrecio.setBounds(229, 409, 158, 25);
		frame.getContentPane().add(btnActualizarPrecio);

		tFUnidadesC = new JTextField();
		tFUnidadesC.setColumns(10);
		tFUnidadesC.setBounds(99, 356, 76, 15);
		frame.getContentPane().add(tFUnidadesC);

		JLabel lblUnidades = new JLabel("Unidades:");
		lblUnidades.setBounds(22, 356, 76, 15);
		frame.getContentPane().add(lblUnidades);

		tFNuevoPrecio = new JTextField();
		tFNuevoPrecio.setColumns(10);
		tFNuevoPrecio.setBounds(322, 387, 49, 15);
		frame.getContentPane().add(tFNuevoPrecio);

		JLabel lblnuevoPrecio = new JLabel("Nuevo precio:");
		lblnuevoPrecio.setBounds(208, 387, 107, 15);
		frame.getContentPane().add(lblnuevoPrecio);

		JLabel lblEligeProducto_1_1_2 = new JLabel("Elige producto:");
		lblEligeProducto_1_1_2.setBounds(408, 81, 118, 15);
		frame.getContentPane().add(lblEligeProducto_1_1_2);

		JComboBox cBIdproductoIS = new JComboBox();
		cBIdproductoIS.setBounds(589, 76, 64, 24);
		frame.getContentPane().add(cBIdproductoIS);

		JLabel lblUnidadesAdquiridads = new JLabel("Unidades adquiridads:");
		lblUnidadesAdquiridads.setBounds(408, 112, 173, 15);
		frame.getContentPane().add(lblUnidadesAdquiridads);

		tFaddStock = new JTextField();
		tFaddStock.setColumns(10);
		tFaddStock.setBounds(588, 112, 49, 15);
		frame.getContentPane().add(tFaddStock);

		JButton btnActualizarStock = new JButton("Actualizar stock");

		btnActualizarStock.setBounds(469, 134, 158, 25);
		frame.getContentPane().add(btnActualizarStock);

		JButton btnVender = new JButton("Vender");

		btnVender.setBounds(480, 320, 158, 25);
		frame.getContentPane().add(btnVender);

		JLabel lblUnidadesAVender = new JLabel("Unidades a vender:");
		lblUnidadesAVender.setBounds(419, 298, 173, 15);
		frame.getContentPane().add(lblUnidadesAVender);

		tfVenta = new JTextField();
		tfVenta.setColumns(10);
		tfVenta.setBounds(599, 298, 49, 15);
		frame.getContentPane().add(tfVenta);

		JComboBox cBIdproductoV = new JComboBox();
		cBIdproductoV.setBounds(600, 262, 64, 24);
		frame.getContentPane().add(cBIdproductoV);

		JLabel lblEligeProducto_1_1_2_1 = new JLabel("Elige producto:");
		lblEligeProducto_1_1_2_1.setBounds(419, 267, 118, 15);
		frame.getContentPane().add(lblEligeProducto_1_1_2_1);

		JLabel lblVenta = new JLabel("Venta:");
		lblVenta.setBounds(480, 235, 149, 15);
		frame.getContentPane().add(lblVenta);

		actualizarComboBoxes(cBIdproductoIS, cBIdproductoV, cBIdproductoB, cBIdproductoAP);

		JLabel lblGanancias = new JLabel("Las ganancias totales son:");
		lblGanancias.setBounds(419, 356, 192, 15);
		frame.getContentPane().add(lblGanancias);
		
		JLabel lblganancia = new JLabel("0");
		lblganancia.setBounds(623, 356, 70, 15);
		frame.getContentPane().add(lblganancia);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar(model);
				actualizarComboBoxes(cBIdproductoIS, cBIdproductoV, cBIdproductoB, cBIdproductoAP);

			}
		});

		btnAnydir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_pstmt = con.prepareStatement(
							"INSERT INTO Producto (Codigo, nombre, precio, unidades) VALUES (?,?,?,?)");

					ins_pstmt.setInt(1, Integer.valueOf(tFcodigoC.getText()));
					ins_pstmt.setString(2, tFNombreC.getText());
					ins_pstmt.setDouble(3, Double.valueOf(tFPrecioC.getText()));
					ins_pstmt.setInt(4, Integer.valueOf(tFUnidadesC.getText()));
					ins_pstmt.executeUpdate();

					ins_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

				mostrar(model);
				actualizarComboBoxes(cBIdproductoIS, cBIdproductoV, cBIdproductoB, cBIdproductoAP);
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement del_pstmt = con.prepareStatement("DELETE FROM Producto WHERE Codigo = ?");

					del_pstmt.setInt(1, Integer.valueOf(String.valueOf(cBIdproductoB.getSelectedItem())));
					del_pstmt.executeUpdate();

					del_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

				mostrar(model);
				actualizarComboBoxes(cBIdproductoIS, cBIdproductoV, cBIdproductoB, cBIdproductoAP);
			}
		});
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double ganancia=Double.valueOf(lblganancia.getText());

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement stmt = con.prepareStatement("Select * from Producto where Codigo= ?");
					stmt.setInt(1, Integer.valueOf(String.valueOf(cBIdproductoV.getSelectedItem())));
					ResultSet rs_sel = stmt.executeQuery();
					int unidadesProducto=0;
					double precio=0;
					
					while (rs_sel.next()) {
					unidadesProducto = rs_sel.getInt("unidades");
					precio = rs_sel.getDouble("precio");
					}
					
					int unidadesUsuario = Integer.valueOf(tfVenta.getText());
					if (unidadesProducto < unidadesUsuario) {
						ganancia =ganancia+(unidadesProducto * precio);
						unidadesProducto = 0;
						JOptionPane.showMessageDialog(null, "Producto vendido a sus maximas unidades");
					} else {
						ganancia = ganancia+(unidadesUsuario * precio);
						unidadesProducto = unidadesProducto - unidadesUsuario;

					}
					stmt.close();
					rs_sel.close();
					lblganancia.setText(String.valueOf(ganancia));
					PreparedStatement upd_pstmt = con
							.prepareStatement("UPDATE Producto SET unidades = ? WHERE Codigo = ?");
					upd_pstmt.setInt(1, unidadesProducto);
					upd_pstmt.setInt(2, Integer.valueOf(String.valueOf(cBIdproductoV.getSelectedItem())));
					upd_pstmt.executeUpdate();

					upd_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Producto vendido correctamente");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				mostrar(model);

			}
		});
		btnActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement upd_pstmt = con
							.prepareStatement("UPDATE Producto SET unidades = unidades+ ? WHERE Codigo = ?");
					upd_pstmt.setInt(1, Integer.valueOf(tFaddStock.getText()));
					upd_pstmt.setInt(2, Integer.valueOf(String.valueOf(cBIdproductoIS.getSelectedItem())));
					upd_pstmt.executeUpdate();

					upd_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				mostrar(model);

			}
		});
		btnActualizarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement upd_pstmt = con
							.prepareStatement("UPDATE Producto SET precio = ? WHERE Codigo = ?");
					upd_pstmt.setDouble(1, Double.valueOf(tFNuevoPrecio.getText()));
					upd_pstmt.setInt(2, Integer.valueOf(String.valueOf(cBIdproductoAP.getSelectedItem())));
					upd_pstmt.executeUpdate();

					upd_pstmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				mostrar(model);

			}
		});
	}

	public static void actualizarComboBoxes(JComboBox cBIdproductoIS, JComboBox cBIdproductoV, JComboBox cBIdproductoB,
			JComboBox cBIdproductoAP) {

		cBIdproductoV.removeAllItems();
		cBIdproductoIS.removeAllItems();
		cBIdproductoB.removeAllItems();
		cBIdproductoAP.removeAllItems();

		try {
			Connection con = ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Codigo FROM Producto");
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("Codigo"));
				cBIdproductoV.addItem(id);
				cBIdproductoIS.addItem(id);
				cBIdproductoB.addItem(id);
				cBIdproductoAP.addItem(id);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
