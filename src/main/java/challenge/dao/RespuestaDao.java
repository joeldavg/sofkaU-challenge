package challenge.dao;

import java.util.List;

import challenge.domain.Respuesta;
import challenge.exception.GenericException;

public interface RespuestaDao {
	
	public List<Respuesta> getByPreguntaId(Long preguntaId) throws GenericException;
	
}
