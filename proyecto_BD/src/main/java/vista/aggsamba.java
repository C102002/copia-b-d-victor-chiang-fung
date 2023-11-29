package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;

public class aggsamba extends JFrame {
	private Choice cho_escue_1;
	private JPanel contentPane;
	private JTextField anio;
	private Choice cho_escue;
	private Choice cho_tipo;
	private JEditorPane titu;
	private JEditorPane letr;
	int idesc = 0;
	JEditorPane titu_1;
	
	private JList<String> jlist_Habilidades;
	private ArrayList<String> arr = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	public aggsamba() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 933, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(347, 296, 96, 36);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = titu.getText();
				String letra = letr.getText();
				String ano = anio.getText();
				String tipo = cho_tipo.getSelectedItem();
				String nomEsc = cho_escue.getSelectedItem();
				int fine = 1;
				ManejoDeString man = new ManejoDeString();
				
				if ( nomEsc == null ) {
					JOptionPane.showMessageDialog(null, "No puedes agregas sambas si no tienes escuelas registradas", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;	
				}
				
				if ( man.ValidarString(titulo) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Titulo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( titulo.length() <= 1 || titulo.length() >= 120) {
					JOptionPane.showMessageDialog(null, "El Titulo debe tener dos letras como minimo, 120 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				if ( man.ValidarString(letra) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Letra", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( letra.length() <= 1 || letra.length() >= 300) {
					JOptionPane.showMessageDialog(null, "La Letra debe tener dos letras como minimo, 300 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if (titu_1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debes registrar un autor minimo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if (fine==1) {	
					try {
						int id = 0;
						SQLController app = new SQLController();
						app.connect();
						ResultSet n = app.consultar("SELECT nombre, idescuela FROM vah_escuelas");
						while(n.next()) {
						    String nax = n.getString("nombre");
						    int idd = n.getInt("idescuela"); 
							if ( nomEsc.equals(idd+" - "+nax) ) {
								id = idd;
								break;
							}
						}
						n.close();

						app.connect();
						String d = "01/01/"+ano;
						String t = "("+id+",'"+titulo+"','"+d+"','"+letra+"','"+tipo+"')";
						//app.insertarSamba(t);

				        String val = "(idescuela, titulo, aniocarnaval, letra, tipo)";
						int sambaid = app.UpdateQueryReturnCurrentValue("INSERT INTO VAH_SAMBAS "+val+" values " + t, "vah_sec_sambas");
						
						for (int zz=0; zz<arr.size(); zz++) {
							
							String a = "'01-01-"+anio.getText()+"'";
							String q = "select i.idintegrante, h.fechaingreso, h.idescuela, i.primnom, i.primap ";
							q += "from vah_hist_integrantes h, vah_integrantes i ";
							q += "where h.fechaingreso <= "+a;
							q += "and ("+a+" <= coalesce(h.fecharetiro, current_date) ) ";
							q += "and h.idescuela="+idesc;
							q += " and h.idintegrante=i.idintegrante";

							String idA = "";
							String feA = "";
							String idescA = "";
							
							SQLController ap = new SQLController();
							ap.connect();
							cho_escue_1.removeAll();
							ResultSet ax;
							try {
								ax = ap.consultar(q);
								while(ax.next()) {
									String mx = ax.getString("primnom");
									String nx = ax.getString("primap");
									String se = ax.getInt("idintegrante")+" - "+mx+" - "+nx;
									if (se.equals(arr.get(zz))==true) {
										idA = ax.getString("idintegrante");
										feA = ax.getString("fechaingreso");
										idescA = ax.getString("idescuela");
									}
								}
								ax.close();
						
							} catch (SQLException e1) { e1.printStackTrace(); }
							app.connect();
							String txx = "("+sambaid+","+id+","+idescA+","+idA+",'"+feA+"'"+")";
					        app.insertarAutores(txx);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
			}
		});	
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(476, 296, 96, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
		JTextPane txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setText("Letra");
		txtpnNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2.setEditable(false);
		txtpnNombre_2.setBounds(347, 118, 86, 23);
		contentPane.add(txtpnNombre_2);
		
		letr = new JEditorPane();
		letr.setBounds(347, 158, 231, 82);
		contentPane.add(letr);
		
		JTextPane txtpnNombre_2_1 = new JTextPane();
		txtpnNombre_2_1.setText("Titulo");
		txtpnNombre_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2_1.setEditable(false);
		txtpnNombre_2_1.setBounds(33, 118, 86, 23);
		contentPane.add(txtpnNombre_2_1);
		
		titu = new JEditorPane();
		titu.setBounds(33, 158, 231, 82);
		contentPane.add(titu);
		
		JTextPane txtpnNombre_1_1 = new JTextPane();
		txtpnNombre_1_1.setText("Año del Carnaval");
		txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1.setEditable(false);
		txtpnNombre_1_1.setBounds(33, 32, 140, 23);
		contentPane.add(txtpnNombre_1_1);

		anio = new JTextField();
		anio.setColumns(10);
		anio.setBounds(33, 74, 86, 20);
		contentPane.add(anio);
		anio.setText("1999");
		
		JTextPane txtpnNombre_2_1_1 = new JTextPane();
		txtpnNombre_2_1_1.setText("Tipo");
		txtpnNombre_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2_1_1.setEditable(false);
		txtpnNombre_2_1_1.setBounds(347, 32, 86, 23);
		contentPane.add(txtpnNombre_2_1_1);
		
		cho_tipo = new Choice();
		cho_tipo.setBounds(347, 74, 225, 18);
		contentPane.add(cho_tipo);
		
		cho_escue = new Choice();
		cho_escue.setBounds(33, 317, 225, 18);
		contentPane.add(cho_escue);
		
		JTextPane txtpnNombre_2_1_1_1 = new JTextPane();
		txtpnNombre_2_1_1_1.setText("Escuela");
		txtpnNombre_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2_1_1_1.setEditable(false);
		txtpnNombre_2_1_1_1.setBounds(33, 275, 86, 23);
		contentPane.add(txtpnNombre_2_1_1_1);
		
		cho_escue_1 = new Choice();
		cho_escue_1.setBounds(640, 74, 225, 18);
		contentPane.add(cho_escue_1);
		
		JTextPane txtpnNombre_2_1_2 = new JTextPane();
		txtpnNombre_2_1_2.setText("Autores");
		txtpnNombre_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2_1_2.setEditable(false);
		txtpnNombre_2_1_2.setBounds(640, 32, 86, 23);
		contentPane.add(txtpnNombre_2_1_2);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arr.clear();
        		titu_1.setText("");
			}
		});
		btnLimpiar.setBounds(685, 303, 122, 23);
		contentPane.add(btnLimpiar);
		
		titu_1 = new JEditorPane();
		titu_1.setEditable(false);
		titu_1.setBounds(640, 118, 231, 160);
		contentPane.add(titu_1);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManejoDeString man = new ManejoDeString();
				int fine=1;
				if ( anio.getText().length()==0 ) {
					JOptionPane.showMessageDialog(null, "El año no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} else if ( man.ValidarInt(anio.getText()) == false ) {
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo año", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} else {
					if ( Integer.parseInt(anio.getText())>0 ) {	
					} else { 
						JOptionPane.showMessageDialog(null, "El año minimo es 1", "Error", JOptionPane.ERROR_MESSAGE);
						fine = 0;
					}	
				}
				
				if (fine==1) {
				
				if (anio.getText().length()>=3 && anio.getText().length()<=8) {
					if ( man.ValidarInt( anio.getText() ) == true ) {
						cho_escue_1.setEnabled(true);
						cho_escue.setEnabled(true);
						btnConfirmar.setEnabled(true);

						actCho();
						
						SQLController app = new SQLController();
		        		app.connect();
		        		try {
		        			ResultSet n = app.consultar("SELECT nombre, idescuela FROM vah_escuelas");
		        			while(n.next()) {
			        		      String nom = n.getString("nombre");
			        		      int idd = n.getInt("idescuela"); 
			        		      if ( cho_escue.getSelectedItem().equals(idd+" - "+nom) == true ) { idesc = idd; }
			        		}
			        		n.close();
						} catch (SQLException e1) { e1.printStackTrace(); }
						actCho2();
						
						actCho2();
					} else {
						cho_escue_1.setEnabled(true);
						cho_escue.setEnabled(true);
						btnConfirmar.setEnabled(false);
						cho_escue_1.removeAll();
						cho_escue.removeAll();
					}	
				} else {
					cho_escue_1.setEnabled(true);
					cho_escue.setEnabled(true);
					btnConfirmar.setEnabled(false);
					cho_escue_1.removeAll();
					cho_escue.removeAll();
				}	
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		btnNewButton_1.setBounds(183, 34, 85, 21);
		contentPane.add(btnNewButton_1);
		
		cho_escue.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { 
        		SQLController app = new SQLController();
        		app.connect();
        		try {
        			ResultSet n = app.consultar("SELECT nombre, idescuela FROM vah_escuelas");
        			while(n.next()) {
	        		      String nom = n.getString("nombre");
	        		      int idd = n.getInt("idescuela"); 
	        		      if ( cho_escue.getSelectedItem().equals(idd+" - "+nom) == true ) { idesc = idd; }
	        		}
	        		n.close();
				} catch (SQLException e1) { e1.printStackTrace(); }

				arr.clear();
        		titu_1.setText("");
        		actCho2();
			}
        });
		
		cho_tipo.add("SAMBA ENREDO");
		cho_tipo.add("SAMBA LOLOCO");
		cho_tipo.add("SAMBA EMBOLO");
		cho_tipo.add("MARCHINHA");
		cho_tipo.add("FREVO");
		cho_tipo.add("MARACATO");
		cho_tipo.add("SAMBAREGGAE");
		
		cho_escue_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { 
        		String xx = cho_escue_1.getSelectedItem();
        		if ( arr.contains(xx) == false && xx!="NONE") {
            		arr.add( cho_escue_1.getSelectedItem() );
            		titu_1.setText( titu_1.getText() + xx + " \n ");
        		}
        	}
        });
		
	}
	
	public void actCho() {
		SQLController ap = new SQLController();
		ap.connect();
		cho_escue.removeAll();
		ResultSet ax;
		try {
			String query = "select nombre, idescuela, fechafundacion from vah_escuelas ";
			query += "where fechafundacion <= '01-01-" + anio.getText() + "'";
			ax = ap.consultar(query);
			while(ax.next()) {
				String m = ax.getString("nombre");
				cho_escue.add(ax.getInt("idescuela")+" - "+m);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }
	}
	
	public void actCho2() {
		String a = "'01-01-"+anio.getText()+"'";
		String q = "select i.idintegrante, i.primnom, i.primap ";
		q += "from vah_hist_integrantes h, vah_integrantes i ";
		q += "where h.fechaingreso <= "+a;
		q += "and ("+a+" <= coalesce(h.fecharetiro, current_date) ) ";
		q += "and h.idescuela="+idesc;
		q += " and h.idintegrante=i.idintegrante";
		
		SQLController ap = new SQLController();
		ap.connect();
		cho_escue_1.removeAll();
		cho_escue_1.add("NONE");
		ResultSet ax;
		try {
			ax = ap.consultar(q);
			while(ax.next()) {
				String m = ax.getString("primnom");
				String n = ax.getString("primap");
				cho_escue_1.add(ax.getInt("idintegrante")+" - "+m+" - "+n);
			}
			ax.close();
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		
	}
}
