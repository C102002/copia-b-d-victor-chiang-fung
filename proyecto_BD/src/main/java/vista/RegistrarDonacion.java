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

public class RegistrarDonacion extends JFrame {

	private JPanel contentPane;
	private SQLController sqlController = new SQLController();
	private ArrayList<Integer> arrayIdsHist = new ArrayList<>();
	private ArrayList<Integer> arrayIdsEsc = new ArrayList<>();
	Choice cho_mes, cho_dia;
	private JTextField cho_ano;
	private JTextField Monto;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarDonacion frame = new RegistrarDonacion();
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
	public RegistrarDonacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistrarPersonaNatural = new JLabel("Registrar Donacion");
		lbl_RegistrarPersonaNatural.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RegistrarPersonaNatural.setBounds(180, 11, 200, 17);
		contentPane.add(lbl_RegistrarPersonaNatural);
		
		JLabel lbl_Nombre = new JLabel("Fecha Donacion*");
		lbl_Nombre.setBounds(10, 107, 112, 14);
		contentPane.add(lbl_Nombre);

		
		Choice Hist_Patrocinios = new Choice();
		Hist_Patrocinios.setBounds(10, 68, 475, 20);
		contentPane.add(Hist_Patrocinios);
		llenarhistpatrocinios(Hist_Patrocinios,arrayIdsHist,arrayIdsEsc);
		arrayIdsHist.add(0);
		
		
		JLabel lbl_ErrorFechaInicio = new JLabel("ERROR");
		lbl_ErrorFechaInicio.setEnabled(true);
		lbl_ErrorFechaInicio.setVisible(false);
		lbl_ErrorFechaInicio.setForeground(Color.RED);
		lbl_ErrorFechaInicio.setBounds(181, 107, 46, 14);
		contentPane.add(lbl_ErrorFechaInicio);
		
		
		JLabel lblErrorMonto = new JLabel("ERROR");
		lblErrorMonto.setForeground(Color.RED);
		lblErrorMonto.setVisible(false);
		lblErrorMonto.setBounds(164, 175, 46, 14);
		contentPane.add(lblErrorMonto);
		
		
		JLabel lblErrorHistPatro = new JLabel("ERROR");
		lblErrorHistPatro.setForeground(Color.RED);
		lblErrorHistPatro.setVisible(false);
		lblErrorHistPatro.setBounds(274, 39, 46, 14);
		contentPane.add(lblErrorHistPatro);
		
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
		
		Button butn_Confirmar = new Button("Confirmar");
		butn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_ErrorFechaInicio.setVisible(false);
				lblErrorMonto.setVisible(false);
				lblErrorMonto.setVisible(false);
				lblErrorHistPatro.setVisible(false);
				lbl_ErrorFechaInicio.setVisible(false);
				
				SQLController app = new SQLController();
		    	String sql = new String("INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto)");
		    	String values = new String(" VALUES(");
				ManejoDeString validar = new ManejoDeString();
				boolean patrocinios1 = Hist_Patrocinios.getSelectedItem()!="NONE";

				String dia=cho_dia.getSelectedItem();
				String mes=cho_mes.getSelectedItem();
				String ano=cho_ano.getText();
				String monto=Monto.getText();

				boolean ano1= validar.validarnumero(ano)&&ano.length()>=4&&Integer.parseInt(ano)>=1900;
				boolean monto1=validar.validarnumero(monto);
				String FechaDonacion=""+dia+"-"+mes+"-"+ano;

				System.out.println(FechaDonacion);
				
				if(patrocinios1)
				{
					if (ano1)
					{
						if (monto1)
						{ 
							Integer idHistPatrocinio=arrayIdsHist.get(Hist_Patrocinios.getSelectedIndex());
							Integer idEscuela=arrayIdsEsc.get(Hist_Patrocinios.getSelectedIndex());
							values=values+idEscuela+","+idHistPatrocinio+",'"+FechaDonacion+"',"+monto+");";
	
								System.out.println(sql);
								System.out.println(values);	
								String consultar= new String("select idpatrocinio from VAH_hist_patrocinios\r\n"
									+ "where (fechainicio <= '"+FechaDonacion+"') and ('"+FechaDonacion+"'<= coalesce (fechafin, Current_date)) and (idpatrocinio="+idHistPatrocinio+")");
								app.connect();
								try {
										System.out.println(consultar);
										ResultSet datos =app.SelectQuery(consultar);
										String dato = "";
										while (datos.next()) 
										{
										    dato = 	datos.getString("idpatrocinio");
											System.out.println(dato);
										}
										System.out.println("dato="+dato);
										if(dato!="")
										{
											app.UpdateQuery(sql+values);
											{JOptionPane.showMessageDialog(null, "Donacion agregada", "Agregado", JOptionPane.ERROR_MESSAGE);}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Error la fecha ingresada no esta en el intervalo de la donacion", "Error", JOptionPane.ERROR_MESSAGE);
										}
								}
								catch (SQLException e1) {}				
						}
						else 
						{
							lblErrorMonto.setVisible(true);
							JOptionPane.showMessageDialog(null, "Error en el monto de la donacion ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						lbl_ErrorFechaInicio.setVisible(true);
						JOptionPane.showMessageDialog(null, "Error debe registrar una fecha correcta", "Error", JOptionPane.ERROR_MESSAGE);

					}
				}
				else
				{	lblErrorHistPatro.setVisible(true);
					JOptionPane.showMessageDialog(null, "Error debe registrar un patrocinio primero", "Error", JOptionPane.ERROR_MESSAGE);
				}
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
		
		JLabel lbl_Hist_Patrocinios = new JLabel("Historico de Patrocinios*");
		lbl_Hist_Patrocinios.setBounds(10, 39, 370, 23);
		contentPane.add(lbl_Hist_Patrocinios);
		
		JLabel lbl_Monto = new JLabel("Monto*");
		lbl_Monto.setBounds(10, 175, 112, 14);
		contentPane.add(lbl_Monto);
		
		Monto = new JTextField();
		Monto.setColumns(10);
		Monto.setBounds(10, 200, 122, 20);
		contentPane.add(Monto);
		
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
		actFechas();
		
	}
	
	private void llenarhistpatrocinios(Choice HistPatrocinios, ArrayList<Integer> arrayIds,ArrayList<Integer> arrayIdsEsc) 
	{
	    String nombre = "";
	    String nombreesc = "";


		try {
			ResultSet datos = sqlController.SelectAll("VAH_hist_Patrocinios"); 
			while (datos.next()) 
			{
			    String dato = "";
			    if( datos.getString("idpersonanat") != null)
			    {
			    	String id = datos.getString("idpersonanat");
					ResultSet datos1 = sqlController.SelectQuery("Select primnom,primap from VAH_personas_naturales where idpersona="+id);
					while(datos1.next())
					{
					    nombre = "";
					    nombre=datos1.getString("primnom");
					    nombre=nombre+" "+datos1.getString("primap");
					}
				}
			    else
			    {
			    	String id = datos.getString("idpersonajur");
					ResultSet datos1 = sqlController.SelectQuery("Select nombre,tipoempresa from VAH_personas_juridicas where idempresa="+id);
					while(datos1.next())
					{
					    nombre = "";
					    nombre=datos1.getString("nombre");					}
			    }
		    	String idescuela = datos.getString("idescuela");
				ResultSet datos1 = sqlController.SelectQuery("Select nombre from VAH_escuelas where idescuela="+idescuela);
				while(datos1.next())
				{
				    nombreesc = "";
				    nombreesc=datos1.getString("nombre");
				}
			    dato = nombreesc+ " - "+nombre+" - "+datos.getString("fechainicio")+" - "+datos.getString("fechafin");
				arrayIds.add(datos.getInt("idpatrocinio"));
				arrayIdsEsc.add(datos.getInt("idescuela"));
				HistPatrocinios.add(dato);
			}
			datos=null;
			
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
	}
}
