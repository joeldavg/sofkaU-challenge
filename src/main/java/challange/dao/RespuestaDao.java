package challange.dao;

import java.util.List;

import challange.domain.Respuesta;
import challange.exception.GenericException;

public interface RespuestaDao {
	
	public List<Respuesta> getByPreguntaId(Long preguntaId) throws GenericException;
	
}
