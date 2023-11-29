package controlador;

import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLController {
	 private final String url = "jdbc:postgresql://localhost/BD_Proyecto";
	 private final String user = "postgres";
	 private final String password = "anf24102002";
//	private final String url = "jdbc:postgresql://localhost/proyecto_EscuelasDeSamba";
//	private final String user = "postgres";
//	private final String password = "3004";
// //   private final String url = "jdbc:postgresql://localhost/Proyecto";
//	private final String user = "postgres";
//	private final String password = "1234";
	private Connection connection;
	
	 public void insertarPersNat(String sql, String insert,String pais, String area, String num, String CPF) throws SQLException {
	        Statement st = connection.createStatement();
	        try {
	        st.executeUpdate(sql+insert);
		    	String busqueda = new String("SELECT p.idpersona from VAH_personas_naturales p where p.cpf="+CPF+";");
		    	ResultSet valor = st.executeQuery(busqueda);
		    	int xa = 0;  
		    	while(valor.next()) {
			    	  xa = valor.getInt("idpersona"); 
			      }
			      valor.close();
			      ManejoDeString validar = new ManejoDeString();
				  boolean pais1 = validar.esVacio(pais);
				  boolean area1 = validar.esVacio(area);
				  boolean num1  = validar.esVacio(num);
		
		/*	    	System.out.println(busqueda);
					System.out.println(xa);
					System.out.println(pais);
					System.out.println(area);
					System.out.println(num);
					System.out.println(pais1);
					System.out.println(area1);
					System.out.println(num1);
		*/			
					if ((pais1)&&(area1)&&(num1))
					{
						JOptionPane.showMessageDialog(null, "La persona natural ha sido ingresada exitosamente", "Persona Natural ingresada", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						pais1 = validar.validarPais(pais);
						area1 = validar.validarArea(area);
						num1  = validar.validarnumero(num);
						if ((pais1)&&(area1)&&(num1))
						{
							try
							{
							String sql1 = new String("INSERT INTO VAH_telefonos(codInt, codArea, numero, idpnatural)"
									+ "	VALUES ("+pais+","+area+","+num+","+xa+");");
					    	st.executeUpdate(sql1);
						//	System.out.println(sql1);
							JOptionPane.showMessageDialog(null, "La persona natural ha sido ingresada exitosamente", "Persona Natural ingresada", JOptionPane.WARNING_MESSAGE);
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
								System.out.println(e1.getSQLState() + "--" + e1.getMessage());
								switch (e1.getSQLState()) {
									case "23505": 
										JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
									break;
								}
								//En caso que haya un error al al agregar el telefono de la persona se borra la persona y se devuelve el error
							String sql1=("delete from VAH_Personas_naturales c\r\n"+"where c.cpf="+CPF+"");
					    	st.executeUpdate(sql1);
							System.out.println(sql1);
					    	}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El numero internacional, area y numero deben cumplir con el formato", "Error", JOptionPane.ERROR_MESSAGE);
							String sql1=("delete from VAH_Personas_naturales c\r\n"+"where c.cpf="+CPF+"");
					    	st.executeUpdate(sql1);
						//	System.out.println(sql1);
						}
					}
	    	connection.close();
	    	}
	    	catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println(e1.getSQLState() + "--" + e1.getMessage());
				switch (e1.getSQLState()) {
					case "23505": 
						JOptionPane.showMessageDialog(null, "El CPF ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
	    	}
	    }	 
	 public void insertarPersJur(String sql, String insert,String pais, String area, String num, String CNPJ) throws SQLException {
	        Statement st = connection.createStatement();
	        try {
	        st.executeUpdate(sql+insert);
		    	String busqueda = new String("SELECT p.idempresa from VAH_personas_juridicas p where p.cpnj="+CNPJ+";");
		    	ResultSet valor = st.executeQuery(busqueda);
		    	int xa = 0;  
		    	while(valor.next()) {
			    	  xa = valor.getInt("idempresa"); 
			      }
			      valor.close();
			      ManejoDeString validar = new ManejoDeString();
				  boolean pais1 = validar.esVacio(pais);
				  boolean area1 = validar.esVacio(area);
				  boolean num1  = validar.esVacio(num);
		
		/*	    	System.out.println(busqueda);
					System.out.println(xa);
					System.out.println(pais);
					System.out.println(area);
					System.out.println(num);
					System.out.println(pais1);
					System.out.println(area1);
					System.out.println(num1);
		*/			
					if ((pais1)&&(area1)&&(num1))
					{
						JOptionPane.showMessageDialog(null, "La persona juridica ha sido ingresada exitosamente", "Persona juridica ingresada", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						pais1 = validar.validarPais(pais);
						area1 = validar.validarArea(area);
						num1  = validar.validarnumero(num);
						if ((pais1)&&(area1)&&(num1))
						{
							try
							{
							String sql1 = new String("INSERT INTO VAH_telefonos(codInt, codArea, numero, idpjuridica)"
									+ "	VALUES ("+pais+","+area+","+num+","+xa+");");
					    	st.executeUpdate(sql1);
							System.out.println(sql1);
							JOptionPane.showMessageDialog(null, "La persona juridica ha sido ingresada exitosamente", "Persona juridica ingresada", JOptionPane.WARNING_MESSAGE);
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
								System.out.println(e1.getSQLState() + "--" + e1.getMessage());
								switch (e1.getSQLState()) {
									case "23505": 
										JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
									break;
								}
								//En caso que haya un error al al agregar el telefono de la persona se borra la persona y se devuelve el error
							String sql1=("delete from VAH_Personas_juridicas c\r\n"+"where c.cpnj="+CNPJ+"");
					    	st.executeUpdate(sql1);
							System.out.println(sql1);
					    	}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El numero internacional, area y numero deben cumplir con el formato", "Error", JOptionPane.ERROR_MESSAGE);
							String sql1=("delete from VAH_Personas_juridicas c\r\n"+"where c.cpnj="+CNPJ+"");
					    	st.executeUpdate(sql1);
							System.out.println(sql1);
						}
					}
	    	connection.close();
	    	}
	    	catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				System.out.println(e1.getSQLState() + "--" + e1.getMessage());
				switch (e1.getSQLState()) {
					case "23505": 
						JOptionPane.showMessageDialog(null, "El CPNJ ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
	    	}
	    }
	 
	
	public Connection connect() 
	{
		connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			
			if (connection != null) {
				System.out.println("Conexion establecida exitosamente");
			} else 
			{
				System.out.println("No pudo establecerse la conexion");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return connection;
	}
	
	public void UpdateQuery(String query) throws SQLException 
	{
		connection = connect();
		if (connection != null) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			connection.close();
		}
	}
	
	public int UpdateQueryReturnCurrentValue(String query, String secuencia) throws SQLException
	{
		connection = connect();
		if (connection != null) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			int currentValue = getCurrentSequence(secuencia);
			connection.close();
			return currentValue;
		}else 
		{
			return -1;
		}
	}
	
	public ResultSet SelectQuery(String query) throws SQLException 
	{
		connection = connect();
		if (connection != null) {
			return connection.createStatement().executeQuery(query);
		} else 
		{
			return null;
		}
		
	}
	
	public ResultSet SelectQueryNoConnection(String query) throws SQLException 
	{
		if (connection != null) {
			return connection.createStatement().executeQuery(query);
		} else 
		{
			return null;
		}
	}
	
    public void insertarEstado(String nombre, String region) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_Estados(nombre,region) VALUES ('"+nombre+"','"+region+"');");
    	connection.close();
    }
    public void insertar_Esc_Col(int esc, int colA, int colB, int colC) throws SQLException {
        Statement st = connection.createStatement();
        
        if (colA!=0) {
        	st.executeUpdate("INSERT INTO VAH_ESC_COL(idescuela,idcolor) VALUES ("+esc+","+colA+");");
        } if (colB!=0 && colB!=colA) {
        	st.executeUpdate("INSERT INTO VAH_ESC_COL(idescuela,idcolor) VALUES ("+esc+","+colB+");");
        } if (colC!=0 && colC!=colA && colC!=colB) {
        	st.executeUpdate("INSERT INTO VAH_ESC_COL(idescuela,idcolor) VALUES ("+esc+","+colC+");");
        }
        
    	connection.close();
    }
    public void insertarPremio_Estado(String x) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_Premios_Especiales(nombre,tipo,descripcion,idestado) VALUES " + x);
    	connection.close();
    }
    
    public void insertarPremio_Ciudad(String x) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_Premios_Especiales(nombre,tipo,descripcion,idciudad,idestadociudad) VALUES " + x);
    	connection.close();
    }
    
    public void insertarTitulos(String x) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_HIST_TITULOS " + x);
    	connection.close();
    }
    
    public void insertarGanadores(String x) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_GANADORES " + x);
    	connection.close();
    }
    
    public void insertarColor(String nombre) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_Colores(nombre) VALUES ('"+nombre+"');");
    	connection.close();
    }
    public void insertarCiudad(String nombre, int estado) throws SQLException {
        Statement st = connection.createStatement();
    	st.executeUpdate("INSERT INTO VAH_Ciudades(nombre,idestado) VALUES ('"+nombre+"','"+estado+"');");
    	connection.close();
    }
    public void insertarHist_Evento(String x) throws SQLException {
        Statement st = connection.createStatement();
        String val = " (idescuela, nombre, costounitario, tipoevento, fechainicio,fechafin,totalasistencias,descripcion) ";
    	st.executeUpdate("INSERT INTO VAH_hist_Eventos_Anual_Sem"+val+" values " + x);
    	connection.close();
    }
    public void insertarHist_Evento_SinAsis(String x) throws SQLException {
        Statement st = connection.createStatement();
        String val = " (idescuela, nombre, costounitario, tipoevento, fechainicio,fechafin,descripcion) ";
    	st.executeUpdate("INSERT INTO VAH_hist_Eventos_Anual_Sem"+val+" values " + x);
    	connection.close();
    }
    public void insertarSamba(String x) throws SQLException {
        Statement st = connection.createStatement();
        String val = "(idescuela, titulo, aniocarnaval, letra, tipo)";
    	st.executeUpdate("INSERT INTO VAH_SAMBAS "+val+" values " + x);
    	connection.close();
    }
    public int insertarEscuela(String nombre, String fecha, String historia, String dir, int est, int ciu,String pais, String area, String num) throws SQLException {
	    ManejoDeString validar = new ManejoDeString();
	    boolean pais1 = validar.esVacio(pais);
		boolean area1 = validar.esVacio(area);
		boolean num1  = validar.esVacio(num);
		String consultar= new String("");
		SQLController app = new SQLController();

		
		if ((pais1)&&(area1)&&(num1))
		{
		JOptionPane.showMessageDialog(null, "La escuela ha sido ingresada exitosamente", "Escuela  ha sido ingresada", JOptionPane.WARNING_MESSAGE);
        Statement st = connection.createStatement();
        String i = "INSERT INTO VAH_Escuelas(nombre,fechafundacion,historia,direccionsede,idestado,idciudad) VALUES ";
        String v = "('" + nombre + "','" + fecha + "','" + historia + "','" + dir + "'," + est + "," + ciu +  ")";
        int idescuela = app.UpdateQueryReturnCurrentValue(i+v,"vah_sec_escuelas");
    	return(idescuela);
		}
		else
		{
			pais1 = validar.validarPais(pais);
			area1 = validar.validarArea(area);
			num1  = validar.validarnumero(num);
			if ((pais1)&&(area1)&&(num1))
			{
				consultar=("select  w.idescuela "
						+" from VAH_telefonos w "+
						"where w.codint="+pais+" and w.codarea="+area+" and w.numero="+num+"");
				System.out.println(consultar);
				ResultSet datos =app.SelectQuery(consultar);
				String dato = "";
				while (datos.next()) 
				{
				    dato = 	datos.getString("idescuela");
					System.out.println(dato);
				}
				if(dato=="")
				{
					try {
					JOptionPane.showMessageDialog(null, "La escuela ha sido ingresada exitosamente", "Escuela  ha sido ingresada", JOptionPane.WARNING_MESSAGE);
			        Statement st = connection.createStatement();
			        String i = "INSERT INTO VAH_Escuelas(nombre,fechafundacion,historia,direccionsede,idestado,idciudad) VALUES ";
			        String v = "('" + nombre + "','" + fecha + "','" + historia + "','" + dir + "'," + est + "," + ciu +  ")";
			        int idescuela = app.UpdateQueryReturnCurrentValue(i+v,"vah_sec_escuelas");
			    	String sql1 = new String("INSERT INTO VAH_telefonos(codInt, codArea, numero, idescuela)"
							+ "	VALUES ("+pais+","+area+","+num+","+idescuela+");");
			    	st.executeUpdate(sql1);
			    	return(idescuela);
			    	}catch (Exception e) {
						System.out.println(e.getMessage());
					}
			    	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El numero internacional, area y numero deben cumplir con el formato", "Error", JOptionPane.ERROR_MESSAGE);

			}
			return(0);
		}
    }
    public ResultSet consultar(String str) throws SQLException {
    	ResultSet r = null;
    	r = connection.createStatement().executeQuery(str); 	
    	return r;
    }

	public ResultSet SelectAll(String tabla) throws SQLException 
	{
		return SelectQuery("SELECT * FROM " + tabla);
	}
	
	public ResultSet SelectUnCampo(String tabla, String campo1) throws SQLException 
	{
		return SelectQuery("SELECT "+ campo1 + " FROM " + tabla);
	}
	
	public ResultSet SelectDosCampos(String tabla, String campo1, String campo2) throws SQLException 
	{
		return SelectQuery("SELECT "+ campo1 +", "+ campo2 + " FROM " + tabla);
	}
	
	public ResultSet SelectTresCampos(String tabla, String campo1, String campo2, String campo3) throws SQLException 
	{
		return SelectQuery("SELECT "+ campo1 +", "+ campo2 + ", "+ campo3 + " FROM " + tabla);
	}
	
	public ResultSet SelectCuatroCampos(String tabla, String campo1, String campo2, String campo3, String campo4) throws SQLException 
	{
		return SelectQuery("SELECT "+ campo1 +", "+ campo2 + ", "+ campo3 + ", "+ campo4 + " FROM " + tabla + " ORDER BY " + campo1 + " ASC;");
	}
	
	public int getCurrentSequence(String nombreSecuencia) throws SQLException 
	{
		
		ResultSet resultado = SelectQueryNoConnection("SELECT currval('" + nombreSecuencia +"');");
		resultado.next();
		return resultado.getInt("currval");
	}
	
	public void CerrarHistoricoIntegranteAbierto(int idIntegrante) throws SQLException 
	{
		ResultSet resultado = SelectQuery("SELECT idEscuela, fechaIngreso FROM vah_hist_integrantes "
										+ "WHERE (idIntegrante = " + idIntegrante + ") AND (fechaRetiro is NULL);");
		
		if (resultado.next()) 
		{
			UpdateQuery("UPDATE vah_hist_integrantes SET fechaRetiro = CURRENT_DATE "
					+ "WHERE (idEscuela = " + resultado.getInt("idEscuela") + ") AND (idIntegrante = " + idIntegrante + ") "
					+ "AND (fechaIngreso = '" + resultado.getString("fechaIngreso") + "');");
		}
	}

    public void insertarAutores(String x) throws SQLException {
        Statement st = connection.createStatement();
        String val = "(idsamba, idescuelasamba, idescuelaintegrante, idintegrante, fechaingreso)";
    	st.executeUpdate("INSERT INTO VAH_AUTORES "+val+" values " + x);
    	connection.close();
    }
}
