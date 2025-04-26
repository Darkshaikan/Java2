package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {
	
	public static Connection obtenerConexion() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:1111/mariadb-js?serverTimeZone=UTC&userSSL=false";
		String usuarios = "root";
		String password = "root-secret-password";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url,usuarios,password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
		
		
		
		
	}
	
	

}
