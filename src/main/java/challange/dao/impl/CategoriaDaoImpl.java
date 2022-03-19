package challange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import challange.dao.CategoriaDao;
import challange.dao.jdbc.ConexionDB;
import challange.domain.Categoria;
import challange.domain.Nivel;
import challange.exception.GenericException;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public Categoria getByLevel(Nivel nivel) throws GenericException {

		Categoria categoria = null;

		String sql = "SELECT * FROM categorias WHERE nivel = '" + nivel.toString() + "'";

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						Long puntosId = rs.getLong(3);
						categoria = new Categoria(id, nivel, puntosId);
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return categoria;
	}

}
