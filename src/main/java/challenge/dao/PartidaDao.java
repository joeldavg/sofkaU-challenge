package challenge.dao;

import java.util.List;

import challenge.domain.Partida;
import challenge.exception.GenericException;

public interface PartidaDao {
	
	public List<Partida> getByJugadoresId(Long jugadoresId) throws GenericException;
	
//	public List<Partida> getByGanada(Boolean ganada) throws GenericException;
	
	public Partida save(Partida partida) throws GenericException;
	
}
