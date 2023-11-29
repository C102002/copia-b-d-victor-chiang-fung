package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;

public class aggColor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnConfirmar;
	private JTextPane txtpnError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aggColor frame = new aggColor();
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
	public aggColor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setBounds(77, 48, 57, 23);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre.setEditable(false);
		contentPane.add(txtpnNombre);
		
		txtpnError = new JTextPane();
		txtpnError.setForeground(new Color(255, 0, 0));
		txtpnError.setText("Error");
		txtpnError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnError.setEditable(false);
		txtpnError.setBounds(123, 10, 57, 23);
		contentPane.add(txtpnError);
		txtpnError.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(165, 52, 96, 19);
		textField.setColumns(10);
		contentPane.add(textField);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(54, 100, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(166, 100, 105, 21);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						String n = textField.getText();
						n= n.toUpperCase();
						ManejoDeString man = new ManejoDeString();
						int conx = 0;
						if ( man.ValidarString(n) == true) {
							conx = 1;
						} else {
							JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
						if ( (n.length()>1 || n.length()<20) && conx==1) {
							int agg = 0;

							SQLController app = new SQLController();
							app.connect();
    						try {
            					ResultSet ax = app.consultar("select * from vah_colores");
								while(ax.next()) {
									String m = ax.getString("nombre");
									if ( m.equals(textField.getText()) == true ) {
										agg=1;
	        					    }
								}
								ax.close();
								
    						} catch (SQLException e) {
								e.printStackTrace();
							}
        					
    						if (agg==0) {
    							try {
									app.insertarColor(textField.getText().toUpperCase());
									dispose();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
    						} else {
    							JOptionPane.showMessageDialog(null, "El nombre de ese color ya existe", "Error", JOptionPane.ERROR_MESSAGE);		
    						}
						}
						
						if ( n.length()<1 || n.length()>20) {
							JOptionPane.showMessageDialog(null, "El nombre debe contener mas de una letra y menos de 20 letras", "Error", JOptionPane.ERROR_MESSAGE); }
						
						
						
					}
				});
			}
		});
	}

}
