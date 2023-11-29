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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AgregarHabilidad extends JDialog {
	private SQLController sqlController = new SQLController();
	private ManejoDeString manejoDeString = new ManejoDeString();
	private JDialog thisInstance = this;
	
	private JPanel contentPane;
	private JTextField txtField_Nombre;
	private JTextField txtField_Descripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarHabilidad frame = new AgregarHabilidad(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarHabilidad(JFrame ventanaPadre) {
		super(ventanaPadre);
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarHabilidad = new JLabel("Agregar Habilidad");
		lblAgregarHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgregarHabilidad.setBounds(169, 11, 123, 17);
		contentPane.add(lblAgregarHabilidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 73, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(10, 124, 68, 14);
		contentPane.add(lblDescripcion);
		
		txtField_Nombre = new JTextField();
		txtField_Nombre.setBounds(76, 70, 174, 20);
		contentPane.add(txtField_Nombre);
		txtField_Nombre.setColumns(10);
		
		txtField_Descripcion = new JTextField();
		txtField_Descripcion.setBounds(87, 121, 319, 20);
		contentPane.add(txtField_Descripcion);
		txtField_Descripcion.setColumns(10);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancelar.setBounds(10, 227, 89, 23);
		contentPane.add(Cancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!manejoDeString.esVacio(txtField_Nombre.getText()) && !manejoDeString.esVacio(txtField_Descripcion.getText())) 
				{
					if (manejoDeString.ValidarString(txtField_Nombre.getText()) && manejoDeString.ValidarString(txtField_Descripcion.getText())) 
					{
						try {
							sqlController.UpdateQuery("INSERT INTO vah_habilidades(nombre, descripcion) "
													+  "VALUES ('" + txtField_Nombre.getText().toUpperCase() + "', '" + txtField_Descripcion.getText() + "');");
							JOptionPane.showMessageDialog(thisInstance, "Se registró la habilidad exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						dispose();
					} else 
					{
						JOptionPane.showMessageDialog(thisInstance, "Caracteres inválidos en alguno de los campos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else 
				{
					JOptionPane.showMessageDialog(thisInstance, "No puede dejar los campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAgregar.setBounds(156, 166, 102, 33);
		contentPane.add(btnAgregar);
	}
}
