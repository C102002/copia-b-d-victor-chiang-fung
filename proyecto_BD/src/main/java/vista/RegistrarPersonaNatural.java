package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

public class RegistrarPersonaNatural extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_PrimerNombre;
	private JTextField txtField_SegundoNombre;
	private JTextField txtField_SegundoApellido;
	private JTextField txtField_PrimerApellido;
	private JTextField txtField_CPF;
	private JTextField txtField_email;
	private JTextField textField_CodInt;
	private JTextField textField_CodArea;
	private JTextField textField_NumTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPersonaNatural frame = new RegistrarPersonaNatural();
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
	public RegistrarPersonaNatural() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistrarPersonaNatural = new JLabel("Registrar Persona Natural");
		lbl_RegistrarPersonaNatural.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RegistrarPersonaNatural.setBounds(180, 11, 200, 17);
		contentPane.add(lbl_RegistrarPersonaNatural);
		
		txtField_PrimerNombre = new JTextField();
		txtField_PrimerNombre.setBounds(10, 60, 122, 20);
		contentPane.add(txtField_PrimerNombre);
		txtField_PrimerNombre.setColumns(10);
		
		JLabel lbl_PrimerNombre = new JLabel("Primer Nombre*");
		lbl_PrimerNombre.setBounds(20, 43, 112, 14);
		contentPane.add(lbl_PrimerNombre);
		
		txtField_SegundoNombre = new JTextField();
		txtField_SegundoNombre.setColumns(10);
		txtField_SegundoNombre.setBounds(10, 108, 122, 20);
		contentPane.add(txtField_SegundoNombre);
		
		JLabel lbl_SegundoNombre = new JLabel("Segundo Nombre");
		lbl_SegundoNombre.setBounds(20, 91, 112, 14);
		contentPane.add(lbl_SegundoNombre);
		
		txtField_SegundoApellido = new JTextField();
		txtField_SegundoApellido.setColumns(10);
		txtField_SegundoApellido.setBounds(10, 204, 122, 20);
		contentPane.add(txtField_SegundoApellido);
		
		JLabel lbl_SegundoApellido = new JLabel("Segundo Apellido*");
		lbl_SegundoApellido.setBounds(20, 187, 112, 14);
		contentPane.add(lbl_SegundoApellido);
		
		txtField_PrimerApellido = new JTextField();
		txtField_PrimerApellido.setColumns(10);
		txtField_PrimerApellido.setBounds(10, 156, 122, 20);
		contentPane.add(txtField_PrimerApellido);
		
		JLabel lbl_PrimerApellido = new JLabel("Primer Apellido*");
		lbl_PrimerApellido.setBounds(20, 139, 112, 14);
		contentPane.add(lbl_PrimerApellido);
		
		txtField_CPF = new JTextField();
		txtField_CPF.setColumns(10);
		txtField_CPF.setBounds(10, 252, 122, 20);
		contentPane.add(txtField_CPF);
		
		JLabel lbl_CPF = new JLabel("CPF*");
		lbl_CPF.setBounds(20, 235, 28, 14);
		contentPane.add(lbl_CPF);
		
		JLabel lblContactoEmail = new JLabel("Email de contacto*");
		lblContactoEmail.setBounds(253, 39, 127, 17);
		contentPane.add(lblContactoEmail);
		
		txtField_email = new JTextField();
		txtField_email.setText("emailprueba@gmail.com");
		txtField_email.setBounds(253, 61, 200, 17);
		contentPane.add(txtField_email);
		txtField_email.setColumns(10);
		
		JLabel lblNumeroTelefono = new JLabel("Numero de Telefono (Opcional)");
		lblNumeroTelefono.setBounds(253, 91, 200, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lbl_CodInt = new JLabel("Codigo Internacional");
		lbl_CodInt.setBounds(253, 111, 155, 14);
		contentPane.add(lbl_CodInt);
		
		textField_CodInt = new JTextField();
		textField_CodInt.setText("58");
		textField_CodInt.setBounds(253, 136, 103, 20);
		contentPane.add(textField_CodInt);
		textField_CodInt.setColumns(10);
		
		JLabel lbl_CodArea = new JLabel("Codigo de Area");
		lbl_CodArea.setBounds(256, 159, 152, 14);
		contentPane.add(lbl_CodArea);
		
		textField_CodArea = new JTextField();
		textField_CodArea.setText("0412");
		textField_CodArea.setBounds(254, 184, 102, 20);
		contentPane.add(textField_CodArea);
		textField_CodArea.setColumns(10);
		
		JLabel lbl_NumTel = new JLabel("Numero de telefono");
		lbl_NumTel.setBounds(255, 207, 125, 14);
		contentPane.add(lbl_NumTel);
		
		textField_NumTel = new JTextField();
		textField_NumTel.setText("7895501");
		textField_NumTel.setBounds(254, 232, 102, 20);
		contentPane.add(textField_NumTel);
		textField_NumTel.setColumns(10);
		
		JLabel lbl_ErrorPrimNom = new JLabel("ERROR");
		lbl_ErrorPrimNom.setEnabled(true);
		lbl_ErrorPrimNom.setVisible(false);
		lbl_ErrorPrimNom.setForeground(Color.RED);
		lbl_ErrorPrimNom.setBounds(136, 63, 46, 14);
		contentPane.add(lbl_ErrorPrimNom);
		
		
		JLabel lblErrorSegnom = new JLabel("ERROR");
		lblErrorSegnom.setForeground(Color.RED);
		lblErrorSegnom.setVisible(false);
		lblErrorSegnom.setBounds(136, 111, 46, 14);
		contentPane.add(lblErrorSegnom);
		
		JLabel lblErrorPrimAp = new JLabel("ERROR");
		lblErrorPrimAp.setForeground(Color.RED);
		lblErrorPrimAp.setVisible(false);
		lblErrorPrimAp.setBounds(136, 159, 46, 14);
		contentPane.add(lblErrorPrimAp);
		
		JLabel lblErrorSegAp = new JLabel("ERROR");
		lblErrorSegAp.setForeground(Color.RED);
		lblErrorSegAp.setVisible(false);
		lblErrorSegAp.setBounds(136, 207, 46, 14);
		contentPane.add(lblErrorSegAp);
		
		JLabel lblErrorCPF = new JLabel("ERROR");
		lblErrorCPF.setForeground(Color.RED);
		lblErrorCPF.setVisible(false);
		lblErrorCPF.setBounds(136, 255, 46, 14);
		contentPane.add(lblErrorCPF);
		
		JLabel lblErrorEmail = new JLabel("ERROR");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setVisible(false);
		lblErrorEmail.setBounds(458, 63, 46, 14);
		contentPane.add(lblErrorEmail);
		
		JLabel lblErrorCodInt = new JLabel("ERROR");
		lblErrorCodInt.setForeground(Color.RED);
		lblErrorCodInt.setVisible(false);
		lblErrorCodInt.setBounds(366, 139, 46, 14);
		contentPane.add(lblErrorCodInt);
		
		JLabel lblErrorCodArea = new JLabel("ERROR");
		lblErrorCodArea.setForeground(Color.RED);
		lblErrorCodArea.setVisible(false);
		lblErrorCodArea.setBounds(362, 187, 46, 14);
		contentPane.add(lblErrorCodArea);
		
		JLabel lblErrorNumtel = new JLabel("ERROR");
		lblErrorNumtel.setForeground(Color.RED);
		lblErrorNumtel.setVisible(false);
		lblErrorNumtel.setBounds(359, 235, 46, 14);
		contentPane.add(lblErrorNumtel);
		
		Button butn_Confirmar = new Button("Confirmar");
		butn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorCPF.setVisible(false);
				lbl_ErrorPrimNom.setVisible(false);
				lblErrorSegnom.setVisible(false);
				lblErrorPrimAp.setVisible(false);
				lblErrorSegAp.setVisible(false);
				lblErrorEmail.setVisible(false);
				lblErrorCodInt.setVisible(false);
				lblErrorCodArea.setVisible(false);
				lblErrorNumtel.setVisible(false);
				
				SQLController app = new SQLController();
				String a = txtField_CPF.getText();
				String b = txtField_PrimerNombre.getText();
				String c = txtField_SegundoNombre.getText();
				String d = txtField_PrimerApellido.getText();
				String f = txtField_SegundoApellido.getText();
				String g = txtField_email.getText();
				ManejoDeString validar = new ManejoDeString();
		    	String sql = new String("INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email");
		    	String values = new String(" VALUES(");
		    	boolean c1  = validar.validarSegundoNombre(c);		    	
		    	
				if(c1) {
					if (validar.esVacio(c)==false)
					{String add = new String(",segNom)");   
					sql=sql+add; 
					values=values+a+",'"+b+"','"+d+"','"+f+"','"+g+"','"+c+"');";}
					else
					{String add = new String(")");    
					sql=sql+add; 
					values=values+a+",'"+b+"','"+d+"','"+f+"','"+g+"');";}
					}
				String pais= textField_CodInt.getText();
				String area= textField_CodArea.getText();
				String num= textField_NumTel.getText();	
				boolean a1 = validar.validarnumero(a);
				boolean b1 = validar.validarStringCampo(b);
				boolean d1 = validar.validarStringCampo(d);
				boolean f1 = validar.validarStringCampo(f);
				boolean g1  = validar.validarEmail(g);
				boolean pais1 = validar.validarPais(pais);
				boolean area1 = validar.validarArea(area);
				boolean num1  = validar.validarTelefono(num);
				
				if(!a1) {lblErrorCPF.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el CPF no puede tener letras y tiene que ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!b1) {lbl_ErrorPrimNom.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el primer nombre no puede tener caracteres especiales ni numeros", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!c1) {lblErrorSegnom.setVisible(true); 
				JOptionPane.showMessageDialog(null, "Error en el segundo nombre no puede tener caracteres especiales ni numeros", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!d1) {lblErrorPrimAp.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el primer apellido no puede tener caracteres especiales ni numeros", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!f1) {lblErrorSegAp.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el segundo apellido no puede tener caracteres especiales ni numeros", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!g1) {lblErrorEmail.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el email debe ser en formatod ******@****.***", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!pais1) {lblErrorCodInt.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el codigo internacional debe ser de 2 numeros Ej= 58", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!area1) {lblErrorCodArea.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el codigo area debe ser de 4 numeros Ej= 4567", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!num1) {lblErrorNumtel.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el numero debe ser de 7 numeros Ej= 1234567", "Error", JOptionPane.ERROR_MESSAGE);}
				if ((a1)&&(b1)&&(d1)&&(f1)&&(g1)&&(c1))
				{
				app.connect();
				try {
					//System.out.println(sql);
					//System.out.println(values);
					if ((pais1)&&(area1)&&(num1))
					{
					app.insertarPersNat(sql,values,pais,area,num,a);
					}
				} catch (SQLException e1) {
				}
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

	}
}
