package victor.donet.perruqueria;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PantallaClientes extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel lblNombre, lblApellidos, lblNif, lblSexo;
	private JLabel lblDireccion, lblPoblacion, lblCPostal, lblTelFijo;
	private JLabel lblMovil, lblEmail, lblFecAlta, lblFecNac;
	private JTextField txfNombre, txfApellidos, txfNif, txfDireccion, txfPoblacion;
	private JTextField txfCPostal, txfTelFijo, txfMovil, txfEmail, txfFecAlta, txfFecNac;
	private ButtonGroup btgSexo;
	private JRadioButton rbtHombre, rbtMujer;
	private JButton btnAceptar, btnCancelar;
	
	
	public PantallaClientes(){
		inicializarVariables();
	}
	
	private void inicializarVariables(){
		this.setSize(300, 150);
		this.setLayout(new GridLayout(4,2));

		this.lblNombre = new JLabel("Nombre:");
		this.add(lblNombre);
		this.lblApellidos = new JLabel("Apellidos:");
		this.add(lblApellidos);
		this.lblNif = new JLabel("NIF:");
		this.add(lblNif);
		this.lblSexo = new JLabel("Sexo:");
		this.add(lblSexo);
		this.lblDireccion = new JLabel("Dirección:");
		this.add(lblDireccion);
		this.lblPoblacion = new JLabel("Población:");
		this.add(lblPoblacion);
		this.lblCPostal = new JLabel("Código Postal:");
		this.add(lblCPostal);
		this.lblTelFijo = new JLabel("Teléfono Fijo:");
		this.add(lblTelFijo);
		this.lblMovil = new JLabel("Móvil:");
		this.add(lblMovil);
		this.lblEmail = new JLabel("email:");
		this.add(lblEmail);
		this.lblFecAlta = new JLabel("Fecha de Alta:");
		this.add(lblFecAlta);
		this.lblFecNac = new JLabel("Fecha de Nacimiento:");
		this.add(lblFecNac);

		this.txfNombre = new JTextField(25);
		this.txfNombre.setName("nombre");
		this.add(txfNombre);
		this.txfApellidos = new JTextField(25);
		this.txfApellidos.setName("apellidos");
		this.add(txfApellidos);
		this.txfNif = new JTextField(12);
		this.txfNif.setName("nif");
		this.add(txfNif);
		this.txfDireccion = new JTextField(25);
		this.txfDireccion.setName("direccion");
		this.add(txfDireccion);
		this.txfPoblacion = new JTextField(25);
		this.txfPoblacion.setName("poblacion");
		this.add(txfPoblacion);
		this.txfCPostal = new JTextField(25);
		this.txfCPostal.setName("codigoPostal");
		this.add(txfCPostal);
		this.txfTelFijo = new JTextField(25);
		this.txfTelFijo.setName("telefono");
		this.add(txfTelFijo);
		this.txfMovil = new JTextField(25);
		this.txfMovil.setName("movil");
		this.add(txfMovil);
		this.txfEmail = new JTextField(25);
		this.txfEmail.setName("email");
		this.add(txfEmail);
		this.txfFecAlta = new JTextField(25);
		this.txfFecAlta.setName("alta");
		this.add(txfFecAlta);
		this.txfFecNac = new JTextField(25);
		this.txfFecNac.setName("nacimiento");
		this.add(txfFecNac);
		
		btgSexo = new ButtonGroup();
		rbtHombre = new JRadioButton("Hombre",false);
		rbtMujer = new JRadioButton("Mujer",true);
		
		
	}
}
