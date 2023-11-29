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

public class DialogCerrarHistorico extends JDialog {
	SQLController sqlController = new SQLController();
	JDialog thisInstance = this;
	
	ArrayList<Integer> arrayIDsIntegrantes = new ArrayList<>();
	ArrayList<String> arrayFechasRegistro = new ArrayList<>();
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCerrarHistorico dialog = new DialogCerrarHistorico(null, 1);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void llenarHistoricos(JComboBox<String> comboBox, ArrayList<Integer> arrayIds, ArrayList<String> arrayFechas, int idEscuela) 
	{
		try {
			ResultSet datos = sqlController.SelectQuery("SELECT inte.idIntegrante, inte.primnom, inte.primap, inte.segap, hist.fechaingreso "
														+ "FROM vah_integrantes inte, vah_hist_integrantes hist "
														+  "WHERE (hist.idEscuela = " + idEscuela + ") AND (hist.idIntegrante = inte.idIntegrante) "
														+  "AND (hist.fechaRetiro is NULL);");
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("primnom") + " " + datos.getString("primap") + " " + datos.getString("segap") + " " + datos.getDate("fechaIngreso").toString());
				arrayIds.add(datos.getInt("idintegrante"));
				arrayFechas.add(datos.getDate("fechaingreso").toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public DialogCerrarHistorico(JFrame ventanaPadre, int idEscuela) {
		super(ventanaPadre);
		setModal(true);
		setBounds(100, 100, 431, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblTitulo = new JLabel("Cerrar Histórico");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitulo.setBounds(97, 11, 301, 17);
			contentPanel.add(lblTitulo);
		
		
			JLabel lblHistorico = new JLabel("Historico");
			lblHistorico.setBounds(10, 75, 63, 14);
			contentPanel.add(lblHistorico);
		
		
			JComboBox<String> cmbBox_Historicos = new JComboBox<>();
			cmbBox_Historicos.setBounds(74, 71, 313, 22);
			contentPanel.add(cmbBox_Historicos);
			llenarHistoricos(cmbBox_Historicos, arrayIDsIntegrantes, arrayFechasRegistro, idEscuela);
		
		
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!arrayIDsIntegrantes.isEmpty()) 
						{
							try {
								sqlController.CerrarHistoricoIntegranteAbierto(arrayIDsIntegrantes.get(cmbBox_Historicos.getSelectedIndex()));
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
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
