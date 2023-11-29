package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menueventos extends JFrame {

	private JPanel contentPane;
	private JTextField txtEventos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menueventos frame = new menueventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menueventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 10, 145, 642);
		contentPane.add(panel);
		
		txtEventos = new JTextField();
		txtEventos.setText("EVENTOS");
		txtEventos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtEventos.setEditable(false);
		txtEventos.setColumns(10);
		txtEventos.setBounds(308, 71, 167, 52);
		contentPane.add(txtEventos);
		
		JButton btnAgregarEventoAnual = new JButton("Agregar Evento");

		btnAgregarEventoAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							hist_eventos frame = new hist_eventos();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnAgregarEventoAnual.setBounds(290, 153, 200, 43);
		contentPane.add(btnAgregarEventoAnual);
		
		JButton btnModificarEvento = new JButton("Modificar Evento");
		btnModificarEvento.setBounds(290, 206, 200, 43);
		contentPane.add(btnModificarEvento);
		
		JButton btnAgregarSamba = new JButton("Agregar Samba");
		btnAgregarSamba.setBounds(290, 259, 200, 43);
		contentPane.add(btnAgregarSamba);
		
		btnAgregarSamba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							aggsamba frame = new aggsamba();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		JButton btnModificarSamba = new JButton("Modificar Samba");
		btnModificarSamba.setBounds(290, 312, 200, 43);
		contentPane.add(btnModificarSamba);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(290, 418, 200, 43);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
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
		JButton btnAgregarAutorSamba = new JButton("Agregar Autor Samba");
		btnAgregarAutorSamba.setBounds(290, 365, 200, 43);
		contentPane.add(btnAgregarAutorSamba);
		
		
	}
	
}
