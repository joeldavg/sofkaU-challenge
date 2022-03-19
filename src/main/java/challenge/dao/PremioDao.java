package challenge.dao;

import challenge.domain.Premio;
import challenge.exception.GenericException;

public interface PremioDao {
	
	public Premio getById(Long id) throws GenericException;
	
}
