package paradox;

public class Simulador {

	public enum SimulationMode {
		RESULTADO_FINAL, CADA_ITERACION, TODO
	}

	public void simularNVeces(SimulationMode sm, int ni) {

		int vecesQueCambioYGano = 0;
		int vecesQueCambioYNoGano = 0;
		int vecesQueNoCambioYGano = 0;
		int vecesQueNoCambioYNoGano = 0;

		for (int i = 0; i < ni; i++) {

			int puertaConPremio = Common.generateDoor();
			int eleccionDelConcursante = Common.generateDoor();
			int eleccionFinal = 10;
			int puertaAbierta = 10;

			for (int j = 1; j <= 3; j++) {
				if ((j != eleccionDelConcursante) && (j != puertaConPremio)) {
					puertaAbierta = j;
				}
			}

			boolean cambia = Common.generateBool();

			if (cambia) {
				for (int k = 1; k <= 3; k++) {
					if ((k != eleccionDelConcursante) && (k != puertaAbierta)) {
						eleccionFinal = k;
					}
				}

			} else {
				eleccionFinal = eleccionDelConcursante;
			}

			if (sm == SimulationMode.TODO) {
				System.out.println("----");
				System.out.println("Iteracion numero: " + i);
				System.out.println("Las puertas son las siguientes: ");
				Common.printDoor(puertaConPremio);
				System.out.println("El concursante elije la puerta: " + eleccionDelConcursante);
				System.out.println("El presentador abre la puerta: " + puertaAbierta);
				if (cambia) {
					System.out.println("El concursante decide cambiar de la puerta " + eleccionDelConcursante
							+ " a la puerta " + eleccionFinal);
				} else {
					System.out.println("El concursante se queda con la puerta " + eleccionFinal);
				}
			}

			if (cambia && (eleccionFinal == puertaConPremio)) {
				vecesQueCambioYGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante cambio de puerta y gano");
			}
			if (cambia && eleccionFinal != puertaConPremio) {
				vecesQueCambioYNoGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante cambio de puerta y no gano");
			}
			if (!cambia && (eleccionFinal == puertaConPremio)) {
				vecesQueNoCambioYGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante no cambio de puerta y gano");
			}
			if (!cambia && !(eleccionFinal == puertaConPremio)) {
				vecesQueNoCambioYNoGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante no cambio de puerta y no gano");
			}

		}

		if (sm != SimulationMode.RESULTADO_FINAL) {
			System.out.println("----");
			System.out.println("Resultado final");
		}

		int porcentajeVictoriasCambiando = (vecesQueCambioYGano * 100) / (vecesQueCambioYGano + vecesQueCambioYNoGano);
		int porcentajeVictoriasNoCambiando = (vecesQueNoCambioYGano * 100)
				/ (vecesQueNoCambioYGano + vecesQueNoCambioYNoGano);

		System.out.println("No cambiando de puerta, el concursante gano " + vecesQueNoCambioYGano + " veces y perdio "
				+ vecesQueNoCambioYNoGano + " veces. Hace un porcentaje de victorias del " + porcentajeVictoriasNoCambiando + "%.");
		System.out.println("Cambiando de puerta, el concursante gano " + vecesQueCambioYGano + " veces y perdio "
				+ vecesQueCambioYNoGano + " veces. Hace un porcentaje de victorias del " + porcentajeVictoriasCambiando + "%.");

	}

	public void simularOpcion() {
		System.out.println("WIP...");

	}

}
