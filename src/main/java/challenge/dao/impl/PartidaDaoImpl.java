package challenge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import challenge.dao.PartidaDao;
import challenge.dao.jdbc.ConexionDB;
import challenge.domain.Partida;
import challenge.exception.GenericException;

public class PartidaDaoImpl implements PartidaDao {

	@Override
	public List<Partida> getByJugadoresId(Long jugadoresId) throws GenericException {
		List<Partida> partidas = new ArrayList<>();
		String sql = "SELECT * FROM partidas WHERE jugadores_id = " + jugadoresId;
		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						Integer puntosTotales = rs.getInt(2);
						Boolean ganada = rs.getBoolean(3);
						Long categoriaIdAlcanzada = rs.getLong(5);
						partidas.add(new Partida(id, puntosTotales, ganada, jugadoresId, categoriaIdAlcanzada));
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}
		return partidas;
	}

	@Override
	public Partida save(Partida partida) throws GenericException {
		String sql = "INSERT INTO partidas(puntos_totales, ganada, jugadores_id, categoria_id_alcanzada)"
				+ " VALUES(?, ?, ?, ?);";
		try (Connection connection = ConexionDB.obtenerConexion()) {

			try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pst.setInt(1, partida.getPuntosTotales());
				pst.setBoolean(2, partida.getGanada());
				pst.setLong(3, partida.getJugadoresId());
				pst.setLong(4, partida.getCategoriaIdAlcanzada());

				pst.execute();

				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
						Long id = rs.getLong(1);
						partida.setId(id);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo ejecutar: " + sql, e);
		}

		return partida;
	}

}
