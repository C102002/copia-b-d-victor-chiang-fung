package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
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
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;

public class DialogVerHistoricos extends JDialog {
	SQLController sqlController = new SQLController();
	JDialog thisInstance = this;
	DefaultListModel<String> listModel = new DefaultListModel<>();
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogVerHistoricos dialog = new DialogVerHistoricos(null, 1);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void llenarHistoricos(DefaultListModel<String> listModel, int idEscuela) 
	{
		try {
			ResultSet datos = sqlController.SelectQuery("SELECT inte.idIntegrante, inte.primnom, inte.primap, inte.segap, hist.fechaingreso "
														+ "FROM vah_integrantes inte, vah_hist_integrantes hist "
														+  "WHERE (hist.idEscuela = " + idEscuela + ") AND (hist.idIntegrante = inte.idIntegrante) "
														+  "AND (hist.fechaRetiro is NULL);");
			while (datos.next()) 
			{
				listModel.addElement(datos.getString("primnom") + " " + datos.getString("primap") + " " + datos.getString("segap") + " " + datos.getDate("fechaIngreso").toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public DialogVerHistoricos(JFrame ventanaPadre, int idEscuela) {
		super(ventanaPadre);
		setModal(true);
		setBounds(100, 100, 431, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblTitulo = new JLabel("Cerrar Histórico");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitulo.setBounds(160, 11, 124, 17);
			contentPanel.add(lblTitulo);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 41, 395, 185);
			contentPanel.add(scrollPane);
			
			JList<String> list = new JList<>();
			scrollPane.setViewportView(list);
		
			llenarHistoricos(listModel, idEscuela);
			list.setModel(listModel);
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
