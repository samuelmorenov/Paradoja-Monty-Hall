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

		for (int cambia = 0; cambia <= 1; cambia++) {

			for (int i = 0; i < ni; i++) {

				int puertaConPremio = Common.generateDoor();
				int eleccionDelConcursante = Common.generateDoor();
				int eleccionFinal = eleccionDelConcursante;
				int puertaAbierta = 0;

				for (int j = 0; j < 3; j++) {
					if ((j != eleccionDelConcursante) && (j != puertaConPremio)) {
						puertaAbierta = j;
					}
				}

				if (cambia == 1) {
					for (int j = 0; j < 3; j++) {
						if ((j != eleccionDelConcursante) && (j != puertaAbierta)) {
							eleccionFinal = j;
						}
					}
				}

				if (sm == SimulationMode.TODO) {
					System.out.println("----");
					System.out.println("Iteracion numero: " + i);
					System.out.println("Las puertas son las siguientes: ");
					Common.printDoor(puertaConPremio);
					System.out.println("El concursante elije la puerta: " + eleccionDelConcursante);
					System.out.println("El presentador abre la puerta: " + puertaAbierta);
					if (cambia == 1) {
						System.out.println("El concursante decide cambiar de la puerta "+eleccionDelConcursante+" a la puerta "+eleccionFinal);
					}
					else {
						System.out.println("El concursante se queda con la puerta "+eleccionFinal);
					}
				}

				if ((cambia == 1) && (eleccionFinal == puertaConPremio)) {
					vecesQueCambioYGano++;
					if (sm != SimulationMode.RESULTADO_FINAL)
						System.out.println("El concursante cambio de puerta y gano");
				}
				if ((cambia == 1) && !(eleccionFinal == puertaConPremio)) {
					vecesQueCambioYNoGano++;
					if (sm != SimulationMode.RESULTADO_FINAL)
						System.out.println("El concursante cambio de puerta y no gano");
				}
				if (!(cambia == 1) && (eleccionFinal == puertaConPremio)) {
					vecesQueNoCambioYGano++;
					if (sm != SimulationMode.RESULTADO_FINAL)
						System.out.println("El concursante no cambio de puerta y gano");
				}
				if (!(cambia == 1) && !(eleccionFinal == puertaConPremio)) {
					vecesQueNoCambioYNoGano++;
					if (sm != SimulationMode.RESULTADO_FINAL)
						System.out.println("El concursante no cambio de puerta y no gano");
				}

			}
		}

		if (sm != SimulationMode.RESULTADO_FINAL) {
			System.out.println("----");
			System.out.println("Resultado final");
		}
		
		int porcentajeVictoriasCambiando = (vecesQueCambioYGano*100)/ni;
		int porcentajeVictoriasNoCambiando = (vecesQueNoCambioYGano*100)/ni;
		
		System.out.println("No cambiando de puerta el concursante gano " + vecesQueNoCambioYGano + " veces y perdio "
				+ vecesQueNoCambioYNoGano + " veces. Un total del "+ porcentajeVictoriasNoCambiando + "%.");
		System.out.println("Cambiando de puerta el concursante gano " + vecesQueCambioYGano + " veces y perdio "
				+ vecesQueCambioYNoGano + " veces. Un total del "+ porcentajeVictoriasCambiando + "%.");


	}

	public void simularOpcion() {
		System.out.println("WIP...");

	}

}
