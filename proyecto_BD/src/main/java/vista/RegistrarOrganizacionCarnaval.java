package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class RegistrarOrganizacionCarnaval extends JFrame {
	SQLController sqlController = new SQLController();
	ManejoDeString manejoDeString = new ManejoDeString();
	JFrame thisInstance = this;
	
	ArrayList<Integer> arrayIDsIntegrantes = new ArrayList<>();
	ArrayList<Integer> arrayIDsIntegrantesAConectar = new ArrayList<>();
	ArrayList<String> arrayFechasIngresoIntegrantes = new ArrayList<>();
	ArrayList<String> arrayListNombresIntegrantesAConectar = new ArrayList<>();
	ArrayList<String> arrayFechasIngresoIntegrantesAConectar = new ArrayList<>();
	private boolean booting = true;
	
	DefaultListModel<String> listModel_Integrantes = new DefaultListModel<>();
	
	private JPanel contentPane;
	private JTextField txtField_AnioCarnaval;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarOrganizacionCarnaval frame = new RegistrarOrganizacionCarnaval(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void llenarIntegrantes(JComboBox<String> comboBox, ArrayList<Integer> arrayIds, ArrayList<String> arrayFechas, int idEscuela) 
	{
		try {
			ResultSet datos = sqlController.SelectQuery("SELECT inte.idIntegrante, inte.primnom, inte.primap, inte.segap, hist.fechaIngreso "
														+ "FROM vah_integrantes inte, vah_hist_integrantes hist "
														+   "WHERE (hist.idEscuela = " + idEscuela + ") AND (hist.idIntegrante = inte.idIntegrante) "
														+   "AND (hist.fechaRetiro is NULL);"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("primnom") + " " + datos.getString("primap") + " " + datos.getString("segap"));
				arrayIds.add(datos.getInt("idintegrante"));
				arrayFechas.add(datos.getDate("fechaIngreso").toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public RegistrarOrganizacionCarnaval(int idEscuela) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrganizacionCarnaval = new JLabel("Organización del Carnaval");
		lblOrganizacionCarnaval.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrganizacionCarnaval.setBounds(138, 11, 180, 17);
		contentPane.add(lblOrganizacionCarnaval);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setBounds(10, 63, 46, 14);
		contentPane.add(lblAnio);
		
		JRadioButton rdbtnActual = new JRadioButton("Actual");
		rdbtnActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField_AnioCarnaval.setEnabled(false);
			}
		});
		rdbtnActual.setBounds(59, 59, 77, 23);
		contentPane.add(rdbtnActual);
		
		JRadioButton rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField_AnioCarnaval.setEnabled(true);
			}
		});
		rdbtnOtro.setBounds(138, 59, 62, 23);
		contentPane.add(rdbtnOtro);
		
		ButtonGroup grupoBtn_AnioCarnaval = new ButtonGroup();
		grupoBtn_AnioCarnaval.add(rdbtnActual);
		grupoBtn_AnioCarnaval.add(rdbtnOtro);
		
		txtField_AnioCarnaval = new JTextField();
		txtField_AnioCarnaval.setEnabled(false);
		txtField_AnioCarnaval.setColumns(10);
		txtField_AnioCarnaval.setBounds(206, 60, 86, 20);
		contentPane.add(txtField_AnioCarnaval);
		
		JScrollPane scrlPane_Integrantes = new JScrollPane();
		scrlPane_Integrantes.setBounds(106, 152, 280, 98);
		contentPane.add(scrlPane_Integrantes);
		
		JList<String> jlist_Integrantes = new JList<>();
		scrlPane_Integrantes.setViewportView(jlist_Integrantes);
		
		JComboBox<String> cmbBox_Integrantes = new JComboBox<String>();
		cmbBox_Integrantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!booting) 
				{
					if (!arrayIDsIntegrantesAConectar.contains(arrayIDsIntegrantes.get(cmbBox_Integrantes.getSelectedIndex()))) 
					{
						arrayIDsIntegrantesAConectar.add(arrayIDsIntegrantes.get(cmbBox_Integrantes.getSelectedIndex()));
						arrayFechasIngresoIntegrantesAConectar.add(arrayFechasIngresoIntegrantes.get(cmbBox_Integrantes.getSelectedIndex()));
						arrayListNombresIntegrantesAConectar.add(cmbBox_Integrantes.getSelectedItem().toString());
						listModel_Integrantes.addElement(cmbBox_Integrantes.getItemAt(cmbBox_Integrantes.getSelectedIndex()));
						jlist_Integrantes.setModel(listModel_Integrantes);
					}
				}
			}
		});
		cmbBox_Integrantes.setBounds(106, 110, 280, 22);
		contentPane.add(cmbBox_Integrantes);
		
		llenarIntegrantes(cmbBox_Integrantes, arrayIDsIntegrantes, arrayFechasIngresoIntegrantes, idEscuela);
		
		JLabel lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(10, 114, 86, 14);
		contentPane.add(lblIntegrantes);
		
		JButton btnEliminarIntegrante = new JButton("Eliminar");
		btnEliminarIntegrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayIDsIntegrantesAConectar.remove(jlist_Integrantes.getSelectedIndex());
				arrayListNombresIntegrantesAConectar.remove(jlist_Integrantes.getSelectedIndex());
				arrayListNombresIntegrantesAConectar.remove(jlist_Integrantes.getSelectedIndex());
				listModel_Integrantes.remove(jlist_Integrantes.getSelectedIndex());
				jlist_Integrantes.setModel(listModel_Integrantes);
			}
		});
		btnEliminarIntegrante.setBounds(7, 166, 89, 23);
		contentPane.add(btnEliminarIntegrante);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(7, 267, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnGuardarOrganizacion = new JButton("Guardar");
		btnGuardarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String anioCarnaval = null;
				if(rdbtnActual.isSelected()) 
				{
					try {
						ResultSet anioActual = sqlController.SelectQuery("SELECT EXTRACT('Year' FROM CURRENT_DATE);");
						if(anioActual.next()) 
						{
							anioCarnaval = "'1-1-" + anioActual.getInt(1) + "'";
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else if (rdbtnOtro.isSelected())
				{
					if(!manejoDeString.esVacio(txtField_AnioCarnaval.getText()) && manejoDeString.ValidarInt(txtField_AnioCarnaval.getText()))
					{
						anioCarnaval = "to_date(" + txtField_AnioCarnaval.getText() + ", 'YYYY')";
					} else if (manejoDeString.ValidarInt(txtField_AnioCarnaval.getText())) 
					{
						JOptionPane.showMessageDialog(thisInstance, "Caracteres inválidos en el campo Año de Carnaval", "Error", JOptionPane.ERROR_MESSAGE);
					} else 
					{
						JOptionPane.showMessageDialog(thisInstance, "Ingrese un año en el campo Año de Carnaval", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else 
				{
					JOptionPane.showMessageDialog(thisInstance, "Seleccione una opción para Año del Carnaval", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (anioCarnaval != null) 
				{
					int indice = 0;
					for (Integer idIntegrante : arrayIDsIntegrantesAConectar) 
					{
						DialogLlenarRol dialogRol = new DialogLlenarRol(thisInstance, idEscuela, idIntegrante, arrayFechasIngresoIntegrantesAConectar.get(indice), anioCarnaval, arrayListNombresIntegrantesAConectar.get(indice));
						dialogRol.setVisible(true);
						indice++;
					}
					
					JOptionPane.showMessageDialog(thisInstance, "Se registró la organización para el carnaval exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
				}
			}
		});
		btnGuardarOrganizacion.setBounds(7, 200, 89, 40);
		contentPane.add(btnGuardarOrganizacion);
		
		
		
		booting = false;
	}
}
