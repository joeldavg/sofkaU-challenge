package challange.menu;

import java.util.List;
import java.util.Scanner;

import challange.dao.PartidaDao;
import challange.dao.impl.PartidaDaoImpl;
import challange.domain.Jugador;
import challange.domain.Nivel;
import challange.domain.Partida;
import challange.exception.GenericException;

public class MenuPartida {

	private static PartidaDao partidaDao = new PartidaDaoImpl();

	public static void iniciarPartida(Jugador jugador) throws GenericException {
		int puntosTotales = 0;
		primeraRonda(puntosTotales, jugador);
	}
	
	public static void verHistorialPartidas(Jugador jugador) throws GenericException {
		List<Partida> partidas = partidaDao.getByJugadoresId(jugador.getId());
		for (Partida partida : partidas) {
			System.out.println(partida);
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
			System.out.println("FELICITACIONES GANASTE EL JUEVO");
			System.out.println("Total de puntos obtenidos: " + puntosTotales);
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