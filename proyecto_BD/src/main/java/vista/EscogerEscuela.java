package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.SQLController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EscogerEscuela extends JFrame {
	private SQLController sqlController = new SQLController();
	
	private ArrayList<Integer> arrayIdsEscuelas = new ArrayList<>();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscogerEscuela frame = new EscogerEscuela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void llenarEscuelas(JComboBox<String> comboBox, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectDosCampos("vah_escuelas", "nombre", "idEscuela"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("nombre"));
				arrayIds.add(datos.getInt("idescuela"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public EscogerEscuela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoger Escuela");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(166, 11, 109, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escuela");
		lblNewLabel_1.setBounds(10, 83, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(85, 79, 272, 22);
		contentPane.add(comboBox);
		
		llenarEscuelas(comboBox, arrayIdsEscuelas);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuHistoricoIntegrantes sigVentana = new MenuHistoricoIntegrantes(arrayIdsEscuelas.get(comboBox.getSelectedIndex()));
				sigVentana.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(166, 137, 109, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuintegrantes frame = new menuintegrantes();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
