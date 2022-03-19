package challenge.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import challenge.exception.GenericException;


public class ConexionDB {

	public static Connection obtenerConexion() throws GenericException{
		
		String host = "ec2-54-83-21-198.compute-1.amazonaws.com";
		String database = "ddb1f37ahbs315";
		String user = "olggbngfmlxxbj";
		String password = "e992f7481dc25df52341d58e818812daccd1ef1db629000df69efd51f812b541";

		String url = "jdbc:postgresql://" + host + ":5432/" + database
				+ "?serverTimezone=UTC&userSSL=false";
		String driverName = "org.postgresql.Driver";
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericException("Error obteniendo conexion: " + e.getMessage(), e);
		}
		
	}
	
	public static void main(String[] args) {
		try (Connection connection = ConexionDB.obtenerConexion()) {
			System.out.println("Conexion obtenida");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
