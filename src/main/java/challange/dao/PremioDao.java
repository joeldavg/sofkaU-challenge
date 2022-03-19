package challange.dao;

import challange.domain.Premio;
import challange.exception.GenericException;

public interface PremioDao {
	
	public Premio getById(Long id) throws GenericException;
	
}
