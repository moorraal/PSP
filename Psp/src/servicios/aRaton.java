package servicios;

public class aRaton {
	private String nombre;
	private int tiempoAlimentacion;

	public aRaton(String nombre, int tiempoAlimentacion) {
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {

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
		aRaton fievel = new aRaton("Fievel", 4);
		aRaton jerry = new aRaton("Jerry", 5);
		aRaton pinky = new aRaton("Pinky", 3);
		aRaton mickey = new aRaton("Mickey", 6);
		fievel.comer();
		jerry.comer();
		pinky.comer();
		mickey.comer();
		// Cada raton tienen que esperar a comer

	}
}
