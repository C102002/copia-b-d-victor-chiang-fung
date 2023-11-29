package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Label;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;

public class aggEscuela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JMenuItem mntmNewMenuItem;
	JMenuItem mntmNewMenuItem_1;
	private JTextField textField_2;
	Choice choice_1, choice_1_1, choice_1_2, choice;
	JEditorPane editorPane;
	private JTextPane txtpnError_1, txtpnError_2, txtpnError_3, txtpnError_4, txtpnError_5, txtpnError_6;
	
	private int actCiu = 0;
	private int actCol = 0;
	private JTextField cho_ano;
	private JTextField textField_pais;
	private JTextField textField_area;
	private JTextField textField_num;
	Choice cho_mes, cho_dia;
	
	public static void main(String[] args) {
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
	
	public aggEscuela() {
		init();		
		JButton btnNewButton = new JButton("Cancelar");
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
		btnNewButton.setBounds(530, 573, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pais= textField_pais.getText();
				String area= textField_area.getText();
				String num= textField_num.getText();	

				SQLController app = new SQLController();
				String nom = textField.getText();
				
				String d = cho_dia.getSelectedItem();
				String me = cho_mes.getSelectedItem();
				String an = cho_ano.getText();
				
				String fecha = d+"/"+me+"/"+an;
				
				String dir = textField_2.getText();
				String his = editorPane.getText();
				
				int fine = 1;
				int idciu=0, idest=0;
				
				String ca = choice_1.getSelectedItem();
				String ciu_est = choice.getSelectedItem();
				app.connect();
				
				ManejoDeString man = new ManejoDeString();
				
				if ( man.ValidarString(nom) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarString(dir) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
				if ( man.ValidarString(his) == true) {
				} else { 
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos en el campo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					fine = 0;
				}
				
		        if (ca=="NONE") { // COLOR A
		        	JOptionPane.showMessageDialog(null, "Debes elegir, al menos, un Color", "Error", JOptionPane.ERROR_MESSAGE);
					txtpnError_5.setVisible(true); 
		        	fine = 0;
			    } else { txtpnError_5.setVisible(false); } 
		        
		        if (ciu_est=="NONE") { // CIUDAD
		        	JOptionPane.showMessageDialog(null, "Debes elegir una Ciudad", "Error", JOptionPane.ERROR_MESSAGE);
		        	txtpnError_4.setVisible(true); 
		        	fine = 0;
			    } else { txtpnError_4.setVisible(false); } 
		        
		        
		        if (nom.length() < 2 || nom.length() > 50) { // NOMBRE
					JOptionPane.showMessageDialog(null, "El Nombre debe contener más a dos letras y menos de 50 letras", "Error", JOptionPane.ERROR_MESSAGE);
		        	txtpnError_1.setVisible(true); 
		        	fine = 0;
			    } else { txtpnError_1.setVisible(false); } 
		        
		        
		        if (dir.length() < 2 || dir.length() > 100) { // DIRECCION
		        	JOptionPane.showMessageDialog(null, "La Dirección debe contener más a dos letras y menos de 100 letras", "Error", JOptionPane.ERROR_MESSAGE);
			        txtpnError_2.setVisible(true); 
		        	fine = 0;
			    } else { txtpnError_2.setVisible(false); }
		        
		        if (his.length() < 2 || his.length() > 500) { // HISTORIA
		        	JOptionPane.showMessageDialog(null, "La Historia debe contener más a dos letras y menos de 499 letras", "Error", JOptionPane.ERROR_MESSAGE);
			        txtpnError_6.setVisible(true); 
		        	fine = 0;
			    } else { txtpnError_6.setVisible(false); }
		        
	        	if (ca != "NONE" && ciu_est != "NONE" && fine == 1) {
	        		try {
	        			ResultSet n = app.consultar("SELECT idciudad, nombre, idestado FROM vah_ciudades");
	        		
	        			while(n.next()) {
	        				ResultSet bus = app.consultar("SELECT nombre FROM vah_estados WHERE idestado=" + n.getInt("idestado"));
	        					
	        				while(bus.next()) {
	        				    String m = n.getString("nombre") + " - " + bus.getString("nombre");
	        					if ( m.equals(ciu_est) == true ) {
	        					    idciu = n.getInt("idciudad");
	        					    idest = n.getInt("idestado");
	        					    break;
	        					}
	        				}
	        				bus.close();
	        			}
	        			n.close();
	        			
	        		} catch (SQLException e1) { e1.printStackTrace(); }
	        		
	        		try {
						int a = 0, b = 0, c = 0;
						String cl = "SELECT idcolor, nombre FROM vah_colores";
					    ResultSet bus = app.consultar(cl);
					    while(bus.next()) {
					    	
					    	if (bus.getString("nombre").equals( choice_1.getSelectedItem() ) == true) {
					    		a = bus.getInt("idcolor");
					    	}
					    	
					    	if (choice_1_1.isEnabled()==true) {
					    		if (bus.getString("nombre").equals( choice_1_1.getSelectedItem() ) == true) {
					    			b = bus.getInt("idcolor");
					    		}
					    	}
					    	if (choice_1_2.isEnabled()==true) {
					    		if (bus.getString("nombre").equals( choice_1_2.getSelectedItem() ) == true) {
					    			c = bus.getInt("idcolor");
					    		}	
					    	}
					    }
					    bus.close();
						
					    int i=app.insertarEscuela(nom,fecha,his,dir,idest,idciu,pais,area,num);
					    app.insertar_Esc_Col(i, a, b, c);    
					    	
					} catch (SQLException e1) { e1.printStackTrace(); }
	        	} else {
	        		
	        	}
			}
		});
		btnConfirmar.setBounds(650, 573, 105, 21);
		contentPane.add(btnConfirmar);
		
        JButton btnNewButton_1 = new JButton("Agregar Ciudad");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		actCiu = 1;
				aggCiudad frame = new aggCiudad();
				frame.setVisible(true);      		
        	} 
        });
		contentPane.add(btnNewButton_1);
        btnNewButton_1.setBounds(705, 143, 140, 21);        
        
        choice_1 = new Choice();
        choice_1.setBounds(170, 300, 133, 18);
        contentPane.add(choice_1);
        choice_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (choice_1.getSelectedItem() != "NONE") {
        			choice_1_1.setEnabled(true);
        			if ( choice_1_1.getSelectedItem() != "NONE" ) {
        				choice_1_2.setEnabled(true);
        			}
        		} else {
        			choice_1_1.setEnabled(false);	
        			choice_1_2.setEnabled(false);		
        		}
        	}
        }); 
        choice_1_1 = new Choice();
        choice_1_1.setBounds(170, 352, 133, 18);
        contentPane.add(choice_1_1);
        choice_1_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (choice_1_1.getSelectedItem() != "NONE") {
        			choice_1_2.setEnabled(true);
        		} else {
        			choice_1_2.setEnabled(false);
        		}
        	}
        });
        choice_1_2 = new Choice();
        choice_1_2.setBounds(170, 409, 133, 18);
        contentPane.add(choice_1_2);
        choice_1_2.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (choice_1_2.getSelectedItem() != "NONE") {} else {}
        	}
        });
        JButton btnNewButton_1_1 = new JButton("Agregar Color");
        btnNewButton_1_1.setBounds(170, 242, 140, 21);
        contentPane.add(btnNewButton_1_1);
        
        txtpnError_6 = new JTextPane();
        txtpnError_6.setForeground(new Color(255, 0, 0));
        txtpnError_6.setText("ERROR");
        txtpnError_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_6.setEditable(false);
        txtpnError_6.setBounds(485, 207, 64, 23);
        contentPane.add(txtpnError_6);
        
        txtpnError_1 = new JTextPane();
        txtpnError_1.setText("ERROR");
        txtpnError_1.setForeground(Color.RED);
        txtpnError_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_1.setEditable(false);
        txtpnError_1.setBounds(134, 53, 64, 23);
        contentPane.add(txtpnError_1);
        
        txtpnError_2 = new JTextPane();
        txtpnError_2.setText("ERROR");
        txtpnError_2.setForeground(Color.RED);
        txtpnError_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_2.setEditable(false);
        txtpnError_2.setBounds(408, 53, 64, 23);
        contentPane.add(txtpnError_2);
        
        txtpnError_3 = new JTextPane();
        txtpnError_3.setText("ERROR");
        txtpnError_3.setForeground(Color.RED);
        txtpnError_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_3.setEditable(false);
        txtpnError_3.setBounds(202, 138, 64, 23);
        contentPane.add(txtpnError_3);
        
        txtpnError_4 = new JTextPane();
        txtpnError_4.setText("ERROR");
        txtpnError_4.setForeground(Color.RED);
        txtpnError_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_4.setEditable(false);
        txtpnError_4.setBounds(375, 119, 64, 23);
        contentPane.add(txtpnError_4);
        
        txtpnError_5 = new JTextPane();
        txtpnError_5.setText("ERROR");
        txtpnError_5.setForeground(Color.RED);
        txtpnError_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnError_5.setEditable(false);
        txtpnError_5.setBounds(332, 295, 64, 23);
        contentPane.add(txtpnError_5);
        
        cho_ano = new JTextField();
        cho_ano.setColumns(10);
        cho_ano.setBounds(203, 175, 86, 20);
        contentPane.add(cho_ano);
        
        textField_pais = new JTextField();
        textField_pais.setText("58");
        textField_pais.setColumns(10);
        textField_pais.setBounds(60, 478, 103, 20);
        contentPane.add(textField_pais);
        
        textField_area = new JTextField();
        textField_area.setText("0412");
        textField_area.setColumns(10);
        textField_area.setBounds(61, 526, 102, 20);
        contentPane.add(textField_area);
        
        textField_num = new JTextField();
        textField_num.setText("7895501");
        textField_num.setColumns(10);
        textField_num.setBounds(61, 574, 102, 20);
        contentPane.add(textField_num);
        
        JLabel lbl_CodInt = new JLabel("Codigo Internacional");
        lbl_CodInt.setBounds(58, 457, 155, 14);
        contentPane.add(lbl_CodInt);
        
        JLabel lblNumeroTelefono = new JLabel("Numero de Telefono");
        lblNumeroTelefono.setBounds(58, 437, 155, 14);
        contentPane.add(lblNumeroTelefono);
        
        JLabel lbl_CodArea = new JLabel("Codigo de Area");
        lbl_CodArea.setBounds(61, 505, 152, 14);
        contentPane.add(lbl_CodArea);
        
        JLabel lbl_NumTel = new JLabel("Numero de telefono");
        lbl_NumTel.setBounds(60, 553, 125, 14);
        contentPane.add(lbl_NumTel);
        
        JTextPane errorinter = new JTextPane();
        errorinter.setForeground(Color.RED);
        errorinter.setText("ERROR");
        errorinter.setBounds(180, 479, 87, 19);
        contentPane.add(errorinter);
        
        JTextPane errorarea = new JTextPane();
        errorarea.setForeground(new Color(255, 0, 0));
        errorarea.setText("ERROR");
        errorarea.setBounds(179, 526, 87, 19);
        contentPane.add(errorarea);
        
        JTextPane errortel = new JTextPane();
        errortel.setText("ERROR");
        errortel.setBounds(179, 573, 87, 19);
        contentPane.add(errortel);
        
        errorinter.setVisible(false);
        errorarea.setVisible(false);
        errortel.setVisible(false);
        
        cho_dia = new Choice();
        cho_dia.setBounds(58, 175, 58, 36);
        contentPane.add(cho_dia);
        
        cho_mes = new Choice();
        cho_mes.setBounds(128, 175, 58, 18);
        contentPane.add(cho_mes);

        txtpnError_1.setVisible(false);
        txtpnError_2.setVisible(false);
        txtpnError_3.setVisible(false);
        txtpnError_4.setVisible(false);
        txtpnError_5.setVisible(false);
        txtpnError_6.setVisible(false);
        
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				aggColor frame = new aggColor();
				actCol = 1;
				frame.setVisible(true);
        	}
        });	
        
		choice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actCiu==1) { actCiudades(); } actCiu = 0;
			}
		});
		
		choice_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actCol==1) { actColor(); } actCol = 0;
			}
		});
		choice_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actCol==1) { actColor(); } actCol = 0;
			}
		});
		choice_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (actCol==1) { actColor(); } actCol = 0;
			}
		});
		
		cho_mes.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { actFechas(); }
        });
		cho_dia.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) { 
        		if ( cho_ano.getText().equals("") == true ) cho_ano.setText("2023");
        		int ano = Integer.parseInt( cho_ano.getText() );
        		if ( ano%4==0 ) { actFechas(); }
        	}
        });
		
		int aa = 1;
		int bb = 0;
		for (int xx=0; xx<12; xx++) {
			if (aa==10) { aa=0; bb++; }
			cho_mes.add("" + bb + aa );
			aa++;
		}
		
		actCiudades();
		actColor();
		actFechas();			
	}
	
	public void actFechas() {
		cho_dia.removeAll();
		String mx = cho_mes.getSelectedItem();
		int cy=0, aa=1, bb =0;
		
		if ( cho_ano.getText().equals("") == true ) cho_ano.setText("2023");
		int ano = Integer.parseInt( cho_ano.getText() );
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
	
	public void actCiudades() {

		SQLController app = new SQLController();
		app.connect();
		choice.removeAll();
		choice.add("NONE");
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
	
	public void actColor() {
		choice_1.removeAll();
		choice_1_1.removeAll();
		choice_1_2.removeAll();
	    choice_1.add("NONE");
	    choice_1_1.add("NONE"); 
	    choice_1_2.add("NONE");
		choice_1_1.setEnabled(false);
		choice_1_2.setEnabled(false);
		
		SQLController app = new SQLController();
		app.connect();
		try {
			ResultSet n = app.consultar("SELECT idcolor, nombre FROM vah_colores");
			while(n.next()) {
			      String nombre = n.getString("nombre");
			      choice_1.add(nombre);
			      choice_1_1.add(nombre);
			      choice_1_2.add(nombre);
			}
			n.close();	
		} catch (SQLException e1) { e1.printStackTrace(); }
	}

	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 904, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(58, 86, 105, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1.setText("Nombre");
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBounds(58, 53, 64, 23);
		contentPane.add(txtpnNombre_1);
		
		JTextPane txtpnNombre_1_0 = new JTextPane();
		txtpnNombre_1_0.setText("Fecha de Fundación");
		txtpnNombre_1_0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNombre_1_0.setEditable(false);
		txtpnNombre_1_0.setBounds(58, 138, 140, 23);
		contentPane.add(txtpnNombre_1_0);
        choice = new Choice();
        choice.setBounds(375, 143, 310, 18);
        contentPane.add(choice);
        
        JTextPane txtpnNombre_1_1 = new JTextPane();
        txtpnNombre_1_1.setText("Ciudad");
        txtpnNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_1.setEditable(false);
        txtpnNombre_1_1.setBounds(293, 143, 64, 23);
        contentPane.add(txtpnNombre_1_1);
        
        JTextPane txtpnNombre_1_1_1 = new JTextPane();
        txtpnNombre_1_1_1.setText("Colores");
        txtpnNombre_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_1_1.setEditable(false);
        txtpnNombre_1_1_1.setBounds(58, 240, 64, 23);
        contentPane.add(txtpnNombre_1_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(277, 86, 568, 23);
        contentPane.add(textField_2);
        
        JTextPane txtpnNombre_1_2 = new JTextPane();
        txtpnNombre_1_2.setText("Dirección de Sede");
        txtpnNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_2.setEditable(false);
        txtpnNombre_1_2.setBounds(277, 53, 119, 23);
        contentPane.add(txtpnNombre_1_2);
        
        JTextPane txtpnNombre_1_3 = new JTextPane();
        txtpnNombre_1_3.setText("Historia");
        txtpnNombre_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_3.setEditable(false);
        txtpnNombre_1_3.setBounds(418, 207, 54, 23);
        contentPane.add(txtpnNombre_1_3);
        
        editorPane = new JEditorPane();
        editorPane.setBounds(418, 240, 409, 258);
        contentPane.add(editorPane); 
        
        JTextPane txtpnNombre_1_1_1_1 = new JTextPane();
        txtpnNombre_1_1_1_1.setText("Color A");
        txtpnNombre_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_1_1_1.setEditable(false);
        txtpnNombre_1_1_1_1.setBounds(58, 295, 64, 23);
        contentPane.add(txtpnNombre_1_1_1_1);
        
        JTextPane txtpnNombre_1_1_1_2 = new JTextPane();
        txtpnNombre_1_1_1_2.setText("Color B");
        txtpnNombre_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_1_1_2.setEditable(false);
        txtpnNombre_1_1_1_2.setBounds(58, 347, 64, 23);
        contentPane.add(txtpnNombre_1_1_1_2);
        
        JTextPane txtpnNombre_1_1_1_3 = new JTextPane();
        txtpnNombre_1_1_1_3.setText("Color C");
        txtpnNombre_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtpnNombre_1_1_1_3.setEditable(false);
        txtpnNombre_1_1_1_3.setBounds(58, 404, 64, 23);
        contentPane.add(txtpnNombre_1_1_1_3);
        
	}
}
