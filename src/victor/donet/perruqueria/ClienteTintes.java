package victor.donet.perruqueria;

import java.text.DateFormat;
import java.util.Date;

public class ClienteTintes {

	private int id;
	private int idCliente;
	private Date fecha;
	private String tinte;
	private String color;
	private String observaciones;
	
	public ClienteTintes(){
		this.setId(0);
		this.setIdCliente(0);
		this.setFecha();
		this.setTinte("");
		this.setColor("");
		this.setObservaciones("");
	}

	public ClienteTintes(int idTinte, int idCliente2, Date fechaTinte, String nomTinte, String colorTinte, String observaciones2) {
		this.setId(idTinte);
		this.setIdCliente(idCliente2);
		this.setFecha2(fechaTinte);
		this.setTinte(nomTinte);
		this.setColor(colorTinte);
		this.setObservaciones(observaciones2);
	}

	public int getId() {
		return id;
	}

	public void setId(int ident) {
		this.id = ident;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCli) {
		this.idCliente = idCli;
	}

	public String getFecha() {
		DateFormat df =  DateFormat.getDateInstance();
		return df.format(fecha);
	}

	public void setFecha() {
		this.fecha = new Date();
	}

	public void setFecha2(Date fTinte) {
		this.fecha = fTinte;
	}

	public String getTinte() {
		return tinte;
	}

	public void setTinte(String tint) {
		this.tinte = tint;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String col) {
		this.color = col;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String obs) {
		this.observaciones = obs;
	}
	
	public String toString(){
		String tcliente = "";
		tcliente = String.format("%s %s %s %s",this.getFecha(),this.getTinte(),this.getColor(),this.getObservaciones());
		return tcliente;
	}
}
