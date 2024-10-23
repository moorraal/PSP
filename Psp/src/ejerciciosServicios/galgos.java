package ejerciciosServicios;

import java.util.Random;

public class galgos extends Thread{
	private String nombre;
	private static int tiempoCarrera;
	
	
	public galgos(String nombre, int tiempoCarrera) {
		super();
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
		
	}
	public void run() {

		try {
			System.out.printf("El Galgo %s ha comenzado la carrera%n", nombre);
			int contador = 0;	
			Thread.sleep(tiempoCarrera * 1000);// pausa la ejecucion del hilo
			contador= contador+1;
			System.out.printf("El Galgo %s ha terminado la carrera en posicion "+contador+"%n", nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		tiempoCarrera = (int) (Math.random()*5);
		galgos fievel = new galgos("Fievel", tiempoCarrera);
		galgos jerry = new galgos("Jerry", tiempoCarrera);
		galgos pinky = new galgos("Pinky", tiempoCarrera);
		galgos mickey = new galgos("Mickey", tiempoCarrera);
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
	
	

}
