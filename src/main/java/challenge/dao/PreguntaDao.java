package challenge.dao;

import java.util.List;

import challenge.domain.Pregunta;
import challenge.exception.GenericException;

public interface PreguntaDao {
	
	public List<Pregunta> getByCategoria(Long categoriaId) throws GenericException;
	
}
