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

public class RegistrarPersonaJuridica extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_Nombre;
	private JTextField txtField_CNPJ;
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
					RegistrarPersonaJuridica frame = new RegistrarPersonaJuridica();
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
	public RegistrarPersonaJuridica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistrarPersonaNatural = new JLabel("Registrar Persona Juridica");
		lbl_RegistrarPersonaNatural.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_RegistrarPersonaNatural.setBounds(180, 11, 200, 17);
		contentPane.add(lbl_RegistrarPersonaNatural);
		
		txtField_Nombre = new JTextField();
		txtField_Nombre.setBounds(10, 60, 122, 20);
		contentPane.add(txtField_Nombre);
		txtField_Nombre.setColumns(10);
		
		JLabel lbl_Nombre = new JLabel("Nombre*");
		lbl_Nombre.setBounds(20, 43, 112, 14);
		contentPane.add(lbl_Nombre);
		
		JLabel lbl_TipoEmpresa = new JLabel("Tipo de empresa *");
		lbl_TipoEmpresa.setBounds(10, 91, 112, 14);
		contentPane.add(lbl_TipoEmpresa);
		
		txtField_CNPJ = new JTextField();
		txtField_CNPJ.setColumns(10);
		txtField_CNPJ.setBounds(10, 189, 122, 20);
		contentPane.add(txtField_CNPJ);
		
		JLabel lbl_CNPJ = new JLabel("CNPJ*");
		lbl_CNPJ.setBounds(10, 164, 46, 14);
		contentPane.add(lbl_CNPJ);
		
		JLabel lblContactoEmail = new JLabel("Email de contacto*");
		lblContactoEmail.setBounds(10, 220, 127, 17);
		contentPane.add(lblContactoEmail);
		
		txtField_email = new JTextField();
		txtField_email.setText("emailprueba@gmail.com");
		txtField_email.setBounds(10, 248, 168, 17);
		contentPane.add(txtField_email);
		txtField_email.setColumns(10);
		
		JLabel lblNumeroTelefono = new JLabel("Numero de Telefono (Opcional)");
		lblNumeroTelefono.setBounds(253, 43, 213, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lbl_CodInt = new JLabel("Codigo Internacional");
		lbl_CodInt.setBounds(253, 66, 155, 14);
		contentPane.add(lbl_CodInt);
		
		textField_CodInt = new JTextField();
		textField_CodInt.setText("58");
		textField_CodInt.setBounds(253, 88, 103, 20);
		contentPane.add(textField_CodInt);
		textField_CodInt.setColumns(10);
		
		JLabel lbl_CodArea = new JLabel("Codigo de Area");
		lbl_CodArea.setBounds(253, 119, 152, 14);
		contentPane.add(lbl_CodArea);
		
		textField_CodArea = new JTextField();
		textField_CodArea.setText("0412");
		textField_CodArea.setBounds(253, 136, 102, 20);
		contentPane.add(textField_CodArea);
		textField_CodArea.setColumns(10);
		
		JLabel lbl_NumTel = new JLabel("Numero de telefono");
		lbl_NumTel.setBounds(253, 167, 125, 14);
		contentPane.add(lbl_NumTel);
		
		textField_NumTel = new JTextField();
		textField_NumTel.setText("7895501");
		textField_NumTel.setBounds(253, 192, 102, 20);
		contentPane.add(textField_NumTel);
		textField_NumTel.setColumns(10);
		
		JRadioButton rdbtn_Pub = new JRadioButton("Publica");
		rdbtn_Pub.setBounds(10, 112, 109, 23);
		contentPane.add(rdbtn_Pub);
		
		JRadioButton rdbtn_Priv = new JRadioButton("Privada");
		rdbtn_Priv.setBounds(10, 134, 109, 23);
		contentPane.add(rdbtn_Priv);
		
		ButtonGroup grupoBtnGenero = new ButtonGroup();
		grupoBtnGenero.add(rdbtn_Pub);
		grupoBtnGenero.add(rdbtn_Priv);
		
		JLabel lbl_ErrorNom = new JLabel("ERROR");
		lbl_ErrorNom.setEnabled(true);
		lbl_ErrorNom.setVisible(false);
		lbl_ErrorNom.setForeground(Color.RED);
		lbl_ErrorNom.setBounds(136, 63, 46, 14);
		contentPane.add(lbl_ErrorNom);
		
		
		JLabel lblErrorTipoEmpresa = new JLabel("ERROR");
		lblErrorTipoEmpresa.setForeground(Color.RED);
		lblErrorTipoEmpresa.setVisible(false);
		lblErrorTipoEmpresa.setBounds(136, 119, 46, 14);
		contentPane.add(lblErrorTipoEmpresa);
		
		JLabel lblErrorCNPJ = new JLabel("ERROR");
		lblErrorCNPJ.setForeground(Color.RED);
		lblErrorCNPJ.setVisible(false);
		lblErrorCNPJ.setBounds(151, 192, 46, 14);
		contentPane.add(lblErrorCNPJ);
		
		JLabel lblErrorEmail = new JLabel("ERROR");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setVisible(false);
		lblErrorEmail.setBounds(194, 250, 46, 14);
		contentPane.add(lblErrorEmail);
		
		JLabel lblErrorCodInt = new JLabel("ERROR");
		lblErrorCodInt.setForeground(Color.RED);
		lblErrorCodInt.setVisible(false);
		lblErrorCodInt.setBounds(366, 91, 46, 14);
		contentPane.add(lblErrorCodInt);
		
		JLabel lblErrorCodArea = new JLabel("ERROR");
		lblErrorCodArea.setForeground(Color.RED);
		lblErrorCodArea.setVisible(false);
		lblErrorCodArea.setBounds(366, 139, 46, 14);
		contentPane.add(lblErrorCodArea);
		
		JLabel lblErrorNumtel = new JLabel("ERROR");
		lblErrorNumtel.setForeground(Color.RED);
		lblErrorNumtel.setVisible(false);
		lblErrorNumtel.setBounds(365, 192, 46, 14);
		contentPane.add(lblErrorNumtel);
		
		Button butn_Confirmar = new Button("Confirmar");
		butn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorCNPJ.setVisible(false);
				lbl_ErrorNom.setVisible(false);
				lblErrorTipoEmpresa.setVisible(false);
				lblErrorEmail.setVisible(false);
				lblErrorCodInt.setVisible(false);
				lblErrorCodArea.setVisible(false);
				lblErrorNumtel.setVisible(false);
				
				SQLController app = new SQLController();
				String cnpj = txtField_CNPJ.getText();
				String nombre = txtField_Nombre.getText();
				String email = txtField_email.getText();
				ManejoDeString validar = new ManejoDeString();
		    	String sql = new String("INSERT INTO vah_personas_juridicas(cpnj,nombre,tipoEmpresa,email)");
		    	String values = new String(" VALUES(");
				String pais= textField_CodInt.getText();
				String area= textField_CodArea.getText();
				String num= textField_NumTel.getText();	
				String empresa = new String("");
				
				if (rdbtn_Pub.isSelected()) 
				{
					empresa = "PUB";
				} else { 
				if (rdbtn_Priv.isSelected()) 
				{
					empresa = "PRIV";
				}
				}
				
				boolean cnpj1 = validar.validarnumero(cnpj);
				boolean nombre1 = validar.validarStringCampo(nombre);
				boolean TipoEm1 = validar.validarStringCampo(empresa);
				boolean email1  = validar.validarEmail(email);
				boolean pais1 = validar.validarPais(pais);
				boolean area1 = validar.validarArea(area);
				boolean num1  = validar.validarTelefono(num);
				
				if(!cnpj1) {lblErrorCNPJ.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el CNPJ no puede tener letras y tiene que ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!nombre1) {lbl_ErrorNom.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el nombre no puede tener caracteres especiales ni numeros", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!TipoEm1) {lblErrorTipoEmpresa.setVisible(true); 
				JOptionPane.showMessageDialog(null, "Error en el tipo de empresa Debe seleccionar un tipo de empresa", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!email1) {lblErrorEmail.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el email debe ser en formatod ******@****.***", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!pais1) {lblErrorCodInt.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el codigo internacional debe ser de 2 numeros Ej= 58", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!area1) {lblErrorCodArea.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el codigo area debe ser de 4 numeros Ej= 4567", "Error", JOptionPane.ERROR_MESSAGE);}
				if(!num1) {lblErrorNumtel.setVisible(true);
				JOptionPane.showMessageDialog(null, "Error en el numero debe ser de 7 numeros Ej= 1234567", "Error", JOptionPane.ERROR_MESSAGE);}
				if ((cnpj1)&&(nombre1)&&(TipoEm1)&&(email1))
				{ 
					values=values+cnpj+",'"+nombre+"','"+empresa+"','"+email+"');";
				app.connect();
				try {
					System.out.println(sql);
					System.out.println(values);
					if ((pais1)&&(area1)&&(num1))
					{
						app.insertarPersJur(sql,values,pais,area,num,cnpj);
					}
				} catch (SQLException e1) {}
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
