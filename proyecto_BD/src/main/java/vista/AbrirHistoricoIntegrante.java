package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AbrirHistoricoIntegrante extends JFrame {
	
	private SQLController sqlController = new SQLController();
	private ManejoDeString manejoDeString = new ManejoDeString();
	private ArrayList<Integer> arrayIdsIntegrantes = new ArrayList<>();
	private JFrame thisInstance = this;
	
	private JPanel contentPane;
	private JTextField txtField_AnioIngreso;
	private JTextField txtField_AnioRetiro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirHistoricoIntegrante frame = new AbrirHistoricoIntegrante(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void llenarIntegrantes(JComboBox<String> comboBox, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectCuatroCampos("vah_integrantes", "primnom", "primap", "segap", "idintegrante"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("primnom") + " " + datos.getString("primap") + " " + datos.getString("segap"));
				arrayIds.add(datos.getInt("idintegrante"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public AbrirHistoricoIntegrante(int idEscuela) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearHistórico = new JLabel("Crear Histórico");
		lblCrearHistórico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrearHistórico.setBounds(159, 11, 115, 17);
		contentPane.add(lblCrearHistórico);
		
		JLabel lblIntegrante = new JLabel("Integrante");
		lblIntegrante.setBounds(10, 54, 79, 14);
		contentPane.add(lblIntegrante);
		
		JComboBox<String> cmbBox_Integrante = new JComboBox<>();
		cmbBox_Integrante.setBounds(99, 50, 264, 22);
		contentPane.add(cmbBox_Integrante);
		
		llenarIntegrantes(cmbBox_Integrante, arrayIdsIntegrantes);
		
		
		JComboBox<String> cmbBox_DiaRetiro = new JComboBox<String>();
		cmbBox_DiaRetiro.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbBox_DiaRetiro.setEnabled(false);
		cmbBox_DiaRetiro.setBounds(133, 198, 48, 22);
		contentPane.add(cmbBox_DiaRetiro);
		
		JComboBox<String> cmbBox_MesRetiro = new JComboBox<String>();
		cmbBox_MesRetiro.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbBox_MesRetiro.setEnabled(false);
		cmbBox_MesRetiro.setBounds(185, 198, 48, 22);
		contentPane.add(cmbBox_MesRetiro);
		
		txtField_AnioRetiro = new JTextField();
		txtField_AnioRetiro.setEnabled(false);
		txtField_AnioRetiro.setColumns(10);
		txtField_AnioRetiro.setBounds(237, 199, 86, 20);
		contentPane.add(txtField_AnioRetiro);
		
		JRadioButton rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbBox_DiaRetiro.setEnabled(false);
				cmbBox_MesRetiro.setEnabled(false);
				txtField_AnioRetiro.setEnabled(false);
			}
		});
		rdbtnAbierto.setBounds(123, 168, 109, 23);
		contentPane.add(rdbtnAbierto);
		
		JRadioButton rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbBox_DiaRetiro.setEnabled(true);
				cmbBox_MesRetiro.setEnabled(true);
				txtField_AnioRetiro.setEnabled(true);
			}
		});
		rdbtnCerrado.setBounds(235, 168, 109, 23);
		contentPane.add(rdbtnCerrado);
		
		ButtonGroup grupoBtn_EstadoHistorico = new ButtonGroup();
		grupoBtn_EstadoHistorico.add(rdbtnAbierto);
		grupoBtn_EstadoHistorico.add(rdbtnCerrado);
		
		JLabel lblFechaIngreso = new JLabel("Fecha de Ingreso");
		lblFechaIngreso.setBounds(10, 109, 107, 14);
		contentPane.add(lblFechaIngreso);
		
		JComboBox<String> cmbBox_DiaIngreso = new JComboBox<String>();
		cmbBox_DiaIngreso.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbBox_DiaIngreso.setEnabled(false);
		cmbBox_DiaIngreso.setBounds(133, 135, 48, 22);
		contentPane.add(cmbBox_DiaIngreso);
		
		JComboBox<String> cmbBox_MesIngreso = new JComboBox<String>();
		cmbBox_MesIngreso.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbBox_MesIngreso.setEnabled(false);
		cmbBox_MesIngreso.setBounds(185, 135, 48, 22);
		contentPane.add(cmbBox_MesIngreso);
		
		txtField_AnioIngreso = new JTextField();
		txtField_AnioIngreso.setEnabled(false);
		txtField_AnioIngreso.setColumns(10);
		txtField_AnioIngreso.setBounds(237, 136, 86, 20);
		contentPane.add(txtField_AnioIngreso);
		
		JRadioButton rdbtnFechaActual = new JRadioButton("Fecha Actual");
		rdbtnFechaActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbBox_DiaIngreso.setEnabled(false);
				cmbBox_MesIngreso.setEnabled(false);
				txtField_AnioIngreso.setEnabled(false);
				
				rdbtnAbierto.doClick();
				rdbtnCerrado.setEnabled(false);
			}
		});
		rdbtnFechaActual.setBounds(123, 105, 109, 23);
		contentPane.add(rdbtnFechaActual);
		
		JRadioButton rdbtnOtraFecha = new JRadioButton("Otra Fecha");
		rdbtnOtraFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbBox_DiaIngreso.setEnabled(true);
				cmbBox_MesIngreso.setEnabled(true);
				txtField_AnioIngreso.setEnabled(true);
				
				rdbtnCerrado.setEnabled(true);
			}
		});
		rdbtnOtraFecha.setBounds(235, 105, 109, 23);
		contentPane.add(rdbtnOtraFecha);
		
		ButtonGroup grupoBtn_Fecha = new ButtonGroup();
		grupoBtn_Fecha.add(rdbtnFechaActual);
		grupoBtn_Fecha.add(rdbtnOtraFecha);
		
		JLabel lblEstadoDelHistorico = new JLabel("Estado del Histórico");
		lblEstadoDelHistorico.setBounds(10, 172, 107, 14);
		contentPane.add(lblEstadoDelHistorico);
		
		JLabel lblAutoridad = new JLabel("Autoridad");
		lblAutoridad.setBounds(10, 249, 107, 14);
		contentPane.add(lblAutoridad);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(123, 245, 109, 23);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(235, 245, 109, 23);
		contentPane.add(rdbtnNo);
		
		ButtonGroup grupoBtn_Autoridad = new ButtonGroup();
		grupoBtn_Autoridad.add(rdbtnSi);
		grupoBtn_Autoridad.add(rdbtnNo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuHistoricoIntegrantes frame = new MenuHistoricoIntegrantes(idEscuela);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(10, 297, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarHistorico = new JButton("Registrar Histórico");
		btnRegistrarHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaIngreso = null;
				
				if (rdbtnFechaActual.isSelected()) 
				{
					fechaIngreso = new Date(System.currentTimeMillis());
				} else if (rdbtnOtraFecha.isSelected()) 
				{
					if (!manejoDeString.esVacio(txtField_AnioIngreso.getText()) && manejoDeString.ValidarInt(txtField_AnioIngreso.getText())) 
					{
						String ingreso = txtField_AnioIngreso.getText() + "-" + cmbBox_MesIngreso.getSelectedItem().toString() + "-" + cmbBox_DiaIngreso.getSelectedItem().toString();
						fechaIngreso = Date.valueOf(ingreso);
						
					} else if (!manejoDeString.ValidarInt(txtField_AnioIngreso.getText()))
					{
						JOptionPane.showMessageDialog(thisInstance, "Caracteres inválidos en el campo Año de Ingreso", "Error", JOptionPane.ERROR_MESSAGE);
					} else 
					{
						JOptionPane.showMessageDialog(thisInstance, "Ingrese un año en el campo Año de Ingreso", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else 
				{
					JOptionPane.showMessageDialog(thisInstance, "Seleccione una opción para Fecha de Ingreso", "Error", JOptionPane.ERROR_MESSAGE);
				} 
				
				Date fechaRetiro = null;
				boolean histAbierto = false;
				if (rdbtnAbierto.isSelected()) 
				{
					histAbierto = true;
				} else if (rdbtnCerrado.isSelected()) 
				{
					if (!manejoDeString.esVacio(txtField_AnioRetiro.getText()) && manejoDeString.ValidarInt(txtField_AnioRetiro.getText()) ) 
					{
						String retiro = txtField_AnioRetiro.getText() + "-" + cmbBox_MesRetiro.getSelectedItem().toString() + "-" + cmbBox_DiaRetiro.getSelectedItem().toString();
						fechaRetiro = Date.valueOf(retiro);
						
					} else if (!manejoDeString.ValidarInt(txtField_AnioRetiro.getText()))
					{
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Año de Retiro", "Error", JOptionPane.ERROR_MESSAGE);
					} else 
					{
						JOptionPane.showMessageDialog(thisInstance, "Ingrese un año en el campo Año de Retiro", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else 
				{
					JOptionPane.showMessageDialog(thisInstance, "Seleccione una opción para Estado del Histórico", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				boolean validarFechas = true;
				if (fechaRetiro != null) 
				{
					if (fechaIngreso.after(fechaRetiro)) 
					{
						validarFechas = false;
						JOptionPane.showMessageDialog(thisInstance, "Fecha de Ingreso no puede ser mayor que Fecha de Retiro", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (rdbtnSi.isSelected() || rdbtnNo.isSelected()) 
				{
					if (fechaIngreso != null) 
					{
						int idIntegrante = arrayIdsIntegrantes.get(cmbBox_Integrante.getSelectedIndex());
						SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
						String stringIngreso = "'" + formato.format(fechaIngreso).toString() + "'";
						String stringRetiro = "null";
						
						if (fechaRetiro != null) 
						{
							stringRetiro = "'" + formato.format(fechaRetiro).toString() + "'";
						}
						
						String autoridad;
						if (rdbtnSi.isSelected()) 
						{
							autoridad = "'SI'";
						} else 
						{
							autoridad = "'NO'";
						}
						
						try {
							
							sqlController.CerrarHistoricoIntegranteAbierto(idIntegrante);
							
							
							sqlController.UpdateQuery("INSERT INTO vah_hist_integrantes "
													+ "VALUES (" + idEscuela + ", " + idIntegrante + ", " + stringIngreso + ", " + autoridad 
													+ ", " + stringRetiro + ");");
							
							JOptionPane.showMessageDialog(thisInstance, "Registro exitoso", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
							
							MenuHistoricoIntegrantes frame = new MenuHistoricoIntegrantes(idEscuela);
							frame.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else 
				{
					JOptionPane.showMessageDialog(thisInstance, "Seleccione una opción para Autoridad", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnRegistrarHistorico.setBounds(147, 290, 127, 36);
		contentPane.add(btnRegistrarHistorico);
	}
}
