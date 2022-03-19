package challenge.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import challenge.dao.PremioDao;
import challenge.dao.jdbc.ConexionDB;
import challenge.domain.Premio;
import challenge.exception.GenericException;

public class PremioDaoImpl implements PremioDao {

	@Override
	public Premio getById(Long id) throws GenericException {
		
		Premio premio = null;

		String sql = "SELECT * FROM premios WHERE id = " + id;

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Integer puntos = rs.getInt(2);
						premio = new Premio(id, puntos);
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return premio;
	}

}
