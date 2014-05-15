package victor.donet.perruqueria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Perruqueria {
	private Connection con;
	private LinkedList<Cliente> listaClientes; 
//	private LinkedList<ClienteTintes> listaTintes; 
	private HashMap<Integer,ClienteTintes> listaTintes;
	
	public Perruqueria(){
		abrir_db();
		listaClientes = new LinkedList<Cliente>();
		recorrerClientes();
		listaTintes = new HashMap<Integer, ClienteTintes>();
		recorrerTintes();
		cerrar_db();
		comprobarDatos();
	}
	
	private void abrir_db(){
		System.out.println("ABRIENDO BASE DE DATOS");
		try	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Perruqueria\\Perruqueria.mdb";
			con = DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		System.out.println("BASE DE DATOS ABIERTA");
	}
		
	private void recorrerClientes(){
		try	{
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Clientes'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				anyadirCliente(rs);
			}
			try{
				rs.close();
			} catch (SQLException err){}
			pstmt.close();
		}
		catch(SQLException errSql){
			errSql.printStackTrace();
		}
	}

	private void recorrerTintes(){
		try	{
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Tintes'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				anyadirTinte(rs);
			}
			try{
				rs.close();
			} catch (SQLException err){}
			pstmt.close();
		}
		catch(SQLException errSql){
			errSql.printStackTrace();
		}
	}

	private void anyadirCliente(ResultSet result){
		try {
			String nombre = (String) result.getString(1);
			String apellidos = (String) result.getString(2);
			String dni = (String) result.getString(3);
			String sexo = (String) result.getString(4);
			String direccion = (String) result.getString(5);
			String poblacion = (String) result.getString(6);
			String cpostal = (String) result.getString(7);
			String telf = (String) result.getString(8);
			String movil = (String) result.getString(9);
			String email = (String) result.getString(10);
			int ident = (int) result.getInt(11);
			Date nacimiento = (Date) result.getDate(12);
			Date alta = (Date) result.getDate(13);
			Cliente clienteNuevo = new Cliente(nombre, apellidos, dni, sexo, direccion, poblacion, cpostal, telf, movil, email, ident, nacimiento, alta);
			insertarListaCliente(clienteNuevo);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	private void anyadirTinte(ResultSet result){
		try {
			int idTinte = (int) result.getInt(1);
			int idCliente = (int) result.getInt(2);
			Date fechaTinte = (Date) result.getDate(3);
			String nomTinte = (String) result.getString(4);
			String colorTinte = (String) result.getString(5);
			String observaciones = (String) result.getString(6);
			ClienteTintes tinteNuevo = new ClienteTintes(idTinte, idCliente, fechaTinte, nomTinte, colorTinte, observaciones);
			insertarListaTintes(idCliente, tinteNuevo);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	private void cerrar_db(){
		System.out.println("CERRANDO BASE DE DATOS");
		try	{
			con.close();
		} catch(SQLException ex){
			ex.printStackTrace();
		}
		System.out.println("BASE DE DATOS CERRADA");
	}

	private LinkedList<Cliente> getListaClientes() {
		return listaClientes;
	}

	private HashMap<Integer, ClienteTintes> getListaTintes() {
		return this.listaTintes;
	}

//	private void setListaClientes(LinkedList<Cliente> listaCli) {
//		this.listaClientes = listaCli;
//	}
	
//	private void vaciarListaClientes(){
//		this.listaClientes.clear();
//	}

	private void insertarListaCliente(Cliente Cli){
		this.listaClientes.add(Cli);
	}
	
	private void insertarListaTintes(int cliID, ClienteTintes Tint){
		this.listaTintes.put(cliID, Tint);
	}

//	private void vaciarListaTintes(){
//		this.listaTintes.clear();
//	}

	private void comprobarDatos(){
		System.out.println("LISTA DE CLIENTES:");
		Iterator<Cliente> it = getListaClientes().iterator();
		while (it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		System.out.println("LISTA DE TINTES:");
		Set<Integer> s = getListaTintes().keySet();
		Iterator<Integer> it2 = s.iterator();
		while (it2.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	
}
