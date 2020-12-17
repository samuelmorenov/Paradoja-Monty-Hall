package paradox;

public class Simulador {

	public enum SimulationMode {
		RESULTADO_FINAL, CADA_ITERACION, TODO
	}

	public void simularNVeces(SimulationMode sm, int ni) {

		int nVeces_SiCambio_SiGano = 0;
		int nVeces_SiCambio_NoGano = 0;
		int nVeces_NoCambio_SiGano = 0;
		int nVeces_NoCambio_NoGano = 0;

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
				nVeces_SiCambio_SiGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante cambio de puerta y gano");
			}
			if (cambia && eleccionFinal != puertaConPremio) {
				nVeces_SiCambio_NoGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante cambio de puerta y no gano");
			}
			if (!cambia && (eleccionFinal == puertaConPremio)) {
				nVeces_NoCambio_SiGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante no cambio de puerta y gano");
			}
			if (!cambia && !(eleccionFinal == puertaConPremio)) {
				nVeces_NoCambio_NoGano++;
				if (sm != SimulationMode.RESULTADO_FINAL)
					System.out.println("El concursante no cambio de puerta y no gano");
			}
		}

		if (sm != SimulationMode.RESULTADO_FINAL) {
			System.out.println("----");
			System.out.println("Resultado final");
		}

		String victoriasCambiando = Common.calcularPorcentaje(nVeces_SiCambio_SiGano, nVeces_SiCambio_NoGano);
		String victoriasSinCambiar = Common.calcularPorcentaje(nVeces_NoCambio_SiGano, nVeces_NoCambio_NoGano);

		System.out.println("No cambiando de puerta, el concursante gano " + nVeces_NoCambio_SiGano + " veces y perdio "
				+ nVeces_NoCambio_NoGano + " veces. Hace un porcentaje de victorias del " + victoriasSinCambiar + "%.");
		System.out.println("Cambiando de puerta, el concursante gano " + nVeces_SiCambio_SiGano + " veces y perdio "
				+ nVeces_SiCambio_NoGano + " veces. Hace un porcentaje de victorias del " + victoriasCambiando + "%.");

	}

	public void simularOpcion() {
		System.out.println("WIP...");

	}

}
