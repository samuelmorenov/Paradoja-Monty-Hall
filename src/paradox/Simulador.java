package paradox;

public class Simulador {

	public enum SimulationMode {
		RESULTADO_FINAL, CADA_ITERACION, TODO
	}

	public void simularNVeces(SimulationMode sm, int ni) {
		for (int i = 0; i < ni; i++) {
			if(sm == SimulationMode.TODO) {
				System.out.println("WIP: Explicacion de la simulacion");
			}
			
			if(sm != SimulationMode.RESULTADO_FINAL) {
				System.out.println("WIP: Resultado de esta iteracion");
			}
		}
		
		System.out.println("WIP: Resultado final");

	}

	public void simularOpcion() {
		System.out.println("WIP...");

	}

}
