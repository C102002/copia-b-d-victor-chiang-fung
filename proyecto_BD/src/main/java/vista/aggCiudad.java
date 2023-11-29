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
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aggCiudad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private Choice choice;
	private JTextPane txtpnNombre_1;
	private JButton btnNewButton_1;
	private JButton btnConfirmar;
	private JTextPane txtpnError;
	private int act = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aggCiudad frame = new aggCiudad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actEstados() {
		choice.removeAll();
	    choice.add("NONE");

		SQLController ap = new SQLController();
		ap.connect();
			
		ResultSet ax;
		try {
			ax = ap.consultar("select distinct nombre from vah_estados");
			while(ax.next()) {
				String m = ax.getString("nombre");
				choice.add(m);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }

	}
	
	public aggCiudad() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnError = new JTextPane();
		txtpnError.setForeground(new Color(255, 0, 0));
		txtpnError.setText("Error");
		txtpnError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnError.setEditable(false);
		txtpnError.setBounds(163, 28, 57, 23);
		contentPane.add(txtpnError);
		txtpnError.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(163, 80, 105, 19);
		textField.setColumns(10);
		contentPane.add(textField);
		
		btnNewButton = new JButton("Agregar Estado");
		btnNewButton.setBounds(312, 128, 140, 21);
		contentPane.add(btnNewButton);
		
	    btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		act = 1;
					aggEstado frame = new aggEstado();
					frame.setVisible(true);
	        	}
	    });
		choice = new Choice();
		choice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (act==1) {
					actEstados();		
				}
				act = 0;
			}
		});
		choice.setBounds(163, 131, 105, 18);
		contentPane.add(choice);
		actEstados();
		txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Estado");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(60, 128, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(118, 196, 85, 21);
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
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(246, 196, 105, 21);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = 0;
				String n = textField.getText();
				String z = choice.getSelectedItem();
				int conx = 0;
				
				ManejoDeString man = new ManejoDeString();
				
				if ( man.ValidarString(n) == true) {
					conx = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if ( (!z.equals("NONE")) && (n.length()>1 || n.length()<40) && conx == 1) {

					int agg = 0;
					String est = choice.getSelectedItem(); 
					String ciu = textField.getText();	
					SQLController app = new SQLController();
					app.connect();
						
					try {
        				ResultSet ax = app.consultar("select * from vah_ciudades");
						while(ax.next()) {
							if (ax.getString("nombre").equals(ciu)) {
								ResultSet bx = app.consultar("select * from vah_estados");
								while(bx.next()) {
									if(bx.getString("nombre").equals(est)) { agg=1; }
								} bx.close();
							}
						} ax.close();
							
					} catch (SQLException e1) { e1.printStackTrace(); }
    					
					if (agg==0) {
						try {
							ResultSet ax = app.consultar("select * from vah_estados where nombre='"+est+"'");
							while(ax.next()) {
								if (ax.getString("nombre").equals(est)) {
									id = ax.getInt("idestado");
								}
							} ax.close();			
							app.insertarCiudad(ciu.toUpperCase(),id);
							dispose();
						} catch (SQLException e1) { e1.printStackTrace(); }
					} else {
						JOptionPane.showMessageDialog(null, "Ya existe una Ciudad con ese nombre en ese Estado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} 
				
				if (z=="NONE") {
					JOptionPane.showMessageDialog(null, "Debes elegir un Estado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (n.length()<=1 || n.length()>=40) {
					JOptionPane.showMessageDialog(null, "El nombre debe contener mas de una letra y menos de 40 letras", "Error", JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});	
	}
}
	
	