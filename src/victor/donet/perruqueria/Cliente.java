package victor.donet.perruqueria;

import java.text.DateFormat;
import java.util.Date;

public class Cliente {
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String sexo;
	private String direccion;
	private String poblacion;
	private String cPostal;
	private String telefono;
	private String movil;
	private String email;
	private Date fechaAlta;
	private Date fechaNacimiento;
	
	// Constructor sin la fecha de alta, utilizado para creación de nuevos clientes.
	public Cliente(String nombre2, String apellidos2, String dni2, String sexo2, String direccion2, String poblacion2, String cpostal2, String telf, String movil2, String email2, int ident, Date nacimiento){
		this.setId(ident);
		this.setNombre(nombre2);
		this.setApellidos(apellidos2);
		this.setDni(dni2);
		this.setSexo(sexo2);
		this.setDireccion(direccion2);
		this.setPoblacion(poblacion2);
		this.setcPostal(cpostal2);
		this.setTelefono(telf);
		this.setMovil(movil2);
		this.setEmail(email2);
		this.setFechaAlta();
		this.setFechaNacimiento(nacimiento);
	}

	// Constructor con la fecha de alta, utilizapo para la importacion desde la base de datos.
	public Cliente(String nombre2, String apellidos2, String dni2, String sexo2, String direccion2, String poblacion2, String cpostal2, String telf, String movil2, String email2, int ident, Date nacimiento, Date alta){
		this.setId(ident);
		this.setNombre(nombre2);
		this.setApellidos(apellidos2);
		this.setDni(dni2);
		this.setSexo(sexo2);
		this.setDireccion(direccion2);
		this.setPoblacion(poblacion2);
		this.setcPostal(cpostal2);
		this.setTelefono(telf);
		this.setMovil(movil2);
		this.setEmail(email2);
		this.setFechaAlta2(alta);
		this.setFechaNacimiento(nacimiento);
	}

	public int getId() {
		return id;
	}

	public void setId(int ident) {
		this.id = ident;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nom) {
		this.nombre = nom;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String ape) {
		this.apellidos = ape;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String doc) {
		this.dni = doc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String pob) {
		this.poblacion = pob;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String tFijo) {
		this.telefono = tFijo;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String tMovil) {
		this.movil = tMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String correo) {
		this.email = correo;
	}

	public String getFechaAlta() {
		DateFormat df =  DateFormat.getDateInstance();
		return df.format(fechaAlta);
	}

	public void setFechaAlta() {
		this.fechaAlta = new Date();
	}

	public void setFechaAlta2(Date fAlta) {
		this.fechaAlta = fAlta;
	}

	public String getFechaNacimiento() {
		DateFormat df =  DateFormat.getDateInstance();
		return df.format(fechaNacimiento);
	}

	public void setFechaNacimiento(Date fNac) {
		this.fechaNacimiento = fNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sex) {
		this.sexo = sex;
	}

	public String getcPostal() {
		return cPostal;
	}

	public void setcPostal(String cp) {
		this.cPostal = cp;
	}

	public String toString(){
		String strCliente = "";
		strCliente = String.format("%d %s %s %s %s\n", this.getId(), this.getNombre(), this.getApellidos(), this.getDni(), this.getSexo());
		strCliente = strCliente + String.format("%s %s %s\n", this.getMovil(), this.getTelefono(), this.getEmail());
		strCliente = strCliente + String.format("%s %s %s\n", this.getDireccion(), this.getcPostal(), this.getPoblacion());
		strCliente = strCliente + String.format("Alta: %s, Nacio el: %s\n", this.getFechaAlta(), this.getFechaNacimiento());
		return strCliente;
	}
}
