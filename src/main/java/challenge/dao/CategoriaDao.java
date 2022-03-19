package challenge.dao;

import challenge.domain.Categoria;
import challenge.domain.Nivel;
import challenge.exception.GenericException;

public interface CategoriaDao {
	
	public Categoria getByLevel(Nivel nivel) throws GenericException;
	
}
