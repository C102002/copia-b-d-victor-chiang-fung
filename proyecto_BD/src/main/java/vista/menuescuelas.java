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

public class menuescuelas extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuescuelas frame = new menuescuelas();
					frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuescuelas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							aggEscuela frame = new aggEscuela();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton.setBounds(252, 163, 106, 43);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_3.setBounds(252, 269, 106, 43);
		contentPane.add(btnNewButton_3);
		
		txtA = new JTextField();
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtA.setText("ESCUELAS");
		txtA.setEditable(false);
		txtA.setBounds(222, 89, 167, 52);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 0));
		panel.setBounds(0, 0, 122, 480);
		contentPane.add(panel);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(252, 216, 106, 43);
		contentPane.add(btnNewButton_1_1);
	}
}
