package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.SQLController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class DialogLlenarRol extends JDialog {
	SQLController sqlController = new SQLController();
	JDialog thisInstance = this;
	
	ArrayList<Integer> arrayIDsRoles = new ArrayList<>();
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLlenarRol dialog = new DialogLlenarRol(null, 1, 1, "1-1-1987", "'1-1-2000'", " ");
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void llenarRoles(JComboBox<String> comboBox, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectDosCampos("vah_roles", "nombreRol", "idRol"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("nombreRol"));
				arrayIds.add(datos.getInt("idRol"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public DialogLlenarRol(JFrame ventanaPadre, int idEscuela, int idIntegrante, String fechaIngreso, String AnioCarnaval, String nombreIntegrante) {
		super(ventanaPadre);
		setModal(true);
		setBounds(100, 100, 431, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblTitulo = new JLabel("Rol de ");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitulo.setBounds(97, 11, 301, 17);
			contentPanel.add(lblTitulo);
		
		
			JLabel lblRol = new JLabel("Rol");
			lblRol.setBounds(10, 75, 63, 14);
			contentPanel.add(lblRol);
		
		
			JComboBox<String> cmbBox_Roles = new JComboBox<>();
			cmbBox_Roles.setBounds(60, 71, 178, 22);
			contentPanel.add(cmbBox_Roles);
			llenarRoles(cmbBox_Roles, arrayIDsRoles);
		
		
			JButton btnAgregarRol = new JButton("Agregar Rol");
			btnAgregarRol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AgregarRol agregarRol = new AgregarRol(thisInstance);
					agregarRol.setVisible(true);
					
					llenarRoles(cmbBox_Roles, arrayIDsRoles);
				}
			});
			btnAgregarRol.setBounds(282, 66, 114, 48);
			contentPanel.add(btnAgregarRol);
		
		
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							sqlController.UpdateQuery("INSERT INTO vah_org_carnavales "
													+  "VALUES (" + idEscuela + ", " + idIntegrante + ", '" + fechaIngreso + "', " + arrayIDsRoles.get(cmbBox_Roles.getSelectedIndex())
													+ ", " + AnioCarnaval + ");");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		
	}

}
