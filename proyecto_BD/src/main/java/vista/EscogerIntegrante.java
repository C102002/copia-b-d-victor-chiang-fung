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

public class EscogerIntegrante extends JFrame {
	private SQLController sqlController = new SQLController();
	
	private ArrayList<Integer> arrayIdsIntegrantes = new ArrayList<>();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscogerIntegrante frame = new EscogerIntegrante();
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
	public EscogerIntegrante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoger Integrante");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(166, 11, 109, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Integrante");
		lblNewLabel_1.setBounds(10, 83, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(85, 79, 272, 22);
		contentPane.add(comboBox);
		
		llenarIntegrantes(comboBox, arrayIdsIntegrantes);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarIntegrante sigVentana = new ModificarIntegrante(arrayIdsIntegrantes.get(comboBox.getSelectedIndex()));
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
