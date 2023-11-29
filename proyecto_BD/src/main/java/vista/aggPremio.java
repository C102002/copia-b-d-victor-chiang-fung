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
import java.awt.Choice;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class aggPremio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtn_b, rdbtn_a;
	private Choice choice;
	private JTextPane txtpnNombre_1_1;
	private JTextPane txtpnNombre_1;
	private JEditorPane desc;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aggPremio frame = new aggPremio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public aggPremio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnNombre_1_1 = new JTextPane();
		txtpnNombre_1_1.setText("Ubicación");
		txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1.setEditable(false);
		txtpnNombre_1_1.setBounds(19, 83, 64, 23);
		contentPane.add(txtpnNombre_1_1);
		
		choice = new Choice();
		choice.setBounds(101, 83, 310, 18);
		contentPane.add(choice);
		
		JButton btnNewButton_1 = new JButton("Agregar Ciudad");
		btnNewButton_1.setBounds(111, 179, 140, 21);
		contentPane.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aggCiudad frame = new aggCiudad();
				frame.setVisible(true);
        	}
        });	
		
		JButton btnNewButton_1_1 = new JButton("Agregar Estado");
		btnNewButton_1_1.setBounds(271, 179, 140, 21);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		aggEstado frame = new aggEstado();
				frame.setVisible(true);
        	}
        });	
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 26, 310, 23);
		contentPane.add(textField);
		
		txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Nombre");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(19, 26, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(101, 482, 85, 21);
		contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	} 
        });
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(241, 482, 105, 21);
		contentPane.add(btnConfirmar);
		
        btnConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int fine = 1;
        		String nom = textField.getText();
				String descrip = desc.getText();
				String tipo = textField_1.getText();
				String ubi = choice.getSelectedItem();	
				
				ManejoDeString man = new ManejoDeString();
				
				if ( man.ValidarString(nom) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( nom.length() <= 1 || nom.length() >= 20) {
					JOptionPane.showMessageDialog(null, "El Nombre debe tener dos letras como minimo, 20 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarString(descrip) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Descripcion", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( descrip.length() <= 1 || descrip.length() >= 100) {
					JOptionPane.showMessageDialog(null, "La Descripcion debe tener dos letras como minimo, 100 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarString(tipo) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Tipo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( tipo.length() <= 1 || tipo.length() >= 30) {
					JOptionPane.showMessageDialog(null, "El Tipo debe tener dos letras como minimo, 30 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				int idest = 0;
				int idciu = 0;
				SQLController app = new SQLController();
				app.connect();
				if ( rdbtn_a.isSelected() == true ) {
					try {
						ResultSet n = app.consultar("SELECT nombre, idestado, idciudad FROM vah_ciudades");
						while(n.next()) {
							
							  int x = n.getInt("idestado");
						      String nombre = n.getString("nombre");
						      
						      ResultSet bus = app.consultar( "SELECT nombre FROM vah_estados WHERE idestado=" + x );
						      String m = "";
						      while(bus.next()) {
						    	  String xa = bus.getString("nombre"); 
							      m = nombre + " - " + xa;
							      
							      if ( ubi.equals( m ) == true ) {
							    	  idest=n.getInt("idestado");
							    	  idciu=n.getInt("idciudad");
							    	  break;
							      }
						      }
						      bus.close();
						      choice.add(m); 
						}
						n.close();	
					} catch (SQLException e1) { e1.printStackTrace(); }
				} else {		
					try {
						ResultSet ax = app.consultar("select distinct idestado from vah_estados where nombre='"+ubi+"'");
						while(ax.next()) {
							idest = ax.getInt("idestado");
						}
						ax.close();
					} catch (SQLException e1) { e1.printStackTrace(); }
				}
				
        		if (fine == 1) {
        			if (rdbtn_a.isSelected() == true ) {
        				String t = "('" + nom + "','"+ descrip + "','" + tipo + "'," + idciu + "," + idest + ")";
						try {
							app.insertarPremio_Ciudad(t);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}	
					} else {
						String t = "('" + nom + "','"+ descrip + "','" + tipo + "'," + idest + ")";
						try {
							app.insertarPremio_Estado(t);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
            		dispose();
        		}
        		
        		
        		
        	} 
        });
		
		rdbtn_a = new JRadioButton("Ciudad");
		rdbtn_a .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SQLController app = new SQLController();
				app.connect();
				choice.removeAll();
				try {
					ResultSet n = app.consultar("SELECT nombre, idestado FROM vah_ciudades");
					while(n.next()) {
						  int id = n.getInt("idestado");
					      String nombre = n.getString("nombre");
					      String b = "SELECT nombre FROM vah_estados WHERE idestado=" + id;
					      
					      ResultSet bus = app.consultar(b);
					      String m = "";
					      while(bus.next()) {
					    	  String xa = bus.getString("nombre"); 
						      m = nombre + " - " + xa;
					      }
					      bus.close();
					      choice.add(m); 
					}
					n.close();	
				} catch (SQLException e1) { e1.printStackTrace(); }
			}
		});
		rdbtn_a.setBounds(150, 137, 78, 23);
		contentPane.add(rdbtn_a);
		
		rdbtn_b = new JRadioButton("Estado");
		rdbtn_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SQLController ap = new SQLController();
				ap.connect();
				choice.removeAll();
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
		});
		rdbtn_b.setBounds(292, 137, 72, 23);
		contentPane.add(rdbtn_b);
		
		rdbtn_a.setSelected(true);
		
		ButtonGroup grupoBtnTipo = new ButtonGroup();
		grupoBtnTipo.add(rdbtn_a);
		grupoBtnTipo.add(rdbtn_b);
		
		JTextPane txtpnNombre_1_2 = new JTextPane();
		txtpnNombre_1_2.setText("Tipo");
		txtpnNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_2.setEditable(false);
		txtpnNombre_1_2.setBounds(19, 226, 64, 23);
		contentPane.add(txtpnNombre_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 226, 310, 23);
		contentPane.add(textField_1);
		
		desc = new JEditorPane();
		desc.setBounds(19, 319, 392, 116);
		contentPane.add(desc);
		
		JTextPane txtpnNombre_1_3 = new JTextPane();
		txtpnNombre_1_3.setText("Descripción");
		txtpnNombre_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_3.setEditable(false);
		txtpnNombre_1_3.setBounds(19, 279, 105, 23);
		contentPane.add(txtpnNombre_1_3);
		
		SQLController app = new SQLController();
		app.connect();
		choice.removeAll();
		try {
			ResultSet n = app.consultar("SELECT nombre, idestado FROM vah_ciudades");
			while(n.next()) {
				  int id = n.getInt("idestado");
			      String nombre = n.getString("nombre");
			      String b = "SELECT nombre FROM vah_estados WHERE idestado=" + id;
			      
			      ResultSet bus = app.consultar(b);
			      String m = "";
			      while(bus.next()) {
			    	  String xa = bus.getString("nombre"); 
				      m = nombre + " - " + xa;
			      }
			      bus.close();
			      choice.add(m); 
			}
			n.close();	
		} catch (SQLException e1) { e1.printStackTrace(); }
	
		
	}
}