package challenge.menu;

import java.util.Scanner;

public class Menu {

	public void mostrarMenu() {
		System.out.println(":: BIENVENIDOS: PREGUNTAS Y RESPUESTAS CHALLENGE");
		
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			System.out.println("\nSeleccione una opcion:");
			System.out.println("1. Jugar");
			System.out.println("0. Salir del juego\n");
			
			response = sc.nextInt();
			switch (response) {
			case 1:
				jugar();
				break;
			case 0:
				System.out.println("\nFIN DEL JUEGO");
				break;
			default:
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response != 0);
		sc.close();
	}
	
	private void jugar() {
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			System.out.println("\nSeleccione una opcion:");
			System.out.println("1. Seleccionar jugador");
			System.out.println("2. Crear jugador");
			System.out.println("0. Regresar\n");
			
			response = sc.nextInt();
			switch (response) {
			case 1:
				MenuJugador.buscarJugador();
				break;
			case 2:
				MenuJugador.crearJugador();
				break;
			case 0:
				break;
			default:
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response  != 0);
	}

}