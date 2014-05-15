import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class Navegador extends JFrame implements ActionListener
{
	JButton Siguiente=new JButton("Siguiente");
	JButton Anterior=new JButton("Anterior");
	JButton Primero=new JButton("Primero");
	JButton Ultimo=new JButton("Último");
	
	JTextField Caja=new JTextField(5);
	
	JTextField NSocio=new JTextField(20);
	JTextField Nombre=new JTextField(20);
	JTextField Direc=new JTextField(20);
	JTextField Telf=new JTextField(20);
	
	JLabel LSocio= new JLabel("Nº Socio:                      ");
	JLabel LNombre=new JLabel("Nombre:                        ");
	JLabel LDirec= new JLabel("Dirección:                     ");
	JLabel LTelf=  new JLabel("Teléfono:                      ");
	
	Connection Conexion;
	ResultSet Resultado;
	Statement Sentencia;
	String Conex="";
	Navegador()
	{
		DialogoAbrir DAbr=new DialogoAbrir(this,true);
		Conex =DAbr.DevBD();
		System.out.println(Conex);
		BaseDatos();
		JPanel Centro=new JPanel();
		Centro.add(LSocio);
		Centro.add(NSocio);
		Centro.add(LNombre);
		Centro.add(Nombre);
		Centro.add(LDirec);
		Centro.add(Direc);
		Centro.add(LTelf);
		Centro.add(Telf);
		add(Centro,"Center");
		
		
		
		JPanel Sur=new JPanel();
		Sur.setLayout(new FlowLayout());
		Sur.add(Primero);
		Primero.addActionListener(this);
		Sur.add(Anterior);
		Anterior.addActionListener(this);
		Sur.add(Caja);
		Caja.addActionListener(this);
		Sur.add(Siguiente);
		Siguiente.addActionListener(this);
		Sur.add(Ultimo);
		Ultimo.addActionListener(this);
		add(Sur,"South");
		
		//Cerrar Ventana
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			 {
			 	try
				 {
			 		Resultado.close();
				    Conexion.close();
				 }
				 catch(SQLException sqle)
				 {
				 }
			 	System.exit(0);
			 }
		});	
		
		setLocation(100,100);
		setTitle("Navegador");
		setResizable(false);	
	    setSize(420,200);
	    setVisible(true);
	}
	
	void BaseDatos()
		{
				try
				 {
				 //Cargar Controlador
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
				 //Conectar a la BD	 	
				 Conexion=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+Conex);
				 Sentencia=Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			     Resultado=Sentencia.executeQuery("SELECT * FROM Socios ORDER BY 1");
			     boolean esiste=Resultado.first();
			     if(esiste)
				     {
				     	Caja.setText(Integer.toString(Resultado.getRow()));
				     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
				     	Nombre.setText(Resultado.getString(2));
				     	Direc.setText(Resultado.getString(3));
				     	Telf.setText(Integer.toString(Resultado.getInt(4)));
				     }   
				 }
				catch(ClassNotFoundException cnfe)
					{
					//No Hay driver
					System.out.println(cnfe);
					}
					catch(SQLException sqle)
					{
					System.out.println(sqle);
					}
				catch(NumberFormatException nfe)
				{
					
				}
		}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Primero)
		{
		  try
		   {
		   	boolean esiste=Resultado.first();
			     if(esiste)
				     {
				     	Caja.setText(Integer.toString(Resultado.getRow()));
				     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
				     	Nombre.setText(Resultado.getString(2));
				     	Direc.setText(Resultado.getString(3));
				     	Telf.setText(Integer.toString(Resultado.getInt(4)));
				     }   
		   }
		   	catch(SQLException sqle)
					{
					
					}	
		}
		if(ae.getSource()==Ultimo)
		{
			try
			   {
			   	boolean esiste=Resultado.last();
				     if(esiste)
					     {
					     	Caja.setText(Integer.toString(Resultado.getRow()));
					     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
					     	Nombre.setText(Resultado.getString(2));
					     	Direc.setText(Resultado.getString(3));
					     	Telf.setText(Integer.toString(Resultado.getInt(4)));  
					     }	
			   }
			   	catch(SQLException sqle)
						{
						
						}	
		 }
		 if(ae.getSource()==Siguiente )
		 {
		 	try
			   {
			   	boolean esiste=Resultado.next();
				     if(esiste)
					     {
					     	Caja.setText(Integer.toString(Resultado.getRow()));
					     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
					     	Nombre.setText(Resultado.getString(2));
					     	Direc.setText(Resultado.getString(3));
					     	Telf.setText(Integer.toString(Resultado.getInt(4)));  
					     }
					     else
					     { 
					     boolean esi=Resultado.last();
					     }	
			   }
			   	catch(SQLException sqle)
						{
					      
						}	
		 }
		 
		 if(ae.getSource()==Anterior)
		 {
		   try
			   {
			   	boolean esiste=Resultado.previous();
				     if(esiste)
					     {
					     	Caja.setText(Integer.toString(Resultado.getRow()));
					     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
					     	Nombre.setText(Resultado.getString(2));
					     	Direc.setText(Resultado.getString(3));
					     	Telf.setText(Integer.toString(Resultado.getInt(4)));  
					     }	
			   }
			   	catch(SQLException sqle)
						{
						
						}	
		 }	
		 if(ae.getSource()==Caja)
		 {
		 	try
			   {
			   	int Cj=Integer.parseInt(Caja.getText());
			   	boolean esiste=Resultado.absolute(Cj);
				     if(esiste && Cj>0)
					     {
					     	Caja.setText(Integer.toString(Resultado.getRow()));
					     	NSocio.setText(Integer.toString(Resultado.getInt(1)));
					     	Nombre.setText(Resultado.getString(2));
					     	Direc.setText(Resultado.getString(3));
					     	Telf.setText(Integer.toString(Resultado.getInt(4)));  
					     }
					     else Caja.setText(Integer.toString(Resultado.getRow()));	
			   }
			   	catch(SQLException sqle)
						{
						
						}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(this,"Numero de registro no válido");
					Caja.setText("");	
				}	
		 } 
      }
	
	
	public static void main(String []args)
	{
	  new Navegador();	
	}
}

class DialogoAbrir extends JDialog implements ActionListener
{
	JButton Abrir=new JButton("Abrir");
	String Direccion="";
	//BD
	String SConexion="";
	
	DialogoAbrir(JFrame ini,boolean b)
	{
	    super(ini,b);
	    setLayout(new FlowLayout());
	    add(Abrir);
	    Abrir.addActionListener(this);
	    
	    addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			 {
			 	System.exit(0);
			 }
		});	
	    setLocation(100,100);
		setTitle("Navegador");
		setResizable(false);	
	    pack();
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Abrir)
		{
			JFileChooser CAbrir= new JFileChooser(System.getProperty("user.dir"));
			CAbrir.showOpenDialog(this);
			if(CAbrir.getSelectedFile()!=null)
			{
		    SConexion=CAbrir.getSelectedFile().getAbsolutePath();
		    dispose();
		    }
		}
	
	}
		String DevBD()
		{
			return SConexion;
		}
}