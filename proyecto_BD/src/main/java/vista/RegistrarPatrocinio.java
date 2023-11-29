package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.SQLController;
import controlador.ManejoDeString;

import javax.swing.JToolBar;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Choice;

public class RegistrarPatrocinio extends JFrame {

	private JPanel contentPane;
	private SQLController sqlController = new SQLController();
	private JFrame thisInstance = this;
	private ArrayList<Integer> arrayIdsNat = new ArrayList<>();
	private ArrayList<Integer> arrayIdsEmp = new ArrayList<>();

	private ArrayList<Integer> arryIdsEsc = new ArrayList<>();
	Choice cho_mes, cho_dia,cho_mes_1, cho_dia_1;
	private JTextField cho_ano;
	private JTextField cho_ano_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPatrocinio frame = new RegistrarPatrocinio();
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
	public RegistrarPatrocinio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistrarPersonaNatural = new JLabel("Registrar Patrocinio");
		lbl_RegistrarPersonaNatural.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RegistrarPersonaNatural.setBounds(180, 11, 200, 17);
		contentPane.add(lbl_RegistrarPersonaNatural);
		
		JLabel lbl_Nombre = new JLabel("Fecha Inicio*");
		lbl_Nombre.setBounds(10, 107, 112, 14);
		contentPane.add(lbl_Nombre);
		
		JLabel lbl_CNPJ = new JLabel("Tipo de Patrocinador *");
		lbl_CNPJ.setBounds(10, 210, 150, 14);
		contentPane.add(lbl_CNPJ);
		
		Choice PersonasNaturales = new Choice();
		PersonasNaturales.setEnabled(false);
		PersonasNaturales.setBounds(233, 132, 257, 20);
		contentPane.add(PersonasNaturales);
		PersonasNaturales.add("NONE");
		arrayIdsNat.add(0);


		
		

		
		Choice Escuelas = new Choice();
		Escuelas.setBounds(10, 68, 310, 20);
		contentPane.add(Escuelas);
		llenarescuelas(Escuelas,arryIdsEsc);

		
		
		Choice PersonasJuridicas = new Choice();
		PersonasJuridicas.setEnabled(false);
		PersonasJuridicas.setBounds(233, 184, 257, 20);
		contentPane.add(PersonasJuridicas);
		PersonasJuridicas.add("NONE");
		arrayIdsEmp.add(0);


		
		JLabel lbl_Personas_Naturales = new JLabel("Personas Naturales");
		lbl_Personas_Naturales.setBounds(233, 107, 163, 14);
		contentPane.add(lbl_Personas_Naturales);

		
		JRadioButton rdbtn_PersonaNatural = new JRadioButton("Persona Natural");
		rdbtn_PersonaNatural.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonasNaturales.setEnabled(true);
				PersonasJuridicas.setEnabled(false);
				PersonasNaturales.removeAll();
				arrayIdsNat.clear();
				llenarpersonasnaturales(PersonasNaturales,arrayIdsNat);
				PersonasJuridicas.removeAll();
				PersonasJuridicas.add("NONE");

			}
		});
		rdbtn_PersonaNatural.setBounds(10, 237, 122, 23);
		contentPane.add(rdbtn_PersonaNatural);
		
		JRadioButton rdbtn_PersonaJuridica = new JRadioButton("Persona Juridica");
		rdbtn_PersonaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonasNaturales.setEnabled(false);
				PersonasJuridicas.setEnabled(true);
				PersonasJuridicas.removeAll();
				arrayIdsEmp.clear();
				llenarpersonasjuridicas(PersonasJuridicas,arrayIdsEmp);
				PersonasNaturales.removeAll();
				PersonasNaturales.add("NONE");
			}
		});
		rdbtn_PersonaJuridica.setBounds(10, 263, 122, 23);
		contentPane.add(rdbtn_PersonaJuridica);
		
		ButtonGroup grupoBtnTipo = new ButtonGroup();
		grupoBtnTipo.add(rdbtn_PersonaNatural);
		grupoBtnTipo.add(rdbtn_PersonaJuridica);
		
		JLabel lbl_ErrorFechaInicio = new JLabel("ERROR");
		lbl_ErrorFechaInicio.setEnabled(true);
		lbl_ErrorFechaInicio.setVisible(false);
		lbl_ErrorFechaInicio.setForeground(Color.RED);
		lbl_ErrorFechaInicio.setBounds(164, 107, 46, 14);
		contentPane.add(lbl_ErrorFechaInicio);
		
		
		JLabel lblErrorTipoPatrocinador = new JLabel("ERROR");
		lblErrorTipoPatrocinador.setForeground(Color.RED);
		lblErrorTipoPatrocinador.setVisible(false);
		lblErrorTipoPatrocinador.setBounds(138, 251, 46, 14);
		contentPane.add(lblErrorTipoPatrocinador);
		
		JLabel lblErrorFechaFin = new JLabel("ERROR");
		lblErrorFechaFin.setForeground(Color.RED);
		lblErrorFechaFin.setVisible(false);
		lblErrorFechaFin.setBounds(164, 163, 46, 14);
		contentPane.add(lblErrorFechaFin);		
		
		
		JLabel lblErrorEscuelas = new JLabel("ERROR");
		lblErrorEscuelas.setForeground(Color.RED);
		lblErrorEscuelas.setVisible(false);
		lblErrorEscuelas.setBounds(334, 68, 46, 14);
		contentPane.add(lblErrorEscuelas);
		
		JLabel lblErrorNaturales = new JLabel("ERROR");
		lblErrorNaturales.setForeground(Color.RED);
		lblErrorNaturales.setVisible(false);
		lblErrorNaturales.setBounds(444, 103, 46, 23);
		contentPane.add(lblErrorNaturales);
		
		JLabel lblErrorJuridicas = new JLabel("ERROR");
		lblErrorJuridicas.setForeground(Color.RED);
		lblErrorJuridicas.setVisible(false);
		lblErrorJuridicas.setBounds(444, 163, 46, 14);
		contentPane.add(lblErrorJuridicas);
		
        cho_ano = new JTextField();
        cho_ano.setColumns(10);
        cho_ano.setBounds(141, 132, 86, 20);
        contentPane.add(cho_ano);
        
        cho_dia = new Choice();
        cho_dia.setBounds(10, 132, 58, 36);
        contentPane.add(cho_dia);
        
        cho_mes = new Choice();
        cho_mes.setBounds(74, 132, 58, 18);
        contentPane.add(cho_mes);
        
		JRadioButton rdbtnFechaFin = new JRadioButton("Fecha Fin");
		rdbtnFechaFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFechaFin.isSelected())
				{
					cho_dia_1.setEnabled(true);
					cho_mes_1.setEnabled(true);
					cho_ano_1.setEnabled(true);
				}
				else
				{
					cho_dia_1.setEnabled(false);
					cho_mes_1.setEnabled(false);
					cho_ano_1.setEnabled(false);
				}
			}
		});
		
		Button butn_Confirmar = new Button("Confirmar");
		butn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_ErrorFechaInicio.setVisible(false);
				lblErrorTipoPatrocinador.setVisible(false);
				lblErrorFechaFin.setVisible(false);
				lblErrorTipoPatrocinador.setVisible(false);
				lblErrorEscuelas.setVisible(false);
				lbl_ErrorFechaInicio.setVisible(false);
				
				SQLController app = new SQLController();
		    	String sql = new String("INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,");
		    	String values = new String(" VALUES(");
				String FechaFin = new String("");	
				ManejoDeString validar = new ManejoDeString();
				boolean ecuela1 = Escuelas.getSelectedItem()!="NONE";
				boolean perjur1 = PersonasJuridicas.getSelectedItem()!="NONE";
				boolean pernat1 = PersonasNaturales.getSelectedItem()!="NONE";
				String dia=cho_dia.getSelectedItem();
				String mes=cho_mes.getSelectedItem();
				String ano=cho_ano.getText();
				String diaf=cho_dia_1.getSelectedItem();
				String mesf=cho_mes_1.getSelectedItem();
				String anof=cho_ano_1.getText();
				boolean ano1= validar.validarnumero(ano)&&ano.length()>=4&&Integer.parseInt(ano)>=1900;
				boolean ano2= validar.validarnumero(anof)&&anof.length()>=4&&Integer.parseInt(anof)>=1900;
				boolean fin=false;
				boolean error=false;

				String FechaInicio=""+dia+"-"+mes+"-"+ano;

				System.out.println(FechaInicio);
				
				if(ecuela1)
				{
					if (ano1)
					{
						if (rdbtnFechaFin.isSelected())
						{
							
						   if (ano2)
						   {
							   int num=validar.validarfechasa(dia, mes, ano, diaf, mesf, anof);
							   if(num==0)
							   {
								   lblErrorFechaFin.setVisible(true);
								   lbl_ErrorFechaInicio.setVisible(true);
									JOptionPane.showMessageDialog(null, "Error en la fecha fin e inicio", "Error", JOptionPane.ERROR_MESSAGE);
									error=true;

							   }
							   else
							   {
								   fin=true; 
								   FechaFin=""+diaf+"-"+mesf+"-"+anof;

							   }
							   
						   }
						   else
						   {
							   lblErrorFechaFin.setVisible(true);
								JOptionPane.showMessageDialog(null, "Error en la fecha fin", "Error", JOptionPane.ERROR_MESSAGE);
								error=true;
						   }
						}
						if (!error) {
							if ((perjur1)||(pernat1))
							{ 
								Integer idPersonaJur=arrayIdsEmp.get(PersonasJuridicas.getSelectedIndex());
								Integer idPersonaNat=arrayIdsNat.get(PersonasNaturales.getSelectedIndex());
								Integer idEscuela=arryIdsEsc.get(Escuelas.getSelectedIndex());
								values=values+idEscuela+",'"+FechaInicio+"',";
								if (fin)
								{
									values=values+"'"+FechaFin+"',";
							    	sql=sql+"fechafin,";
	
								}
								if (perjur1) 
								{
									values=values+""+idPersonaJur+");";
							    	sql=sql+"idPersonaJur)";
								}
								else
								{
									values=values+""+idPersonaNat+");";
							    	sql=sql+"idPersonanat)";
	
								}
								System.out.println(sql);
								System.out.println(values);

							app.connect();
							try {
								if(!rdbtnFechaFin.isSelected()) {
									System.out.println(sql);
									System.out.println(values);
									String consultar = new String("");
									if(pernat1) 
									{consultar=("select  w.idpatrocinio "
											+" from VAH_Hist_patrocinios w "+
											"where w.idpersonanat="+idPersonaNat+" and w.idescuela="+idEscuela+" and (w.fechafin is null)");}
									else {consultar= ("select  w.idpatrocinio"+
														" from VAH_Hist_patrocinios w "+
														"where w.idpersonajur="+idPersonaJur+" and w.idescuela="+idEscuela+" and (w.fechafin is null)");
									}
									System.out.println(consultar);
									ResultSet datos =app.SelectQuery(consultar);
									String dato = "";
									while (datos.next()) 
									{
									    dato = 	datos.getString("idpatrocinio");
										System.out.println(dato);
									}
									System.out.println("dato="+dato);
									if(dato=="")
									{
										app.UpdateQuery(sql+values);
										if (pernat1) {JOptionPane.showMessageDialog(null, "Historico de persona natural agregado", "Agregado", JOptionPane.ERROR_MESSAGE);}
										else
										{JOptionPane.showMessageDialog(null, "Historico de persona juridica agregado", "Agregado", JOptionPane.ERROR_MESSAGE);}
									}
									else
									{
										if (pernat1) {JOptionPane.showMessageDialog(null, "Error esa persona natural ya tiene un patrocinio en esa escuela", "Error", JOptionPane.ERROR_MESSAGE);}
										else
										{JOptionPane.showMessageDialog(null, "Error esa persona juridica ya tiene un patrocinio en esa escuela", "Error", JOptionPane.ERROR_MESSAGE);}
									}
								}
								else
								{
									System.out.println(sql);
									System.out.println(values);
									String consultar = new String("");
									if(pernat1) 
									{consultar=("select  w.idpatrocinio "+
									" from VAH_Hist_patrocinios w where '"+FechaFin+"'> coalesce (w.fechainicio,Current_date) and (w.idpersonanat="+idPersonaNat+") and (idescuela="+idEscuela+")");}
									else {consultar=("select  w.idpatrocinio "+
											" from VAH_Hist_patrocinios w where '"+FechaFin+"'> coalesce (w.fechainicio,Current_date)and (w.idpersonajur="+idPersonaJur+") and (idescuela="+idEscuela+")");}
									System.out.println(consultar);
									ResultSet datos =app.SelectQuery(consultar);
									String dato = "";
									while (datos.next()) 
									{
									    dato = 	datos.getString("idpatrocinio");
										System.out.println(dato);
									}
									System.out.println("dato="+dato);
									if(dato=="")
									{
										app.UpdateQuery(sql+values);
										if (pernat1) {JOptionPane.showMessageDialog(null, "Historico de persona natural agregado", "Agregado", JOptionPane.ERROR_MESSAGE);}
										else
										{JOptionPane.showMessageDialog(null, "Historico de persona juridica agregado", "Agregado", JOptionPane.ERROR_MESSAGE);}
									}
									else
									{
										if (pernat1) {JOptionPane.showMessageDialog(null, "Error esa persona natural ya tiene un historico en ese intervalo de fecha", "Error", JOptionPane.ERROR_MESSAGE);}
										else
										{JOptionPane.showMessageDialog(null, "Error esa persona juridica ya tiene un historico en ese intervalo de fecha", "Error", JOptionPane.ERROR_MESSAGE);}
									}
								}
								
							} 
							catch (SQLException e1) {}				
							}
							else
							{
								lblErrorTipoPatrocinador.setVisible(true);
								JOptionPane.showMessageDialog(null, "Error el historico de patrocinio debe tener una persona natural o juridica asociada ", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else
					{
						lbl_ErrorFechaInicio.setVisible(true);
						JOptionPane.showMessageDialog(null, "Error en la fecha de inicio ", "Error", JOptionPane.ERROR_MESSAGE);

					}
				}
				else
				{
					lblErrorEscuelas.setVisible(true);
					JOptionPane.showMessageDialog(null, "Error debe registrar una escuela al historico de patrocinio", "Error", JOptionPane.ERROR_MESSAGE);}
				}
			});
		butn_Confirmar.setBounds(359, 264, 70, 22);
		contentPane.add(butn_Confirmar);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
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
		btn_Cancelar.setBounds(435, 263, 89, 23);
		contentPane.add(btn_Cancelar);
		
		JLabel lbl_Escuelas = new JLabel("Escuelas de Samba *");
		lbl_Escuelas.setBounds(10, 39, 370, 23);
		contentPane.add(lbl_Escuelas);
		
		cho_dia_1 = new Choice();
		cho_dia_1.setBounds(10, 184, 58, 20);
		contentPane.add(cho_dia_1);
		
		cho_mes_1 = new Choice();
		cho_mes_1.setBounds(74, 184, 58, 20);
		contentPane.add(cho_mes_1);
		
		cho_ano_1 = new JTextField();
		cho_ano_1.setColumns(10);
		cho_ano_1.setBounds(138, 184, 86, 20);
		contentPane.add(cho_ano_1);
		
		cho_dia_1.setEnabled(false);
		cho_mes_1.setEnabled(false);
		cho_ano_1.setEnabled(false);
		

		rdbtnFechaFin.setBounds(13, 159, 109, 23);
		contentPane.add(rdbtnFechaFin);
		
		JLabel lbl_Personas_Juridicas = new JLabel("Personas Juridicas");
		lbl_Personas_Juridicas.setBounds(233, 164, 163, 14);
		contentPane.add(lbl_Personas_Juridicas);
		
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
		int aa1 = 1;
		int bb1 = 0;
		for (int xx=0; xx<12; xx++) {
			if (aa1==10) { aa1=0; bb1++; }
			cho_mes_1.add("" + bb1 + aa1 );
			aa1++;
		}
		actFechas();
		
	}
	
	private void llenarpersonasnaturales(Choice PersonasNaturales, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectCuatroCampos("VAH_Personas_Naturales", "idpersona", "primap","primnom","segap"); 
			while (datos.next()) 
			{
			    String dato = "";
			    dato = 	datos.getString("primnom") + " - " + datos.getString("primap")+ "-"+ datos.getString("segap")+"";
				arrayIds.add(datos.getInt("idpersona"));
				PersonasNaturales.add(dato);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void llenarpersonasjuridicas(Choice PersonasJuridicas, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectTresCampos("VAH_Personas_Juridicas", "idempresa", "tipoempresa","nombre"); 
			while (datos.next()) 
			{
			    String dato = "";
			    dato = 	datos.getString("nombre") + " - " + datos.getString("tipoempresa")+"";
				arrayIds.add(datos.getInt("idempresa"));
				PersonasJuridicas.add(dato);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void llenarescuelas(Choice Escuelas, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectDosCampos("VAH_escuelas", "idescuela","nombre"); 
			while (datos.next()) 
			{
			    String dato = "";
			    dato = 	datos.getString("nombre")+"";
				arrayIds.add(datos.getInt("idescuela"));
				Escuelas.add(dato);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		cho_dia_1.removeAll();
		String mx1 = cho_mes_1.getSelectedItem();
		int cy1=0, aa1=1, bb1 =0;
		
		if ( cho_ano_1.getText().equals("") == true ) cho_ano_1.setText("2023");
		int ano1 = Integer.parseInt( cho_ano_1.getText() );
		if ( mx1.equals("01") || mx1.equals("03") || mx1.equals("05") || mx1.equals("07")  || mx1.equals("08")  || mx1.equals("10")  || mx1.equals("12") ) {
			cy1 = 31;
		} else if ( mx1.equals("02") ) { 
			if ( ano1%4==0 ) cy1 = 29;
			else cy1 = 28;
		} else { cy1 = 30; }
		
		for (int xx=0; xx<cy1; xx++) {
			if (aa1==10) { aa1=0; bb1++; }
			cho_dia_1.add( "" + bb1 + aa1  );
			aa1++;
		}
	}
}
