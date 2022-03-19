package challange.dao;

import java.util.List;

import challange.domain.Pregunta;
import challange.exception.GenericException;

public interface PreguntaDao {
	
	public List<Pregunta> getByCategoria(Long categoriaId) throws GenericException;
	
}
