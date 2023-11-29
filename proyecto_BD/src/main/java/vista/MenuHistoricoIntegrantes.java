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

public class MenuHistoricoIntegrantes extends JFrame {
	private JPanel contentPane;
	private JTextField txtA;
	private JFrame thisInstance = this;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuHistoricoIntegrantes frame = new MenuHistoricoIntegrantes(1);
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
	public MenuHistoricoIntegrantes(int idEscuela) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.setBounds(260, 192, 106, 43);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AbrirHistoricoIntegrante frame = new AbrirHistoricoIntegrante(idEscuela);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogCerrarHistorico dialogCerrarHistorico = new DialogCerrarHistorico(thisInstance, idEscuela);
				dialogCerrarHistorico.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(260, 245, 106, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ver Históricos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogVerHistoricos dialogVerHistoricos = new DialogVerHistoricos(thisInstance, idEscuela);
				dialogVerHistoricos.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(260, 298, 106, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EscogerEscuela frame = new EscogerEscuela();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton_3.setBounds(260, 425, 106, 43);
		contentPane.add(btnNewButton_3);
		
		txtA = new JTextField();
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtA.setText("HIST INTEGRANTES");
		txtA.setEditable(false);
		txtA.setBounds(142, 88, 334, 52);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 0, 120, 481);
		contentPane.add(panel);}
}
