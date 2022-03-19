package challenge.menu;

import java.util.Scanner;

import challenge.dao.JugadorDao;
import challenge.dao.impl.JugadorDaoImpl;
import challenge.domain.Jugador;
import challenge.exception.GenericException;

public class MenuJugador {

	private static JugadorDao jugadorDao = new JugadorDaoImpl();

	public static void crearJugador() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("\n:: CREAR JUGADOR");
			System.out.println("\nIngrese email:");
			String email = sc.nextLine().toLowerCase();
			if (jugadorDao.emailExist(email)) {
				throw new GenericException("Email se encuentra registrado: " + email.toLowerCase());
			}
			System.out.println("\nIngrese nombre:");
			String nombre = sc.nextLine().toLowerCase();
			System.out.println("\nIngrese apellido:");
			String apellido = sc.nextLine().toLowerCase();

			Jugador jugador = new Jugador(nombre, apellido, email);
			jugadorDao.save(jugador);
			System.out.println("\n" + nombre.toUpperCase() + ", su registro fue exitoso!");
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void buscarJugador() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("\nBUSCAR JUGADOR");
			System.out.println("\nIngrese email:");
			String email = sc.nextLine().toLowerCase();
			if (!jugadorDao.emailExist(email)) {
				throw new GenericException("Email: " + email + " no se encuentra en base de datos, "
						+ "ingresar email correcto o crear nuevo jugador.");
			}
			Jugador jugador = jugadorDao.getByEmail(email);
			mostrarMenuJugador(jugador);
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void mostrarMenuJugador(Jugador jugador) throws GenericException {
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			System.out.println("\n:: BIENVENIDO: " + jugador.getNombre().toUpperCase());
			System.out.println("\nSeleccione una opcion:");
			System.out.println("1. Iniciar partida");
			System.out.println("2. Ver historial de partidas");
			System.out.println("0. Volver al Menu \n");
			
			response = sc.nextInt();
			switch (response) {
			case 1:
				MenuPartida.iniciarPartida(jugador);
				break;
			case 2:
				MenuPartida.verHistorialPartidas(jugador);;
				break;
			case 0:
				System.out.println("Gracias, vuelve pronto "+ jugador.getNombre().toUpperCase() +"!");
				break;
			default:
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response  != 0);
	}

}