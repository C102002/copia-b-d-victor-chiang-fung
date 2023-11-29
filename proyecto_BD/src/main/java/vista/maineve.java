package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class maineve extends JFrame {

	private JPanel contentPane;
	private JTextField txtMain;
	
	public static void main(String[] args) throws SQLException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maineve frame = new maineve();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
					         int option = JOptionPane.showConfirmDialog(
								frame, 
								"¿Estás seguro de que quieres cerrar la aplicación?",
								"Confirmación de cierre", 
								JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
							if (option == JOptionPane.YES_OPTION) {
								System.exit(0);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public maineve() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 591);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 0, 117, 542);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Escuelas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							menuescuelas fr = new menuescuelas();
							fr.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton.setBounds(240, 165, 136, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Integrantes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							menuintegrantes fr = new menuintegrantes();
							fr.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton_1.setBounds(240, 221, 136, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Patrocinadores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							menupatrons fr = new menupatrons();
							fr.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton_2.setBounds(240, 276, 136, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eventos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						menueventos fr = new menueventos();
						fr.setVisible(true);
						dispose();
					}
				});
				
			}
		});
		btnNewButton_3.setBounds(240, 331, 136, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						dispose();
					}
				});
				
			}
		});
		btnNewButton_4.setBounds(240, 448, 136, 45);
		contentPane.add(btnNewButton_4);
		
	
		txtMain = new JTextField();
		txtMain.setText("GRES");
		txtMain.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtMain.setEditable(false);
		txtMain.setColumns(10);
		txtMain.setBounds(259, 103, 98, 52);
		contentPane.add(txtMain);
		
		JButton btnNewButton_3_1 = new JButton("Premiaciones");
		btnNewButton_3_1.setBounds(240, 393, 136, 45);
		contentPane.add(btnNewButton_3_1);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {

						menupremios fr = new menupremios();
						fr.setVisible(true);
						dispose();
					}
				});
				
			}
		});
	}
}
