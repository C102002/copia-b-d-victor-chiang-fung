package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;

public class aggEstado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane txtpnError;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aggEstado frame = new aggEstado();
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
	public aggEstado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setBounds(120, 53, 57, 23);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre.setEditable(false);
		contentPane.add(txtpnNombre);
		
		textField = new JTextField();
		textField.setBounds(204, 57, 96, 19);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Region");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(120, 105, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		Choice choice = new Choice();
		choice.setBounds(204, 105, 105, 18);
		contentPane.add(choice);

        choice.add("NONE");


		SQLController ap = new SQLController();
		ap.connect();
		
		ResultSet ax;
		try {
			ax = ap.consultar("select distinct region from vah_estados");
			while(ax.next()) {
				String m = ax.getString("region");
				choice.add(m);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(212, 170, 105, 21);
		contentPane.add(btnConfirmar);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						int conx = 0;
						String n = textField.getText();
						ManejoDeString man = new ManejoDeString();
						
						if ( man.ValidarString(n) == true) { conx = 1;
						} else { JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE); }
						
						if ((n.length()>1 || n.length()<40) && choice.getSelectedItem()!="NONE" && conx==1) {
							int agg = 0;
					
							SQLController app = new SQLController();
							app.connect();
    						try {
            					ResultSet ax = app.consultar("select * from vah_estados");
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
									app.insertarEstado(textField.getText().toUpperCase(),choice.getSelectedItem());
									dispose();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
    						} else {
    							JOptionPane.showMessageDialog(null, "Ya existe un Estado con ese Nombre", "Error", JOptionPane.ERROR_MESSAGE); 
    						}
						}
						
						if ( n.length()<=1 || n.length()>=40) {
							JOptionPane.showMessageDialog(null, "El nombre debe contener mas de una letra y menos de 40 letras", "Error", JOptionPane.ERROR_MESSAGE); }

						if ( choice.getSelectedItem()=="NONE" ) {
							JOptionPane.showMessageDialog(null, "Debes seleccionar una region", "Error", JOptionPane.ERROR_MESSAGE); }
						
						
					}
				});
			}
		});
				
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(100, 170, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
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
	}

}
