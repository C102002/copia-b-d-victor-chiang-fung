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
import java.awt.Choice;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class hist_eventos extends JFrame {

	private JPanel contentPane;
	private JTextField tfnombre;
	private JTextPane txtpnNombre_1_1;
	private Choice cho_dia;
	private Choice cho_mes;
	private JTextField anioini;
	private JTextPane txtpnNombre_1_2;
	private Choice cho_dia_1;
	private Choice cho_mes_1;
	private JTextField aniofin;
	private JTextField asist;
	private JTextPane txtpnNombre;
	private JTextPane txtpnNombre_2;
	private JTextField costo;
	private JButton btnConfirmar;
	private JTextPane txtpnNombre_3;
	private Choice cho_escue;
	private JEditorPane desc;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hist_eventos frame = new hist_eventos();
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
	public hist_eventos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfnombre = new JTextField();
		tfnombre.setColumns(10);
		tfnombre.setBounds(41, 83, 105, 23);
		contentPane.add(tfnombre);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setText("Nombre");
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(41, 50, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		txtpnNombre_1_1 = new JTextPane();
		txtpnNombre_1_1.setText("Fecha de Inicio");
		txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_1.setEditable(false);
		txtpnNombre_1_1.setBounds(41, 134, 140, 23);
		contentPane.add(txtpnNombre_1_1);
		
		cho_dia = new Choice();
		cho_dia.setBounds(41, 171, 58, 18);
		contentPane.add(cho_dia);
		
		cho_mes = new Choice();
		cho_mes.setBounds(111, 171, 58, 18);
		contentPane.add(cho_mes);
		
		anioini = new JTextField();
		anioini.setColumns(10);
		anioini.setBounds(186, 171, 86, 20);
		contentPane.add(anioini);
		
		txtpnNombre_1_2 = new JTextPane();
		txtpnNombre_1_2.setText("Fecha de Cierre");
		txtpnNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_2.setEditable(false);
		txtpnNombre_1_2.setBounds(41, 214, 140, 23);
		contentPane.add(txtpnNombre_1_2);
		
		cho_dia_1 = new Choice();
		cho_dia_1.setBounds(41, 251, 58, 18);
		contentPane.add(cho_dia_1);
		
		cho_mes_1 = new Choice();
		cho_mes_1.setBounds(111, 251, 58, 18);
		contentPane.add(cho_mes_1);
		
		aniofin = new JTextField();
		aniofin.setColumns(10);
		aniofin.setBounds(186, 251, 86, 20);
		contentPane.add(aniofin);
		
		asist = new JTextField();
		asist.setColumns(10);
		asist.setBounds(329, 83, 133, 23);
		contentPane.add(asist);
		
		txtpnNombre = new JTextPane();
		txtpnNombre.setText("Total Asistido");
		txtpnNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre.setEditable(false);
		txtpnNombre.setBounds(329, 50, 96, 23);
		contentPane.add(txtpnNombre);
		
		txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setText("Descripción");
		txtpnNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_2.setEditable(false);
		txtpnNombre_2.setBounds(41, 301, 86, 23);
		contentPane.add(txtpnNombre_2);
		
		desc = new JEditorPane();
		desc.setBounds(41, 344, 231, 120);
		contentPane.add(desc);
		
		JTextPane txtpnCostoUnitarioR = new JTextPane();
		txtpnCostoUnitarioR.setText("Costo Unitario R$");
		txtpnCostoUnitarioR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnCostoUnitarioR.setEditable(false);
		txtpnCostoUnitarioR.setBounds(329, 134, 118, 23);
		contentPane.add(txtpnCostoUnitarioR);
		
		costo = new JTextField();
		costo.setColumns(10);
		costo.setBounds(329, 167, 133, 23);
		contentPane.add(costo);
		
		JTextPane txtpnNombre_3_1 = new JTextPane();
		txtpnNombre_3_1.setText("Tipo de Evento");
		txtpnNombre_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_3_1.setEditable(false);
		txtpnNombre_3_1.setBounds(329, 214, 118, 23);
		contentPane.add(txtpnNombre_3_1);
		
		Choice cho_tipos = new Choice();
		cho_tipos.setBounds(329, 251, 133, 25);
		contentPane.add(cho_tipos);
		cho_tipos.add("Noche de Samba");
		cho_tipos.add("General");
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(353, 424, 96, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SQLController app = new SQLController();
				app.connect();
				String nom = tfnombre.getText();
				String histo = desc.getText();
				String asis = asist.getText();
				String cost = costo.getText();
				int costouni = 0;
				
				String diaini = cho_dia.getSelectedItem();
				String mesini = cho_mes.getSelectedItem();
				String anoini = anioini.getText();
				String fechaini = diaini+"/"+mesini+"/"+anoini;

				String diafin = cho_dia_1.getSelectedItem();
				String mesfin = cho_mes_1.getSelectedItem();
				String anofin = aniofin.getText();
				String fechafin = diafin+"/"+mesfin+"/"+anofin;
				
				String tipo = cho_tipos.getSelectedItem();
				String nomEsc = cho_escue.getSelectedItem();
				
				int fine = 1;
				ManejoDeString man = new ManejoDeString();
				
				if ( man.ValidarString(nom) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( nom.length() <= 1 || nom.length() >= 20) {
					JOptionPane.showMessageDialog(null, "El Nombre debe tener dos letras como minimo, 20 como maximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarString(histo) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Descripción", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} if ( histo.length() >= 80) {
					JOptionPane.showMessageDialog(null, " La descripción debe tener dos letras como mínimo, 20 como máximo", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarInt(asis) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Total Asistencia", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				if ( cost.length()==0 ) {
					JOptionPane.showMessageDialog(null, "El costo unitario no puede quedar vacio", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} else if ( man.ValidarInt(cost) == false ) {
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Costo Unitario", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} else {
					if ( Integer.parseInt(cost)>0 ) {
						costouni = Integer.parseInt(cost);	
					} else { 
						JOptionPane.showMessageDialog(null, "El costo unitario minimo es 1", "Error", JOptionPane.ERROR_MESSAGE);
						fine = 0;
					}	
				}
				
				if ( Integer.parseInt(anoini) > Integer.parseInt(anofin) ) {
					JOptionPane.showMessageDialog(null, "La Fecha de Cierre no puede ser anterior a la de Inicio", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				} else if ( Integer.parseInt(anoini) == Integer.parseInt(anofin) ) {
					if ( Integer.parseUnsignedInt(mesini) > Integer.parseUnsignedInt(mesfin) ) {
						JOptionPane.showMessageDialog(null, "La Fecha de Cierre no puede ser anterior a la de Inicio", "Error", JOptionPane.ERROR_MESSAGE);
						fine = 0;		
					} else if ( Integer.parseUnsignedInt(mesini) == Integer.parseUnsignedInt(mesfin) ) {
						if ( Integer.parseUnsignedInt(diaini) > Integer.parseUnsignedInt(diafin) ) {
							JOptionPane.showMessageDialog(null, "La Fecha de Cierre no puede ser anterior a la de Inicio", "Error", JOptionPane.ERROR_MESSAGE);
							fine = 0;		
						}
					}
				}
				
				if (fine==1) {
					
					try {
						String type = "";
						int id = 0;
						
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
						
						String t = "";
						if ( tipo == "Noche de Samba" ) { type = "NS";
						} else { type = "G"; }
						
						if (asis.length()==0) {
							t = "("+id+",'"+nom+"',"+costouni+",'"+type+"','"+fechaini+"','"+fechafin+"','"+histo+"')";
							app.insertarHist_Evento_SinAsis(t);	
						} else {
							t = "("+id+",'"+nom+"',"+costouni+",'"+type+"','"+fechaini+"','"+fechafin+"',"+asis+",'"+histo+"')";
							app.insertarHist_Evento(t);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				
			}
		});
		btnConfirmar.setBounds(353, 378, 96, 36);
		contentPane.add(btnConfirmar);
		
		txtpnNombre_3 = new JTextPane();
		txtpnNombre_3.setText("Escuela");
		txtpnNombre_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_3.setEditable(false);
		txtpnNombre_3.setBounds(329, 289, 72, 23);
		contentPane.add(txtpnNombre_3);
		
		cho_escue = new Choice();
		cho_escue.setBounds(329, 329, 200, 18);
		contentPane.add(cho_escue);
		
		SQLController app = new SQLController();
		app.connect();
		try {
			ResultSet n = app.consultar("SELECT nombre, idescuela FROM vah_escuelas");
			while(n.next()) {
			      String nombre = n.getString("nombre");
			      int idd = n.getInt("idescuela"); 
			      cho_escue.add(idd+" - "+nombre);	      
			}
			n.close();	
		} catch (SQLException e1) { e1.printStackTrace(); }

		cho_mes.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { actFechas(); }
        });
		cho_dia.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { 
        		if ( anioini.getText().equals("") == true ) anioini.setText("2000");
        		int ano = Integer.parseInt( anioini.getText() );
        		if ( ano%4==0 ) { actFechas(); }
        	}
        });
		cho_mes_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { actFechas2(); }
        });
		cho_dia_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { 
        		if ( aniofin.getText().equals("") == true ) aniofin.setText("2000");
        		int ano = Integer.parseInt( aniofin.getText() );
        		if ( ano%4==0 ) { actFechas2(); }
        	}
        });
		int aa = 1;
		int bb = 0;
		for (int xx=0; xx<12; xx++) {
			if (aa==10) { aa=0; bb++; }
			cho_mes.add("" + bb + aa );
			cho_mes_1.add("" + bb + aa );
			aa++;
		}
		
		actFechas();
		actFechas2();
		
	}
	
	
	public void actFechas2() {
		cho_dia_1.removeAll();
		String mx = cho_mes_1.getSelectedItem();
		int cy=0, aa=1, bb =0;
		
		if ( aniofin.getText().equals("") == true ) aniofin.setText("2000");
		int ano = Integer.parseInt( aniofin.getText() );
		if ( mx.equals("01") || mx.equals("03") || mx.equals("05") || mx.equals("07")  || mx.equals("08")  || mx.equals("10")  || mx.equals("12") ) {
			cy = 31;
		} else if ( mx.equals("02") ) { 
			if ( ano%4==0 ) cy = 29;
			else cy = 28;
		} else { cy = 30; }
		
		for (int xx=0; xx<cy; xx++) {
			if (aa==10) { aa=0; bb++; }
			cho_dia_1.add( "" + bb + aa  );
			aa++;
		}
	}
		
	public void actFechas() {
		cho_dia.removeAll();
		String mx = cho_mes.getSelectedItem();
		int cy=0, aa=1, bb =0;
		
		if ( anioini.getText().equals("") == true ) anioini.setText("2000");
		int ano = Integer.parseInt( anioini.getText() );
		if ( mx.equals("01") || mx.equals("03") || mx.equals("05") || mx.equals("07")  || mx.equals("08")  || mx.equals("10")  || mx.equals("12") ) {
			cy = 31;
		} else if ( mx.equals("02") ) { 
			if ( ano%4==0 ) cy = 29;
			else cy = 28;
		} else { cy = 30; }
		
		for (int xx=0; xx<cy; xx++) {
			if (aa==10) { aa=0; bb++; }
			cho_dia.add( "" + bb + aa  );
			aa++;
		}
	}
	
}
