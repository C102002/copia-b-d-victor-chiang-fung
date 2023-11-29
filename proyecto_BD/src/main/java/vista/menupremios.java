package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class menupremios extends JFrame {

	private JPanel contentPane;
	private JTextField txtPremiaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menupremios frame = new menupremios();
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
	public menupremios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 0, 127, 564);
		contentPane.add(panel);
		
		txtPremiaciones = new JTextField();
		txtPremiaciones.setText("PREMIACIONES");
		txtPremiaciones.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtPremiaciones.setEditable(false);
		txtPremiaciones.setColumns(10);
		txtPremiaciones.setBounds(239, 72, 262, 52);
		contentPane.add(txtPremiaciones);
		
		JButton btnAgregarPremios = new JButton("Agregar Premios");
		btnAgregarPremios.setBounds(292, 144, 136, 45);
		contentPane.add(btnAgregarPremios);

		btnAgregarPremios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							aggPremio frame = new aggPremio();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
	
		
		JButton btnNewButton_1 = new JButton("Modificar Premios");
		btnNewButton_1.setBounds(292, 200, 136, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Agregar Ganadores");
		btnNewButton_1_1.setBounds(292, 255, 136, 45);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							aggGanadores frame = new aggGanadores();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		JButton btnNewButton_1_2_1 = new JButton("Regresar");
		btnNewButton_1_2_1.setBounds(292, 310, 136, 45);
		contentPane.add(btnNewButton_1_2_1);
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							maineve frame = new maineve();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
	}
}
