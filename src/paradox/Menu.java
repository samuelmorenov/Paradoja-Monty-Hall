package paradox;

import paradox.Simulador.SimulationMode;

public class Menu {

	private Simulador s = new Simulador();

	public void run() {

		boolean loop = true;
		while (loop) {
			System.out.println("Opciones:");
			System.out.println("0. Terminar programa.");
			System.out.println("1. Simular un numero n de veces.");
			System.out.println("2. Simular una opcion elegida.");

			int option = Common.readInt();

			switch (option) {
			case 0:
				loop = false;
				break;
			case 1:
				printNTimesMenu();
				break;
			case 2:
				s.simularOpcion();
				break;
			default:
				System.out.println("Escriba un opcion correcta");
			}
		}
	}

	public void printNTimesMenu() {

		// Numero de veces
		int numberOfIterarions = 0;
		while (!(numberOfIterarions > 0 && numberOfIterarions <= 2000000000)) {
			System.out.print("Escriba el numero de veces que desea simular: ");
			numberOfIterarions = Common.readInt();
		}

		// Opciones de Interfaz

		System.out.println("Elija que mostrar en la simulacion:");
		System.out.println("1. Todo el texto.");
		System.out.println("2. El resultado de cada iteracion.");
		System.out.println("3. Solo el resultado final.");

		SimulationMode simulationMode = SimulationMode.RESULTADO_FINAL;

		boolean loop = true;
		while (loop) {
			int option = Common.readInt();
			switch (option) {
			case 1:
				simulationMode = SimulationMode.TODO;
				loop = false;
				break;
			case 2:
				simulationMode = SimulationMode.CADA_ITERACION;
				loop = false;
				break;
			case 3:
				simulationMode = SimulationMode.RESULTADO_FINAL;
				loop = false;
				break;
			default:
				System.out.println("Escriba un opcion correcta");
			}
		}

		// Llamada al simulador
		s.simularNVeces(simulationMode, numberOfIterarions);

	}

}
