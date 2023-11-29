package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;

public class agghist_titu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Choice choice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agghist_titu frame = new agghist_titu();
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
	public agghist_titu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		choice = new Choice();
		choice.setBounds(176, 218, 333, 18);
		contentPane.add(choice);
		
		JTextPane txtpnNombre_1_1_1 = new JTextPane();
		txtpnNombre_1_1_1.setText("Escuela");
		txtpnNombre_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1_1.setEditable(false);
		txtpnNombre_1_1_1.setBounds(94, 218, 64, 23);
		contentPane.add(txtpnNombre_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(176, 77, 105, 23);
		contentPane.add(textField);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Año");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(94, 77, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 124, 105, 23);
		contentPane.add(textField_1);
		
		JTextPane txtpnNombre_1_1 = new JTextPane();
		txtpnNombre_1_1.setText("Monto");
		txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1.setEditable(false);
		txtpnNombre_1_1.setBounds(94, 124, 64, 23);
		contentPane.add(txtpnNombre_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 169, 333, 23);
		contentPane.add(textField_2);
		
		JTextPane txtpnNombre_1_2 = new JTextPane();
		txtpnNombre_1_2.setText("Grupo");
		txtpnNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_2.setEditable(false);
		txtpnNombre_1_2.setBounds(94, 169, 64, 23);
		contentPane.add(txtpnNombre_1_2);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(215, 289, 85, 21);
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

		textField.setText("1999");
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 289, 105, 21);
		contentPane.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							String anio = textField.getText()+"-01-01";
							String monto = textField_1.getText();
							String grupo = textField_2.getText();
							String escu = choice.getSelectedItem();
							int idt = 0;
							int fine = 1;
							
							if (monto.length()==1 && monto=="0") {
								JOptionPane.showMessageDialog(null, "El monto debe ser mayor o igual a 1", "Error", JOptionPane.ERROR_MESSAGE);
								fine=0;
							} 
							
							SQLController ap = new SQLController();
							ap.connect();
							ResultSet ax;
							try {
								String query = "select nombre, idescuela from vah_escuelas ";
								query += "where fechafundacion <= '" + textField.getText() + "-01-01'";
								ax = ap.consultar(query);
								while(ax.next()) {
									String m = ax.getString("nombre");
									if ( escu.equals( ax.getInt("idescuela")+" - "+m ) == true ) {
										idt = ax.getInt("idescuela");
									}
								}
								ax.close();
							} catch (SQLException e1) { e1.printStackTrace(); }
							
							try {
								String query = "select nombre, idescuela from vah_escuelas ";
								query += "where fechafundacion <= '01-01-" + textField.getText() + "'";
								ax = ap.consultar(query);
								while(ax.next()) {
									String m = ax.getString("nombre");
									if ( escu.equals( ax.getInt("idescuela")+" - "+m ) == true ) {
										idt = ax.getInt("idescuela");
									}
								}
								ax.close();
							} catch (SQLException e1) { e1.printStackTrace(); }
							

							try {
								String query = "select * from vah_hist_titulos";
								ax = ap.consultar(query);
								while(ax.next()) {
									String m = ax.getString("idescuela");
									String n = ax.getString("anio");
									if ( n.equals(anio) == true && m.equals(""+idt) ==true ) {
										fine = 0;
									}
								}
								ax.close();
							} catch (SQLException e1) { e1.printStackTrace(); }
							
							if (fine==1) {
								String a = "'01-01-"+textField.getText()+"'";
								if (monto.length() == 0) {
									String x = "("+idt+","+a+",'"+grupo+"')";
									ap.insertarTitulos(" (idescuela,anio,grupo) values "+x);
								} else if (grupo.length() == 0) {
									String x = "("+idt+","+a+","+monto+")";
									ap.insertarTitulos(" (idescuela,anio,monto) values "+x);
								} else if (grupo.length()==0 && monto.length()==0) {
									String x = "("+idt+","+a+")";
									ap.insertarTitulos(" (idescuela,anio) values "+x);
								} else {
									String x = "("+idt+","+a+","+monto+",'"+grupo+"')";
									ap.insertarTitulos(" (idescuela,anio,monto,grupo) values "+x);
								}
	
							} else {
								JOptionPane.showMessageDialog(null, "Ya esta registrado ese titulo para esa escuela en ese años", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		
		textField.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				ManejoDeString man = new ManejoDeString();
				if (textField.getText().length()>=3 && textField.getText().length()<=8) {
					if ( man.ValidarInt( textField.getText() ) == true ) {
						choice.setEnabled(true);
						btnConfirmar.setEnabled(true);

						actCho();
					} else {
						choice.setEnabled(false);
						btnConfirmar.setEnabled(false);
						choice.removeAll();
					}	
				} else {
					choice.setEnabled(false);
					btnConfirmar.setEnabled(false);
					choice.removeAll();
				}
			}
		});
		
	}
	
	public void actCho() {
		SQLController ap = new SQLController();
		ap.connect();
		choice.removeAll();
		ResultSet ax;
		try {
			String query = "select nombre, idescuela, fechafundacion from vah_escuelas ";
			query += "where fechafundacion <= '01-01-" + textField.getText() + "'";
			ax = ap.consultar(query);
			while(ax.next()) {
				String m = ax.getString("nombre");
				choice.add(ax.getInt("idescuela")+" - "+m);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }
	}
	
	
}
