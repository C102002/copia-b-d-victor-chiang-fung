package vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejoDeString;
import controlador.SQLController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ModificarIntegrante extends JFrame {
	private SQLController sqlController = new SQLController();
	private boolean booting = true;
	private ArrayList<Integer> arrayIdsHabilidades = new ArrayList<>();
	private ArrayList<Integer> arrayIdsHabilidadesAConectar = new ArrayList<>();
	private ArrayList<Integer> arrayIdsParientes = new ArrayList<>();
	private ArrayList<Integer> arrayIdsParientesAConectar = new ArrayList<>();
	private ArrayList<String> arrayListNombresParientesAConectar = new ArrayList<>();
	private DefaultListModel<String> listModel_Habilidades = new DefaultListModel<>();
	private DefaultListModel<String> listModel_Parientes = new DefaultListModel<>();
	private JFrame thisInstance = this;
	
	private JPanel contentPane;
	private JTextField txtField_PrimerNombre;
	private JTextField txtField_SegundoNombre;
	private JTextField txtField_SegundoApellido;
	private JTextField txtField_PrimerApellido;
	private JTextField txtField_Apodo;
	private JTextField txtField_CPF;
	private JTextField txtField_Nacionalidad;
	private JTextField txtField_AnioNacimiento;
	
	
	public ArrayList<Integer> getArrayIdsHabilidades() {
		return arrayIdsHabilidades;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarIntegrante frame = new ModificarIntegrante(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private boolean esMenorDeEdad(LocalDate fechaRevisar) 
	{
		if(LocalDate.now().minusYears(18).isBefore(fechaRevisar)) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	private void llenarHabilidades(JComboBox<String> comboBox, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectDosCampos("vah_habilidades", "nombre", "idHabilidad"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("nombre"));
				arrayIds.add(datos.getInt("idHabilidad"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void llenarParientes(JComboBox<String> comboBox, ArrayList<Integer> arrayIds) 
	{
		try {
			ResultSet datos = sqlController.SelectCuatroCampos("vah_integrantes", "primnom", "primap", "segap", "idintegrante"); 
			while (datos.next()) 
			{
				comboBox.addItem(datos.getString("primnom") + " " + datos.getString("primap") + " " + datos.getString("segap"));
				arrayIds.add(datos.getInt("idintegrante"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ModificarIntegrante(int idIntegrante) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 400);
		contentPane = new JPanel();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ResultSet integrante = null;
		try {
			integrante = sqlController.SelectQuery("SELECT * FROM vah_integrantes WHERE (idIntegrante = " + idIntegrante + ");");
			integrante.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lbl_ModificarIntegrante = new JLabel("Modificar Integrante");
		lbl_ModificarIntegrante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ModificarIntegrante.setBounds(201, 11, 122, 17);
		contentPane.add(lbl_ModificarIntegrante);
		
		txtField_PrimerNombre = new JTextField();
		txtField_PrimerNombre.setBounds(10, 60, 122, 20);
		contentPane.add(txtField_PrimerNombre);
		txtField_PrimerNombre.setColumns(10);
		try {
			txtField_PrimerNombre.setText(integrante.getString("primnom"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_PrimerNombre = new JLabel("Primer Nombre*");
		lbl_PrimerNombre.setBounds(20, 43, 112, 14);
		contentPane.add(lbl_PrimerNombre);
		
		txtField_SegundoNombre = new JTextField();
		txtField_SegundoNombre.setColumns(10);
		txtField_SegundoNombre.setBounds(10, 108, 122, 20);
		contentPane.add(txtField_SegundoNombre);
		try {
			txtField_SegundoNombre.setText(integrante.getString("segnom"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_SegundoNombre = new JLabel("Segundo Nombre");
		lbl_SegundoNombre.setBounds(20, 91, 112, 14);
		contentPane.add(lbl_SegundoNombre);
		
		txtField_SegundoApellido = new JTextField();
		txtField_SegundoApellido.setColumns(10);
		txtField_SegundoApellido.setBounds(10, 204, 122, 20);
		contentPane.add(txtField_SegundoApellido);
		try {
			txtField_SegundoApellido.setText(integrante.getString("segap"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_SegundoApellido = new JLabel("Segundo Apellido*");
		lbl_SegundoApellido.setBounds(20, 187, 112, 14);
		contentPane.add(lbl_SegundoApellido);
		
		txtField_PrimerApellido = new JTextField();
		txtField_PrimerApellido.setColumns(10);
		txtField_PrimerApellido.setBounds(10, 156, 122, 20);
		contentPane.add(txtField_PrimerApellido);
		try {
			txtField_PrimerApellido.setText(integrante.getString("primap"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_PrimerApellido = new JLabel("Primer Apellido*");
		lbl_PrimerApellido.setBounds(20, 139, 112, 14);
		contentPane.add(lbl_PrimerApellido);
		
		txtField_Apodo = new JTextField();
		txtField_Apodo.setColumns(10);
		txtField_Apodo.setBounds(10, 252, 122, 20);
		contentPane.add(txtField_Apodo);
		try {
			txtField_Apodo.setText(integrante.getString("apodo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_Apodo = new JLabel("Apodo");
		lbl_Apodo.setBounds(20, 235, 53, 14);
		contentPane.add(lbl_Apodo);
		
		txtField_CPF = new JTextField();
		txtField_CPF.setColumns(10);
		txtField_CPF.setBounds(190, 252, 128, 20);
		contentPane.add(txtField_CPF);
		try {
			txtField_CPF.setText(Integer.toString(integrante.getInt("cpf")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		JLabel lbl_CPF = new JLabel("CPF");
		lbl_CPF.setBounds(240, 231, 28, 14);
		contentPane.add(lbl_CPF);
		
		JLabel lbl_Genero = new JLabel("Género*");
		lbl_Genero.setBounds(241, 43, 48, 14);
		contentPane.add(lbl_Genero);
		
		JRadioButton rdbtn_Masculino = new JRadioButton("Masculino");
		rdbtn_Masculino.setBounds(168, 59, 87, 23);
		contentPane.add(rdbtn_Masculino);
		
		JRadioButton rdbtn_Femenino = new JRadioButton("Femenino");
		rdbtn_Femenino.setBounds(266, 59, 87, 23);
		contentPane.add(rdbtn_Femenino);
		
		ButtonGroup grupoBtnGenero = new ButtonGroup();
		grupoBtnGenero.add(rdbtn_Masculino);
		grupoBtnGenero.add(rdbtn_Femenino);
		
		try {
			if (integrante.getString("genero").equals("M")) 
			{
				rdbtn_Masculino.doClick();
			} else 
			{
				rdbtn_Femenino.doClick();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		JLabel lbl_Nacionalidad = new JLabel("Nacionalidad*");
		lbl_Nacionalidad.setBounds(229, 91, 89, 14);
		contentPane.add(lbl_Nacionalidad);
		
		JRadioButton rdbtn_Brasilenio = new JRadioButton("Brasileño");
		rdbtn_Brasilenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField_Nacionalidad.setEnabled(false);
			}
		});
		rdbtn_Brasilenio.setBounds(182, 105, 87, 23);
		contentPane.add(rdbtn_Brasilenio);
		
		JRadioButton rdbtn_Otro = new JRadioButton("Otro");
		rdbtn_Otro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtField_Nacionalidad.setEnabled(true);
			}
		});
		rdbtn_Otro.setBounds(282, 105, 71, 23);
		contentPane.add(rdbtn_Otro);
		
		ButtonGroup grupobtnNacionalidad = new ButtonGroup();
		grupobtnNacionalidad.add(rdbtn_Brasilenio);
		grupobtnNacionalidad.add(rdbtn_Otro);
		
		
		txtField_Nacionalidad = new JTextField();
		txtField_Nacionalidad.setEnabled(false);
		txtField_Nacionalidad.setColumns(10);
		txtField_Nacionalidad.setBounds(198, 136, 128, 20);
		contentPane.add(txtField_Nacionalidad);
		
		try {
			if (integrante.getString("nacionalidad").equals("Brasileño")) 
			{
				rdbtn_Brasilenio.doClick();
			} else 
			{
				rdbtn_Otro.doClick();
				txtField_Nacionalidad.setText(integrante.getString("nacionalidad"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		JLabel lbl_Habilidades = new JLabel("Habilidades");
		lbl_Habilidades.setBounds(513, 43, 87, 14);
		contentPane.add(lbl_Habilidades);
		
		JButton btnNuevaHabilidad = new JButton(" Agregar");
		btnNuevaHabilidad.setBounds(548, 178, 101, 23);
		contentPane.add(btnNuevaHabilidad);
		
		JLabel lbl_FechaNacimiento = new JLabel("Fecha Nacimiento*");
		lbl_FechaNacimiento.setBounds(201, 167, 122, 14);
		contentPane.add(lbl_FechaNacimiento);
		LocalDate fechaIntegrante = null;
		try {
			fechaIntegrante = integrante.getDate("fechanacimiento").toLocalDate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
		
		JComboBox<String> cmbBox_DiaNacimiento = new JComboBox<String>();
		cmbBox_DiaNacimiento.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cmbBox_DiaNacimiento.setBounds(188, 183, 48, 22);
		contentPane.add(cmbBox_DiaNacimiento);
		cmbBox_DiaNacimiento.setSelectedIndex(fechaIntegrante.getDayOfMonth() - 1);
		
		JComboBox<String> cmbBox_MesNacimiento = new JComboBox<String>();
		cmbBox_MesNacimiento.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cmbBox_MesNacimiento.setBounds(240, 183, 48, 22);
		contentPane.add(cmbBox_MesNacimiento);
		cmbBox_MesNacimiento.setSelectedIndex(fechaIntegrante.getMonthValue() - 1);
		
		txtField_AnioNacimiento = new JTextField();
		txtField_AnioNacimiento.setBounds(292, 184, 86, 20);
		contentPane.add(txtField_AnioNacimiento);
		txtField_AnioNacimiento.setColumns(10);
		txtField_AnioNacimiento.setText(Integer.toString(fechaIntegrante.getYear()));
		
		JButton btnModificarIntegrante = new JButton("Modificar Integrante");
		btnModificarIntegrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Registrar datos en la tabla integrantes
				ManejoDeString manejoDeString = new ManejoDeString();
				String primerNombre = txtField_PrimerNombre.getText();
				String segundoNombre = txtField_SegundoNombre.getText();
				String primerApellido = txtField_PrimerApellido.getText();
				String segundoApellido = txtField_SegundoApellido.getText();
				String apodo = txtField_Apodo.getText();
				String genero = "NULL";
				String nacionalidad = "NULL";
				String fechaNacimiento = "NULL";
				String cpf = txtField_CPF.getText();
				
				boolean stringValido = manejoDeString.ValidarString(primerNombre);
				//Chequeos de texto y numéricos
				if (!stringValido || manejoDeString.esVacio(primerNombre))
				{
					primerNombre = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Primer Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else 
				{
					primerNombre = "'" + primerNombre + "'";
				}
				stringValido = manejoDeString.ValidarString(segundoNombre);
				if (!stringValido || manejoDeString.esVacio(segundoNombre)) 
				{
					segundoNombre = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Segundo Nombre", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else 
				{
					segundoNombre = "'" + segundoNombre + "'";
				}
				stringValido = manejoDeString.ValidarString(primerApellido);
				if (!stringValido || manejoDeString.esVacio(primerApellido)) 
				{
					primerApellido = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Primer Apellido", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else 
				{
					primerApellido = "'" + primerApellido + "'";
				}
				stringValido = manejoDeString.ValidarString(segundoApellido);
				if (!stringValido || manejoDeString.esVacio(segundoApellido)) 
				{
					segundoApellido = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Segundo Apellido", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else 
				{
					segundoApellido = "'" + segundoApellido + "'";
				}
				stringValido = manejoDeString.ValidarString(apodo);
				if (!stringValido || manejoDeString.esVacio(apodo)) 
				{
					apodo = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Apodo", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				} else 
				{
					apodo = "'" + apodo + "'";
				}
				
				if (rdbtn_Masculino.isSelected()) 
				{
					genero = "'M'";
				} else if (rdbtn_Femenino.isSelected()) 
				{
					genero = "'F'";
				}
				
				if (rdbtn_Brasilenio.isSelected()) 
				{
					nacionalidad = "'Brasileño'";
				} else if (rdbtn_Otro.isSelected()) 
				{
					if (manejoDeString.ValidarString(txtField_Nacionalidad.getText()) && !manejoDeString.esVacio(txtField_Nacionalidad.getText())) 
					{
						nacionalidad = "'" + txtField_Nacionalidad.getText() + "'";
					} else if (!manejoDeString.ValidarString(txtField_Nacionalidad.getText()))
					{
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Nacionalidad", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				stringValido = manejoDeString.ValidarInt(txtField_AnioNacimiento.getText());
				if (stringValido && !manejoDeString.esVacio(txtField_AnioNacimiento.getText())) {
					fechaNacimiento = "'" + cmbBox_DiaNacimiento.getSelectedItem().toString() + "-" + cmbBox_MesNacimiento.getSelectedItem().toString() + "-" + txtField_AnioNacimiento.getText() + "'";
				} else if (!stringValido) {
					JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo Año de Nacimiento", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				stringValido = manejoDeString.ValidarInt(cpf);
				if (!stringValido || manejoDeString.esVacio(cpf)) 
				{
					cpf = "NULL";
					if (!stringValido) {
						JOptionPane.showMessageDialog(thisInstance, "Caracteres Inválidos en el campo CPF", "Error", JOptionPane.ERROR_MESSAGE);
					}	
				}
				
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				formato.withLocale(Locale.getDefault());
				LocalDate fechaRevisar = LocalDate.parse(fechaNacimiento.subSequence(1, fechaNacimiento.length() - 1), formato); 
				
				if ((!esMenorDeEdad(fechaRevisar) || (esMenorDeEdad(fechaRevisar) && !arrayIdsParientesAConectar.isEmpty())))
				{
					boolean errorSQL = false;
					try {
						
						sqlController.UpdateQuery("UPDATE vah_integrantes SET fechanacimiento = " + fechaNacimiento + ", primnom =" + primerNombre 
								+ ", primap = " + primerApellido + ", segap = " + segundoApellido + ", genero = " + genero + ", nacionalidad = " 
								+ nacionalidad + ", apodo = " + apodo + ", segnom = " + segundoNombre
										+ " WHERE (idintegrante = " + idIntegrante + ");");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						errorSQL = true;
						System.out.println(e1.getSQLState() + "--" + e1.getMessage());
						switch (e1.getSQLState()) {
							case "23502": 
								JOptionPane.showMessageDialog(thisInstance, "Los campos que contengan asterisco deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
							break;
							
							case "22008":
								JOptionPane.showMessageDialog(thisInstance, "La fecha introducida no es válida", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					if (!errorSQL) 
					{
						try {
							
							if (idIntegrante != -1) 
							{
								for (Integer idHabilidad : arrayIdsHabilidadesAConectar) 
								{
									sqlController.UpdateQuery("INSERT INTO vah_int_hab VALUES (" + idIntegrante + "," + idHabilidad + ");");
								}
								int indice = 0;
								for (Integer idPariente: arrayIdsParientesAConectar) 
								{
									DialogLlenarDatosParentesco dialogDatosPariente = new DialogLlenarDatosParentesco(thisInstance, idIntegrante, idPariente, arrayListNombresParientesAConectar.get(indice));
									indice++;
									dialogDatosPariente.setVisible(true);
								}
								
								JOptionPane.showMessageDialog(thisInstance, "Se registró al integrante exitosamente", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
							}
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
//							e1.printStackTrace();
						}
					}
				} else if (esMenorDeEdad(fechaRevisar))
				{
					JOptionPane.showMessageDialog(thisInstance, "No puede registrar a un menor de edad sin ningún pariente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnModificarIntegrante.setBounds(195, 316, 158, 34);
		contentPane.add(btnModificarIntegrante);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuintegrantes sigVentana = new menuintegrantes();
				sigVentana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(10, 322, 89, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrlPane_Habilidades = new JScrollPane();
		scrlPane_Habilidades.setBounds(416, 91, 233, 70);
		contentPane.add(scrlPane_Habilidades);
		
		JList<String> jlist_Habilidades = new JList<>();
		scrlPane_Habilidades.setViewportView(jlist_Habilidades);
		try {
			ResultSet habilidades = sqlController.SelectQuery("SELECT hab.nombre, hab.idHabilidad "
																+ "FROM vah_habilidades hab, vah_int_hab inters "
																+ 	"WHERE (inters.idIntegrante = " + idIntegrante + ") AND (inters.idHabilidad = hab.idHabilidad);");
			while(habilidades.next()) 
			{
				listModel_Habilidades.addElement(habilidades.getString("nombre"));
				arrayIdsHabilidadesAConectar.add(habilidades.getInt("idHabilidad"));
			}
			jlist_Habilidades.setModel(listModel_Habilidades);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
		
		JButton btnEliminarHabilidad = new JButton("Eliminar");
		btnEliminarHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!jlist_Habilidades.isSelectionEmpty()) 
				{
					arrayIdsHabilidadesAConectar.remove(jlist_Habilidades.getSelectedIndex());
					listModel_Habilidades.remove(jlist_Habilidades.getSelectedIndex());
					jlist_Habilidades.setModel(listModel_Habilidades);
				}
			}
		});
		btnEliminarHabilidad.setBounds(416, 178, 122, 23);
		contentPane.add(btnEliminarHabilidad);
		
		JComboBox<String> cmbBox_Habilidades = new JComboBox<>();
		cmbBox_Habilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!booting) 
				{
					if (!arrayIdsHabilidadesAConectar.contains(arrayIdsHabilidades.get(cmbBox_Habilidades.getSelectedIndex()))) 
					{
						arrayIdsHabilidadesAConectar.add(arrayIdsHabilidades.get(cmbBox_Habilidades.getSelectedIndex()));
						listModel_Habilidades.addElement(cmbBox_Habilidades.getItemAt(cmbBox_Habilidades.getSelectedIndex()));
						jlist_Habilidades.setModel(listModel_Habilidades);
					}
				}
				
			}
		});
		cmbBox_Habilidades.setBounds(416, 59, 233, 22);
		contentPane.add(cmbBox_Habilidades);
		
		llenarHabilidades(cmbBox_Habilidades, arrayIdsHabilidades);
		
		btnNuevaHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabilidad ventanaAgregarHabilidad = new AgregarHabilidad(thisInstance);
				ventanaAgregarHabilidad.setVisible(true);
				
				llenarHabilidades(cmbBox_Habilidades, arrayIdsHabilidades);
				arrayIdsHabilidadesAConectar.clear();
				listModel_Habilidades.clear();
				jlist_Habilidades.setModel(listModel_Habilidades);
			}
		});
		JLabel lbl_Parientes = new JLabel("Parientes");
		lbl_Parientes.setBounds(513, 213, 87, 14);
		contentPane.add(lbl_Parientes);
		
		JScrollPane scrlPane_Parientes = new JScrollPane();
		scrlPane_Parientes.setBounds(416, 261, 233, 50);
		contentPane.add(scrlPane_Parientes);
		
		JList<String> jlist_Parientes = new JList<String>();
		scrlPane_Parientes.setViewportView(jlist_Parientes);
		
		try {
			ResultSet parientes = sqlController.SelectQuery("SELECT inte.idIntegrante, inte.primnom, inte.primap, inte.segap "
																+ "FROM vah_integrantes inte, vah_parentescos paren "
																+ 	"WHERE (paren.idIntegrante = " + idIntegrante + ") AND (paren.idPariente = inte.idIntegrante);");
			while(parientes.next()) 
			{
				listModel_Parientes.addElement(parientes.getString("primnom") + " " + parientes.getString("primap") + " " + parientes.getString("segap"));
				arrayIdsParientesAConectar.add(parientes.getInt("idintegrante"));
			}
			jlist_Parientes.setModel(listModel_Parientes);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
		
		JButton btnEliminarPariente = new JButton("Eliminar");
		btnEliminarPariente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayIdsParientesAConectar.remove(jlist_Parientes.getSelectedIndex());
				arrayListNombresParientesAConectar.remove(jlist_Parientes.getSelectedIndex());
				listModel_Parientes.remove(jlist_Parientes.getSelectedIndex());
				jlist_Parientes.setModel(listModel_Parientes);
			}
		});
		btnEliminarPariente.setBounds(470, 322, 122, 23);
		contentPane.add(btnEliminarPariente);
		
		JComboBox<String> cmbBox_Parientes = new JComboBox<>();
		cmbBox_Parientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!booting) 
				{
					if (!arrayIdsParientesAConectar.contains(arrayIdsParientes.get(cmbBox_Parientes.getSelectedIndex()))) 
					{
						arrayIdsParientesAConectar.add(arrayIdsParientes.get(cmbBox_Parientes.getSelectedIndex()));
						arrayListNombresParientesAConectar.add(cmbBox_Parientes.getSelectedItem().toString());
						listModel_Parientes.addElement(cmbBox_Parientes.getItemAt(cmbBox_Parientes.getSelectedIndex()));
						jlist_Parientes.setModel(listModel_Parientes);
					}
					
				}
			}
		});
		cmbBox_Parientes.setBounds(416, 229, 233, 22);
		contentPane.add(cmbBox_Parientes);
		
		llenarParientes(cmbBox_Parientes, arrayIdsParientes);
		
		booting = false;
	}
}

