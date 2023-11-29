package controlador;

import javax.swing.JOptionPane;

public class ManejoDeString {
	private String caracteresProhibidos = "|°¬!#$%&/()=?¡´¨+~*{^[]}`-_.,;:<>0123456789";
	private String numerosPermitidos = "0123456789";
	
	
	public boolean esVacio(String cadena) 
	{
		if (cadena == null || (cadena.length() == 0)) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	public boolean ValidarString(String cadena) 
	{
		for (int i = 0; i < cadena.length(); i++) 
		{
			for(int j = 0; j < caracteresProhibidos.length(); j++) 
			{
				if (cadena.charAt(i) == caracteresProhibidos.charAt(j)) 
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean ValidarInt(String cadena) 
	{
		boolean digitoValido;
		for (int i = 0; i < cadena.length(); i++) 
		{
			digitoValido = false;
			for(int j = 0; j < numerosPermitidos.length(); j++) 
			{
				if (cadena.charAt(i) == numerosPermitidos.charAt(j)) 
				{
					digitoValido = true;
				}
			}
			
			if (!digitoValido) 
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean validarSegundoNombre(String nombre)
	{
		ManejoDeString a= new ManejoDeString();
		if (nombre.length()<1) { return true;}
		else
		{
			return (a.ValidarString(nombre)&&(nombre.length()>=1));
		}
	}
	
	public boolean validarPais(String pais) {
    	if (pais.length()<1) return true;
		else
		{return (pais.matches("[0-9]+")&&(pais.length()==2));
		}}
    public boolean validarArea(String area) {
    	if (area.length()<1) return true;
		else
		{return (area.matches("[0-9]+")&&(area.length()==4));
		}}
	
	public boolean validarTelefono(String telefono) {
		if (telefono.length()<1) return true;
		else {
        return (telefono.matches("[0-9]+")&&(telefono.length()==7));}
    }
	public boolean validarnumero(String num ) {
		return  ((num.length()>=1)&& num.matches("[0-9]+"));
	}
	public boolean validarEmail(String g) {
		return ((g.length()>=1)&& g.matches("[-\\w\\.]+@\\w+\\.\\w+"));
	}
	public boolean validarStringCampo(String b) {
		ManejoDeString a= new ManejoDeString();
		
		return ((b.length()>=1) && a.ValidarString(b));
	}
	public Integer validarfechasa(String diaini,String mesini, String anoini, String diafin, String mesfin, String anofin )
	{ Integer fine=1;
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
	return(fine); //Si esta bien fine=1 del resto 0
	}
}
