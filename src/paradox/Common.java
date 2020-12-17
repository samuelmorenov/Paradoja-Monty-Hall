package paradox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Common {
	
	public static int readInt() {
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

	public static int generateDoor() {
		int minimum = 1;
		int maximum = 3;
		int randomNum = minimum + (int)(Math.random() * maximum);
		return randomNum;
	}
	
	public static boolean generateBool() {
		return Math.random() < 0.5;
	}
	
	public static void printDoor(int door) {
		switch (door) {
		case 1:
			System.out.println("[ X ] [ - ] [ - ]");
			break;
		case 2:
			System.out.println("[ - ] [ X ] [ - ]");
			break;
		case 3:
			System.out.println("[ - ] [ - ] [ X ]");
			break;

		default:
			break;
		}
	}
	
	public static String calcularPorcentaje(int siGano, int noGano) {
		
		float fsiGano = (float) siGano;
		float fnoGano = (float) noGano;
		
		
		float porcentajeVictoriasCambiando = (fsiGano * 100) / (fsiGano + fnoGano);
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		return df.format(porcentajeVictoriasCambiando);
		
	}

}
