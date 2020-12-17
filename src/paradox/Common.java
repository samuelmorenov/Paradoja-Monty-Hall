package paradox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

}
