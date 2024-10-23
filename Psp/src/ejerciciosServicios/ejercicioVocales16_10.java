package ejerciciosServicios;

import java.text.StringCharacterIterator;
import java.text.CharacterIterator;

public class ejercicioVocales16_10 extends Thread {
	char letra;
	String cadena = "";
	int contador = 0;

	public int getContador() {
		return contador;
	}

	public ejercicioVocales16_10(String Text, char busca) {
		this.letra = busca;
		this.cadena = Text;
	}

	public String getCadena() {
		return cadena;
	}

	public char getLetra() {
		return letra;
	}

	public void run() {
		// Definimos iterador de la cadena.
		CharacterIterator comprueba = new StringCharacterIterator(cadena);
		System.out.println("Letra a buscar: " + this.getLetra());
		try {
			// Retardo aleatorio entre 1 segundo y 5 segundos
			Thread.sleep((long) (Math.random() * 5000) + 100);
			// Thread.sleep(2000);
			while (comprueba.current() != CharacterIterator.DONE) {
				if (comprueba.current() == this.getLetra()) {
					contador++;
				}
				comprueba.next();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El número de coincidencias de letras " + this.getLetra() + " es: " + this.getContador());
	}

	public static void main(String[] args) throws InterruptedException {
		int totalVocales = 0;
		String Texto = "opqjwehprkjnldkfjnpqiowejrlñqknweopuiqwejanklmañlkabklsdjfopiweurpeowhñajsdfnpiog";
		ejercicioVocales16_10 Primero = new ejercicioVocales16_10(Texto, 'a');
		ejercicioVocales16_10 Segundo = new ejercicioVocales16_10(Texto, 'e');
		ejercicioVocales16_10 Tercero = new ejercicioVocales16_10(Texto, 'i');
		ejercicioVocales16_10 Cuarto = new ejercicioVocales16_10(Texto, 'o');
		ejercicioVocales16_10 Quinto = new ejercicioVocales16_10(Texto, 'u');
		Primero.start();
		Segundo.start();
		Tercero.start();
		Cuarto.start();
		Quinto.start();
		// probar qué pasa si se quitan todos los join()
		// probar qué pasa si se pone sólo un join.
		Primero.join();
		Segundo.join();
		Tercero.join();
		Cuarto.join();
		Quinto.join();
		totalVocales = Primero.getContador() + Segundo.getContador() + Tercero.getContador() + Cuarto.getContador()
				+ Quinto.getContador();
		System.out.println("El numero total de vocales es: " + totalVocales);
	}
}
