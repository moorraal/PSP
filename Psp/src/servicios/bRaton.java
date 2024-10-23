package servicios;

public class bRaton extends Thread{
	private String nombre;
	private int tiempoAlimentacion;

	public bRaton(String nombre, int tiempoAlimentacion) {
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void run() {

		try {
			System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);// pausa la ejecucion del hilo
			System.out.printf("El raton %s ha terminado de alimentarse%n", nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		bRaton fievel = new bRaton("Fievel", 4);
		bRaton jerry = new bRaton("Jerry", 5);
		bRaton pinky = new bRaton("Pinky", 3);
		bRaton mickey = new bRaton("Mickey", 6);
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
		// Cada raton comienza a comer de inmediato

	}
}
