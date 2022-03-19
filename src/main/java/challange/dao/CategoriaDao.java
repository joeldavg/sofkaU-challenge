package challange.dao;

import challange.domain.Categoria;
import challange.domain.Nivel;
import challange.exception.GenericException;

public interface CategoriaDao {
	
	public Categoria getByLevel(Nivel nivel) throws GenericException;
	
}
