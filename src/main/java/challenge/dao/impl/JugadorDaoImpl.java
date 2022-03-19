package challenge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import challenge.dao.JugadorDao;
import challenge.dao.jdbc.ConexionDB;
import challenge.domain.Jugador;
import challenge.exception.GenericException;

public class JugadorDaoImpl implements JugadorDao {

	@Override
	public Jugador getByEmail(String email) throws GenericException {
		Jugador jugador = null;

		String sql = "SELECT * FROM jugadores WHERE email = '" + email + "'";

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						String nombre = rs.getString(2);
						String apellido = rs.getString(3);
						jugador = new Jugador(id, nombre, apellido, email);
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return jugador;
	}

	@Override
	public Jugador save(Jugador jugador) throws GenericException {
		String sql = "INSERT INTO jugadores(nombre, apellido, email)  VALUES(?, ?, ?);";

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pst.setString(1, jugador.getNombre());
				pst.setString(2, jugador.getApellido());
				pst.setString(3, jugador.getEmail());
				
				pst.execute();
				
				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						jugador.setId(id);
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo ejecutar: " + sql, e);
		}

		return jugador;
	}

	@Override
	public Boolean emailExist(String email) throws GenericException {
		
		boolean exist = false;
		if (getByEmail(email) != null) {
			exist = true;
		}
		return exist; 
	}

}
