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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DialogLlenarDatosParentesco extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SQLController sqlController = new SQLController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLlenarDatosParentesco dialog = new DialogLlenarDatosParentesco(null, -1, -1, " ");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLlenarDatosParentesco(JFrame ventanaRegistrarIntegrante ,int idIntegrante, int idPariente, String nombrePariente) {
		super(ventanaRegistrarIntegrante);
		setModal(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{ 
			JLabel lblTitulo = new JLabel("Relación con " + nombrePariente);
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitulo.setBounds(72, 11, 352, 22);
			contentPanel.add(lblTitulo);
		}
		
		JLabel lblTipoParentesco = new JLabel("Tipo de Parentesco");
		lblTipoParentesco.setBounds(10, 68, 141, 14);
		contentPanel.add(lblTipoParentesco);
		
		JLabel lblRelacion = new JLabel("Relación");
		lblRelacion.setBounds(10, 123, 63, 14);
		contentPanel.add(lblRelacion);
		
		JComboBox<String> cmbBox_Relacion = new JComboBox<>();
		cmbBox_Relacion.setModel(new DefaultComboBoxModel<>(new String[] {"Padre/Madre", "Abuelo/Abuela", "Hermano/Hermana", "Primo/Prima", "Tio/Tia"}));
		cmbBox_Relacion.setBounds(66, 119, 181, 22);
		contentPanel.add(cmbBox_Relacion);
		
		JComboBox<String> cmbBox_TipoParentesco = new JComboBox<>();
		cmbBox_TipoParentesco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cmbBox_TipoParentesco.getSelectedIndex()) {
				case 0:
					cmbBox_Relacion.setModel(new DefaultComboBoxModel<>(new String[] {"Padre/Madre", "Abuelo/Abuela", "Hermano/Hermana", "Primo/Prima", "Tio/Tia"}));
				break;
				
				case 1:
					cmbBox_Relacion.setModel(new DefaultComboBoxModel<>(new String[] {"Esposo/Esposa", "Suegro/Suegra", "Cuñado/Cuñada"}));
				break;
			}
			}
		});
		
		
		cmbBox_TipoParentesco.setModel(new DefaultComboBoxModel<>(new String[] {"Sanguínea", "Política"}));
		cmbBox_TipoParentesco.setBounds(134, 64, 124, 22);
		contentPanel.add(cmbBox_TipoParentesco);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String tipoParentesco = cmbBox_TipoParentesco.getSelectedItem().toString();
						String relacion = cmbBox_Relacion.getSelectedItem().toString();
						
						try {
							sqlController.UpdateQuery("INSERT INTO vah_parentescos VALUES (" + idIntegrante + "," + idPariente + ",'" + tipoParentesco.charAt(0) + "','" + relacion + "');");
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
}
