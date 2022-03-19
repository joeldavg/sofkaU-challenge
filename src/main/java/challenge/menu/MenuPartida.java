package challenge.menu;

import java.util.List;
import java.util.Scanner;

import challenge.dao.PartidaDao;
import challenge.dao.impl.PartidaDaoImpl;
import challenge.domain.Jugador;
import challenge.domain.Nivel;
import challenge.domain.Partida;
import challenge.exception.GenericException;

public class MenuPartida {

	private static PartidaDao partidaDao = new PartidaDaoImpl();

	public static void iniciarPartida(Jugador jugador) throws GenericException {
		int puntosTotales = 0;
		primeraRonda(puntosTotales, jugador);
	}
	
	public static void verHistorialPartidas(Jugador jugador) throws GenericException {
		System.out.println("\n:: HISTORIAL DE PARTIDAS: " + jugador.getNombre().toUpperCase()+"\n");
		List<Partida> partidas = partidaDao.getByJugadoresId(jugador.getId());
		if (partidas.isEmpty()) {
			System.out.println("NO HAY REGISTROS, INICIAR NUEVA PARTIDA");
		} else {
			Partida partida = null;
			for (int i = 0; i < partidas.size(); i++) {
				partida = partidas.get(i);
				System.out.println((i+1) + ". id: " + partida.getId()
				+ ", Nivel Alcanzado: " + partida.getCategoriaIdAlcanzada()
				+ ", Puntos acomulado: " + partida.getPuntosTotales()
				+ ", Partida ganada: " + (partida.getGanada()?"SI":"NO") );
			}
		}
	}

	private static void primeraRonda(int puntosTotales, Jugador jugador) throws GenericException {
		int puntos = MenuRonda.nuevaRonda(Nivel.UNO);
		if (puntos == 0) {
			puntosTotales = 0;
			guardarPartida(puntosTotales, false, jugador, 1l);
		} else {
			puntosTotales += puntos;
			int response = deseaContinuar(puntosTotales);
			switch (response) {
			case 1:
				segundaRonda(puntosTotales, jugador);
				break;
			case 2:
				guardarPartida(puntosTotales, false, jugador, 1l);
				break;
			}
		}
	}

	private static void segundaRonda(int puntosTotales, Jugador jugador) throws GenericException {
		int puntos = MenuRonda.nuevaRonda(Nivel.DOS);
		long categoriaId = 2l;
		if (puntos == 0) {
			puntosTotales = 0;
			guardarPartida(puntosTotales, false, jugador, categoriaId);
		} else {
			puntosTotales += puntos;
			int response = deseaContinuar(puntosTotales);
			switch (response) {
			case 1:
				terceraRonda(puntosTotales, jugador);
				break;
			case 2:
				guardarPartida(puntosTotales, false, jugador, categoriaId);
				break;
			}
		}
	}

	private static void terceraRonda(int puntosTotales, Jugador jugador) throws GenericException {
		int puntos = MenuRonda.nuevaRonda(Nivel.TRES);
		long categoriaId = 3l;
		if (puntos == 0) {
			puntosTotales = 0;
			guardarPartida(puntosTotales, false, jugador, categoriaId);
		} else {
			puntosTotales += puntos;
			int response = deseaContinuar(puntosTotales);
			switch (response) {
			case 1:
				cuartaRonda(puntosTotales, jugador);
				break;
			case 2:
				guardarPartida(puntosTotales, false, jugador, categoriaId);
				break;
			}
		}
	}

	private static void cuartaRonda(int puntosTotales, Jugador jugador) throws GenericException {
		int puntos = MenuRonda.nuevaRonda(Nivel.CUATRO);
		long categoriaId = 4l;
		if (puntos == 0) {
			puntosTotales = 0;
			guardarPartida(puntosTotales, false, jugador, categoriaId);
		} else {
			puntosTotales += puntos;
			int response = deseaContinuar(puntosTotales);
			switch (response) {
			case 1:
				quintaRonda(puntosTotales, jugador);
				break;
			case 2:
				guardarPartida(puntosTotales, false, jugador, categoriaId);
				break;
			}
		}
	}

	private static void quintaRonda(int puntosTotales, Jugador jugador) throws GenericException {
		int puntos = MenuRonda.nuevaRonda(Nivel.CINCO);
		long categoriaId = 5l;
		if (puntos == 0) {
			puntosTotales = 0;
			guardarPartida(puntosTotales, false, jugador, categoriaId);
		} else {
			puntosTotales += puntos;
			guardarPartida(puntosTotales, true, jugador, categoriaId);
			System.out.println("\nTotal de puntos obtenidos: " + puntosTotales);
			System.out.println("FELICITACIONES " + jugador.getNombre() + "GANASTE EL JUEGO");
		}
	}

	private static int deseaContinuar(int puntosTotales) {
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			System.out.println("\nSu puntos acomulados son: " + puntosTotales);
			System.out.println("Desea continuar a la siguiente ronda?");
			System.out.println("1. Si");
			System.out.println("2. No");
			response = sc.nextInt();
		} while (response != 1 && response != 2);
		return response;
	}

	private static void guardarPartida(int puntosTotales, Boolean ganada, Jugador jugador, Long categoriaId)
			throws GenericException {
		Partida partida = new Partida(puntosTotales, ganada, jugador.getId(), categoriaId);
		partidaDao.save(partida);
	}
}