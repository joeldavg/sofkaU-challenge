package challange;

import java.util.List;

import challenge.dao.CategoriaDao;
import challenge.dao.JugadorDao;
import challenge.dao.PartidaDao;
import challenge.dao.PreguntaDao;
import challenge.dao.PremioDao;
import challenge.dao.RespuestaDao;
import challenge.dao.impl.CategoriaDaoImpl;
import challenge.dao.impl.JugadorDaoImpl;
import challenge.dao.impl.PartidaDaoImpl;
import challenge.dao.impl.PreguntaDaoImpl;
import challenge.dao.impl.PremioDaoImpl;
import challenge.dao.impl.RespuestaDaoImpl;
import challenge.domain.Categoria;
import challenge.domain.Jugador;
import challenge.domain.Nivel;
import challenge.domain.Partida;
import challenge.domain.Pregunta;
import challenge.domain.Premio;
import challenge.domain.Respuesta;
import challenge.exception.GenericException;

public class Test {
	
	public static void main(String[] args) throws GenericException {
		
		PreguntaDao preguntaDao = new PreguntaDaoImpl();
		RespuestaDao respuestaDao = new RespuestaDaoImpl();
		CategoriaDao categoriaDao = new CategoriaDaoImpl();
		PremioDao premioDao = new PremioDaoImpl();
		JugadorDao jugadorDao = new JugadorDaoImpl();
		PartidaDao partidaDao = new PartidaDaoImpl();
	
		Categoria categoria = categoriaDao.getByLevel(Nivel.DOS);
		
//		List<Pregunta> preguntas = preguntaDao.getByCategoria(categoria.getId());
//		
//		for (Pregunta pregunta : preguntas) {
//			System.out.println(pregunta);
//			List<Respuesta> respuestas = respuestaDao.getByPregunta(pregunta.getId());
//			for (Respuesta respuesta : respuestas) {
//				System.out.println(respuesta);
//			}
//			Premio premio = premioDao.getById(categoria.getPuntosId());
//			System.out.println(premio.getPuntos());
//			System.out.println(premio);
//			System.out.println();
//		}
		
//		Jugador jugadorTest = new Jugador("kevin", "guzman", "keving@mail.com");
//		Jugador jugador = jugadorDao.save(jugadorTest);
//		System.out.println(jugador);
		
		Partida partida = partidaDao.save(new Partida(30, false, 1l, 2l));
//		System.out.println(partida);
		List<Partida> partidasJugadorId = partidaDao.getByJugadoresId(1l);
		for (Partida partida2 : partidasJugadorId) {
			System.out.println(partida2);
		}
		
	}

}
