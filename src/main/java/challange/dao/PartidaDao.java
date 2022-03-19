package challange.dao;

import java.util.List;

import challange.domain.Partida;
import challange.exception.GenericException;

public interface PartidaDao {
	
	public List<Partida> getByJugadoresId(Long jugadoresId) throws GenericException;
	
//	public List<Partida> getByGanada(Boolean ganada) throws GenericException;
	
	public Partida save(Partida partida) throws GenericException;
	
}
