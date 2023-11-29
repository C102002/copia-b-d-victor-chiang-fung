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
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class aggGanadores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Choice choice_1, choice;
	private JRadioButton rdbtn_b, rdbtn_a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	public aggGanadores() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNombre_1_1 = new JTextPane();
		txtpnNombre_1_1.setText("Ganador");
		txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1.setEditable(false);
		txtpnNombre_1_1.setBounds(55, 160, 64, 23);
		contentPane.add(txtpnNombre_1_1);
		
		choice = new Choice();
		choice.setBounds(55, 209, 310, 18);
		contentPane.add(choice);
		
		rdbtn_a = new JRadioButton("Escuelas");
		rdbtn_a.setSelected(true);
		rdbtn_a.setBounds(120, 249, 78, 23);
		contentPane.add(rdbtn_a);
		
		rdbtn_b = new JRadioButton("Integrantes");
		rdbtn_b.setBounds(229, 249, 125, 23);
		contentPane.add(rdbtn_b);
		
		choice_1 = new Choice();
		choice_1.setBounds(55, 113, 310, 18);
		contentPane.add(choice_1);
		
		rdbtn_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				actCho2();
			}
		});
		
		rdbtn_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actCho();
			}
		});
		rdbtn_a.setSelected(true);
		
		ButtonGroup grupoBtnTipo = new ButtonGroup();
		grupoBtnTipo.add(rdbtn_a);
		grupoBtnTipo.add(rdbtn_b);
		
		JTextPane txtpnNombre_1_1_1 = new JTextPane();
		txtpnNombre_1_1_1.setText("Premios Especiales");
		txtpnNombre_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1_1.setEditable(false);
		txtpnNombre_1_1_1.setBounds(55, 70, 125, 23);
		contentPane.add(txtpnNombre_1_1_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(108, 316, 85, 21);
		contentPane.add(btnNewButton);	

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn_b.setEnabled(false);
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
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String anio = textField.getText()+"-01-01";
				String prem = choice_1.getSelectedItem();
				String miem = choice.getSelectedItem();
					
				int idprem = 0;
				int idmiem = 0;
				int fine = 1;
				
		    	String xxxFecha = "";
		    	String xxxEsc = "";
		    	String xxxInt = "";
		    	
				SQLController app = new SQLController();
				app.connect();
				
				try {
					ResultSet n = app.consultar("SELECT idpremioespecial, nombre FROM vah_premios_especiales");
					while(n.next()) {
						  int id = n.getInt("idpremioespecial");
					      String nombre = n.getString("nombre");
					      if (prem.equals(id+" - "+nombre)==true) {
					    	  idprem = id;
					      }
					}
					n.close();	
				} catch (SQLException e1) { e1.printStackTrace(); }
				
				if (rdbtn_a.isSelected() == false) {	
					try {

						String query = "select v.idintegrante, i.primnom, i.primap, v.idescuela, v.fechaingreso ";
						query += " from vah_hist_integrantes v, vah_integrantes i ";
						query += " where fechaingreso <= '01-01-"+textField.getText()+"' "; 
						query += " and (coalesce(fecharetiro,current_date) >= '01-01-"+textField.getText()+"' ) ";
						query += " and v.idintegrante=i.idintegrante ";
						
						ResultSet n = app.consultar(query);
						while(n.next()) {
							  int id = n.getInt("idintegrante");
						      String nombre = n.getString("primnom");
						      String ap = n.getString("primap");
						      if (miem.equals(id+" - "+nombre+" - "+ap)) {
						    	  idmiem = id;
						    
						    	  xxxFecha = n.getString("fechaingreso");
						    	  xxxEsc = n.getString("idescuela");
						    	  xxxInt = n.getString("idintegrante");
						    	  
						      }
						}
						n.close();	
					} catch (SQLException e1) { e1.printStackTrace(); }
				
				} else {
					try {
						ResultSet n = app.consultar("SELECT idescuela, nombre FROM vah_escuelas");
						while(n.next()) {
							  int id = n.getInt("idescuela");
						      String nombre = n.getString("nombre");
						      if (miem.equals(id+" - "+nombre)) {
						    	  idmiem = id;
						      }
						}
						n.close();	
					} catch (SQLException e1) { e1.printStackTrace(); }
				}
				
				if (rdbtn_a.isSelected() == false) {	
					try {
						ResultSet n = app.consultar("SELECT * FROM vah_ganadores where idescuela is null");
						while(n.next()) {
							  int idi = n.getInt("idintegrante");
							  int idp = n.getInt("idpremioespecial");
							  String ane = n.getString("anio");
							  if ( idp == idprem && anio.equals(ane) ) {
								  fine = 0; break;
							  }
						}
						n.close();	
					} catch (SQLException e1) { e1.printStackTrace(); }
				} else {
					try {
						ResultSet n = app.consultar("SELECT * FROM vah_ganadores where idescuela is not null");
						while(n.next()) {
							  int idi = n.getInt("idescuela");
							  int idp = n.getInt("idpremioespecial");
							  String ane = n.getString("anio");
							  if ( idp == idprem && anio.equals(ane) ) {
								  fine = 0; break;
							  }
						}
						n.close();	
					} catch (SQLException e1) { e1.printStackTrace(); }
				}
				if (fine==1) {
					if (rdbtn_a.isSelected() == false) {
						String f = "'01-01-"+textField.getText()+"'";
						String qu = "(idescuelaintegrante, idintegrante, fechaingreso, anio, idpremioespecial) values ";
						qu += "("+xxxEsc+","+xxxInt+",'"+xxxFecha+"',"+f+","+idprem+")";
						try {
							app.insertarGanadores(qu);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						String f = "'01-01-"+textField.getText()+"'";
						String qu = "(idescuela, idpremioespecial, anio) values ";
						qu += "(" + idmiem + "," + idprem + "," + f + ")";
						try {
							app.insertarGanadores(qu);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ya esta registrado ese premio para ese año", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnConfirmar.setBounds(229, 316, 105, 21);
		contentPane.add(btnConfirmar);
	
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Año");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(55, 27, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		textField = new JTextField();
		textField.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				ManejoDeString man = new ManejoDeString();
				if (textField.getText().length()>=3 && textField.getText().length()<=8) {
					if ( man.ValidarInt( textField.getText() ) == true ) {
						choice.setEnabled(true);
						rdbtn_a.setEnabled(true);
						rdbtn_b.setEnabled(true);
						btnConfirmar.setEnabled(true);

						if (rdbtn_a.isSelected() == true) {
							actCho2();
						} else {
							actCho();
						}
						
					} else {
						choice.setEnabled(false);
						rdbtn_a.setEnabled(false);
						rdbtn_b.setEnabled(false);
						btnConfirmar.setEnabled(false);
						choice.removeAll();
					}	
				} else {
					choice.setEnabled(false);
					rdbtn_a.setEnabled(false);
					rdbtn_b.setEnabled(false);
					btnConfirmar.setEnabled(false);
					choice.removeAll();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(137, 27, 133, 23);
		contentPane.add(textField);
		textField.setText("1999");
		
		SQLController app = new SQLController();
		app.connect();
		choice.removeAll();
		choice_1.removeAll();
		try {
			ResultSet n = app.consultar("SELECT idpremioespecial, nombre FROM vah_premios_especiales");
			while(n.next()) {
				  int id = n.getInt("idpremioespecial");
			      String nombre = n.getString("nombre");
			      choice_1.add(id+" - "+nombre); 
			}
			n.close();	
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		actCho2();
	}
	
	public void actCho() {
		SQLController app = new SQLController();
		app.connect();
		choice.removeAll();
		
		String query = "select v.idintegrante, i.primnom, i.primap ";
		query += " from vah_hist_integrantes v, vah_integrantes i ";
		query += " where fechaingreso <= '01-01-"+textField.getText()+"' "; 
		query += " and (coalesce(fecharetiro,current_date) >= '01-01-"+textField.getText()+"' ) ";
		query += " and v.idintegrante=i.idintegrante ";
		
		try {
			ResultSet n = app.consultar(query);
			while(n.next()) {
				  int id = n.getInt("idintegrante");
			      String nombre = n.getString("primnom");
			      String ape = n.getString("primap");
			      choice.add(id+ " - " +nombre + " - " +ape); 
			}
			n.close();	
		} catch (SQLException e1) { e1.printStackTrace(); }
	}
	public void actCho2() {
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
				choice.add(ax.getString("idescuela")+" - "+m);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }
	}
	
}
