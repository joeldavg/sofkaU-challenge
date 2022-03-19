package challenge.dao;

import challenge.domain.Jugador;
import challenge.exception.GenericException;

public interface JugadorDao {
	
	public Jugador getByEmail(String email) throws GenericException;
	
	public Jugador save(Jugador jugador) throws GenericException;
	
	public Boolean emailExist(String email) throws GenericException;
	
}
