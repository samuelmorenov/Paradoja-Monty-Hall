package paradox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	public void run() {
		Simulador s = new Simulador();
		boolean loop = true;

		while (loop) {
			int option = printMenu();
			switch (option) {
			case 0:
				loop = false;
				break;
			case 1:
				s.simularNVeces();
				break;
			case 2:
				s.simularOpcion();
				break;
			default:
				System.out.println("Escriba un opcion correcta");
			}
		}
	}

	private int printMenu() {

		System.out.println("Opciones:");
		System.out.println("0. Terminar programa.");
		System.out.println("1. Simular un numero n de veces.");
		System.out.println("2. Simular una opcion elegida.");
		return readInt();

	}

	private int readInt() {
		boolean readed = false;
		int data = 0;
		while (!readed) {
			System.out.print("> ");
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				data = Integer.parseInt(reader.readLine());
				readed = true;
			} catch (IOException e) {
				System.out.println("Error de lectura, escribalo de nuevo");
			}
		}
		return data;
	}
}
