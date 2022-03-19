package challange;

import java.util.List;

import challange.dao.CategoriaDao;
import challange.dao.JugadorDao;
import challange.dao.PartidaDao;
import challange.dao.PreguntaDao;
import challange.dao.PremioDao;
import challange.dao.RespuestaDao;
import challange.dao.impl.CategoriaDaoImpl;
import challange.dao.impl.JugadorDaoImpl;
import challange.dao.impl.PartidaDaoImpl;
import challange.dao.impl.PreguntaDaoImpl;
import challange.dao.impl.PremioDaoImpl;
import challange.dao.impl.RespuestaDaoImpl;
import challange.domain.Categoria;
import challange.domain.Jugador;
import challange.domain.Nivel;
import challange.domain.Partida;
import challange.domain.Pregunta;
import challange.domain.Premio;
import challange.domain.Respuesta;
import challange.exception.GenericException;

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
