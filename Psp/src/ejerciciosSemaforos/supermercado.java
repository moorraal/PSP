package ejerciciosSemaforos;

import java.util.concurrent.Semaphore;

public class supermercado extends Thread{
	protected int contador = 0;
	protected String Persona;
	
	public int getContador() {
		return contador;
	}
	
	public supermercado(String persona) {
		super();
		Persona = persona;
	}

	private static Semaphore semaforoCaja = new Semaphore(1);
	private static Semaphore semaforoSupermercado = new Semaphore(3);
	
	public void run() {
		
			try {
				semaforoSupermercado.acquire();
				System.out.println(this.Persona+" ha entrado al supermercado");
				Thread.sleep((long)(Math.random()*6000)+100);
				semaforoCaja.acquire();
				System.out.println(this.Persona+" ha entrado a la caja a pagar");
				semaforoCaja.release();
				System.out.println(this.Persona+" ya ha pagado");
				
			
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
				
			}
			
			semaforoSupermercado.release();
			System.out.println(this.Persona+" ha salido del supermercado");
		}
	
	
	public static void main(String[] args) throws InterruptedException {
		supermercado Paco = new supermercado("Paco");
		supermercado Navazo = new supermercado("Navazo");
		supermercado Carlos = new supermercado("Carlos");
		supermercado Miguel = new supermercado("Miguel");
		supermercado Maria = new supermercado("Maria");
		supermercado Bea = new supermercado("Bea");
		supermercado Lorena = new supermercado("Lorena");
		supermercado Alejandro = new supermercado("Alejandro");
		Paco.start();
		Navazo.start();
		Carlos.start();
		Miguel.start();
		Maria.start();
		Bea.start();
		Lorena.start();
		Alejandro.start();
		Paco.join();
		Navazo.join();
		Carlos.join();
		Miguel.join();
		Maria.join();
		Bea.join();
		Lorena.join();
		Alejandro.join();
		
		
	}
}
