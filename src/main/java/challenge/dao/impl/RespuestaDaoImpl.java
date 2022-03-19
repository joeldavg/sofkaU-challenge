package challenge.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import challenge.dao.RespuestaDao;
import challenge.dao.jdbc.ConexionDB;
import challenge.domain.Respuesta;
import challenge.exception.GenericException;

public class RespuestaDaoImpl implements RespuestaDao {

	@Override
	public List<Respuesta> getByPreguntaId(Long preguntaId) throws GenericException {
		
		List<Respuesta> respuestas = new ArrayList<>();

		String sql = "SELECT * FROM respuestas WHERE preguntas_id = " + preguntaId;

		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						String respuesta = rs.getString(2);
						Boolean correcta = rs.getBoolean(3);
						respuestas.add(new Respuesta(id, respuesta, correcta, preguntaId));
					}
				}
			}

		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return respuestas;
	}

}
