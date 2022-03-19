package challenge.menu;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import challenge.dao.CategoriaDao;
import challenge.dao.PreguntaDao;
import challenge.dao.PremioDao;
import challenge.dao.RespuestaDao;
import challenge.dao.impl.CategoriaDaoImpl;
import challenge.dao.impl.PreguntaDaoImpl;
import challenge.dao.impl.PremioDaoImpl;
import challenge.dao.impl.RespuestaDaoImpl;
import challenge.domain.Categoria;
import challenge.domain.Nivel;
import challenge.domain.Pregunta;
import challenge.domain.Premio;
import challenge.domain.Respuesta;
import challenge.exception.GenericException;

public class MenuRonda {

	private static CategoriaDao categoriaDao = new CategoriaDaoImpl();
	private static PreguntaDao preguntaDao = new PreguntaDaoImpl();
	private static RespuestaDao respuestaDao = new RespuestaDaoImpl();
	private static PremioDao premioDao = new PremioDaoImpl();
	
	public static int nuevaRonda(Nivel nivel) throws GenericException {
		Scanner sc = new Scanner(System.in);
		Categoria categoria = categoriaDao.getByLevel(nivel);
		Pregunta pregunta = preguntaAleatoria(categoria.getId());
		List<Respuesta> respuestas = respuestaDao.getByPreguntaId(pregunta.getId());
		mostrarPregunta(nivel, pregunta, respuestas);
		int puntos = validarRespuesta(sc, categoria, respuestas);

		return puntos;
	}

	private static void mostrarPregunta(Nivel nivel, Pregunta pregunta, List<Respuesta> respuestas) {
		System.out.println("\n:: RONDA NIVEL: " + nivel.toString());
		System.out.println("\n" + pregunta.getPregunta());
		for (int i = 0; i < respuestas.size(); i++) {
			System.out.println((i+1)+ ". " + respuestas.get(i).getRespuesta());
		}
		System.out.println();
	}

	private static int validarRespuesta(Scanner sc, Categoria categoria, List<Respuesta> respuestas)
			throws GenericException {
		int opcion;
		int puntos = 0;
		do {
			System.out.println("Ingrese su respuesta:");
			opcion = sc.nextInt();
		} while (opcion<1 || opcion>4);
		Respuesta respuesta = respuestas.get(opcion-1);
		System.out.println("Su respuesta es: " + respuesta.getRespuesta());
		if (respuesta.getCorrecta()) {
			Premio premio = premioDao.getById(categoria.getPuntosId());
			puntos = premio.getPuntos();
			System.out.println("Respuesta correcta, has ganado " + premio.getPuntos() + " puntos.");
		} else {
			System.out.println("Respuesta incorrecta, gracias por participar.");
		}
		return puntos;
	}
	
	private static Pregunta preguntaAleatoria(Long categoriaId) throws GenericException {
		List<Pregunta> preguntas = preguntaDao.getByCategoria(categoriaId);
		Random r = new Random();
		int a = (int) (r.nextDouble() * preguntas.size());
		Pregunta pregunta = preguntas.get(a);

		return pregunta;
	}
}