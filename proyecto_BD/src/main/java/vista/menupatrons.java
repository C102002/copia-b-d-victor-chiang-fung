package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class menupatrons extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menupatrons frame = new menupatrons();
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
	public menupatrons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Pnatural = new JButton("Agregar Persona Natural");
		btn_Pnatural.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegistrarPersonaNatural frame = new RegistrarPersonaNatural();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		JButton btn_Pjuridica = new JButton("Agregar Persona Juridica");
		btn_Pjuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegistrarPersonaJuridica frame = new RegistrarPersonaJuridica();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btn_Pjuridica.setBounds(191, 290, 223, 43);
		contentPane.add(btn_Pjuridica);
		
		btn_Pnatural.setBounds(191, 236, 223, 43);
		contentPane.add(btn_Pnatural);

		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
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

		btnNewButton_3.setBounds(249, 402, 106, 43);
		contentPane.add(btnNewButton_3);

		txtA = new JTextField();
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtA.setText("PATROCINADORES");
		txtA.setEditable(false);
		txtA.setBounds(160, 89, 300, 52);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 0, 120, 481);
		contentPane.add(panel);
		
		JButton btn_Patrocinios = new JButton("Agregar Patrocinio a una escuela");
		btn_Patrocinios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegistrarPatrocinio frame = new RegistrarPatrocinio();
							frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
		btn_Patrocinios.setBounds(191, 168, 223, 43);
		contentPane.add(btn_Patrocinios);
		
		JButton btn_Donacion = new JButton("Agregar Donacion a una escuela");
		btn_Donacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegistrarDonacion frame = new RegistrarDonacion();
							frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
		btn_Donacion.setBounds(171, 348, 267, 43);
		contentPane.add(btn_Donacion);
		
		
	}
}
