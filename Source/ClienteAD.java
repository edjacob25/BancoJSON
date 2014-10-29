package modelBanco;

import java.io.*;
import java.util.StringTokenizer;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ClienteAD
{
	/*private	BufferedReader archivoEntrada;
	private	PrintWriter	   archivoSalida;*/
	private Connection conexion;
	private Statement statement;
	private ClienteDP clientedp = null;

	public ClienteAD()
	{
		try
		{
			//Access
			/*Class.forName("sun.jdbc.odbc.Jdbc0dbcDriver");
			DriverManager.getConnection("jdbc:odbc:bdAccess");*/
			
			//MySql
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/","myself","myself");
			System.out.println("nice");
		}
		catch(ClassNotFoundException cfe)
		{
			System.out.println("Error " + cfe);
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error " + ie);
		}
		catch(IllegalAccessException iae)
		{
			System.out.println("Error " + iae);
		}
		catch(java.sql.SQLException sqle)
		{
				System.out.println("Error " + sqle);
		}
	}

	public String depositar(String cuenta, int cantidad)
	{
		StringTokenizer st = new StringTokenizer(consultarNocta(cuenta),"_");
		String tipoCuenta = st.nextToken();
		tipoCuenta = st.nextToken();
		tipoCuenta = st.nextToken();
		int saldo = Integer.parseInt(st.nextToken());
		if (tipoCuenta.equals("HIPOTECA")||tipoCuenta.equals("CREDITO"))
			cantidad = cantidad * -1;
		saldo = saldo + cantidad;
		
		String resultado="";
		String query= "";
		try
		{
			// 1. Abrir	el archivo para	escribir o guardar o almacenar los datos
			statement = conexion.createStatement();
			// 2. Escribir,	guardar	o almacenar	los	datos
			query = "UPDATE `banco`.`clientes` SET saldo ='"+ saldo + "' WHERE nocta ="+cuenta +";";
			statement.executeUpdate(query);
			// 3. Cerrar el	archivo
			statement.close();

			resultado = "Nuevo saldo: \n"+saldo;
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			resultado = "Error: "+ioe;
		}

		return resultado;

	}

	public String retirar(String cuenta, int cantidad)
	{
		StringTokenizer st = new StringTokenizer(consultarNocta(cuenta),"_");
		String tipoCuenta = st.nextToken();
		tipoCuenta = st.nextToken();
		tipoCuenta = st.nextToken();
		int saldo = Integer.parseInt(st.nextToken());
		String resultado="";
		String query= "";
		if (tipoCuenta.equals("HIPOTECA"))
			resultado = "No puedes retirar de una cuenta de HIPOTECA";
		else
		{
			if (tipoCuenta.equals("CREDITO"))
				saldo = saldo + cantidad;
			else
				saldo = saldo - cantidad;
			try
			{
				// 1. Abrir	el archivo para	escribir o guardar o almacenar los datos
				statement = conexion.createStatement();
				// 2. Escribir,	guardar	o almacenar	los	datos
				query = "UPDATE `banco`.`clientes` SET saldo ='"+ saldo + "' WHERE nocta ="+cuenta +";";
				statement.executeUpdate(query);
				// 3. Cerrar el	archivo
				statement.close();

				resultado = "Nuevo saldo: \n"+saldo;
			}
			catch(SQLException ioe)
			{
				System.out.println("Error: "+ioe);
				resultado = "Error: "+ioe;
			}
		}	

		return resultado;

	}

	public String capturar(String datos)
	{
		String resultado="";
		String query= "";
		clientedp = new ClienteDP(datos);
		try
		{
			// 1. Abrir	el archivo para	escribir o guardar o almacenar los datos
			statement = conexion.createStatement();
			// 2. Escribir,	guardar	o almacenar	los	datos
			query = "INSERT INTO `banco`.`clientes`(`nocta`, `nombre`, `tipo`, `saldo`) VALUES('"+clientedp.getNocta()+"','"+clientedp.getNombre()+"','"+clientedp.getTipo()+"','"+clientedp.getSaldo()+ "');";
			statement.executeUpdate(query);
			// 3. Cerrar el	archivo
			statement.close();
			

			resultado = "Datos capturados: \n"+datos;
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			resultado = "Error: "+ioe;
		}


		return resultado;
	}

	public String consultarDatos()
	{
		String datos="";
		String query = "";
		clientedp = new ClienteDP();
		ResultSet resultado = null;
		try
		{
			// 1. Abrir	el archivo para	leer
			statement = conexion.createStatement();

			// 2. Procesar los datos
			// 2.1 Hacer el query
			query = "SELECT * FROM `banco`.`clientes`";
			resultado = statement.executeQuery(query);
			//2.2 Procesar	
			while(resultado.next())
			{
				clientedp.setNocta(resultado.getString("nocta"));
				clientedp.setNombre(resultado.getString("nombre"));
				clientedp.setTipo(resultado.getString(3));
				clientedp.setSaldo(resultado.getInt(4));

				datos = datos + clientedp.toString() + "\n";
			}
			
			// 3. Cerrar el	archivo
			statement.close();
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			datos = "Error "+ioe;
		}

		return datos;
	}

	public String consultarNocta(String nocta)
	{
		String datos ="";
		String query = "";
		clientedp = new ClienteDP();
		ResultSet resultado = null;
		try
		{
			// 1. Abrir	el archivo para	leer
			statement = conexion.createStatement();

			// 2. Procesar los datos
			// 2.1 Hacer el query
			query = "SELECT * FROM `banco`.`clientes` WHERE `nocta` = "+nocta;
			resultado = statement.executeQuery(query);
			//2.2 Procesar	
			while(resultado.next())
			{
				clientedp.setNocta(resultado.getString("nocta"));
				clientedp.setNombre(resultado.getString("nombre"));
				clientedp.setTipo(resultado.getString(3));
				clientedp.setSaldo(resultado.getInt(4));

				datos = datos + clientedp.toString();
			}
			
			// 3. Cerrar el	archivo
			statement.close();
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			datos = "Error "+ioe;
		}

		return datos;
	}

	public String modificar(String datos)
	{
		String resultado="";
		String query= "";
		clientedp = new ClienteDP(datos);
		try
		{
			// 1. Abrir	el archivo para	escribir o guardar o almacenar los datos
			statement = conexion.createStatement();
			// 2. Escribir,	guardar	o almacenar	los	datos
			query = "UPDATE `banco`.`clientes` SET nombre = '" + clientedp.getNombre()+"',tipo='"+clientedp.getTipo()+"',saldo ='"+clientedp.getSaldo()+ "' WHERE nocta ="+clientedp.getNocta() +";";
			statement.executeUpdate(query);
			// 3. Cerrar el	archivo
			statement.close();
			

			resultado = "Datos actualizados: \n"+datos;
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			resultado = "Error: "+ioe;
		}

		return resultado;
	}
	
	public String consultarTipo(String tipo)
	{
		String datos ="";
		String query = "";
		clientedp = new ClienteDP();
		ResultSet resultado = null;
		try
		{
			// 1. Abrir	el archivo para	leer
			statement = conexion.createStatement();

			// 2. Procesar los datos
			// 2.1 Hacer el query
			query = "SELECT * FROM `banco`.`clientes` WHERE `tipo` = '"+tipo+"'";
			System.out.println(query);
			resultado = statement.executeQuery(query);
			//2.2 Procesar	
			while(resultado.next())
			{
				clientedp.setNocta(resultado.getString("nocta"));
				clientedp.setNombre(resultado.getString("nombre"));
				clientedp.setTipo(resultado.getString(3));
				clientedp.setSaldo(resultado.getInt(4));

				datos = datos + clientedp.toString() + "\n";
			}
			
			// 3. Cerrar el	archivo
			statement.close();
		}
		catch(SQLException ioe)
		{
			System.out.println("Error: "+ioe);
			datos = "Error "+ioe;
		}

		return datos;
	}
}