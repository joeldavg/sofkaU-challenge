package challenge.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import challenge.dao.PreguntaDao;
import challenge.dao.jdbc.ConexionDB;
import challenge.domain.Pregunta;
import challenge.exception.GenericException;

public class PreguntaDaoImpl implements PreguntaDao {

	@Override
	public List<Pregunta> getByCategoria(Long categoriaId) throws GenericException {

		List<Pregunta> preguntas = new ArrayList<>();

		String sql = "SELECT * FROM preguntas WHERE categorias_id = " + categoriaId;

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						String pregunta = rs.getString(2);
						preguntas.add(new Pregunta(id, pregunta, categoriaId));
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return preguntas;
	}

}
