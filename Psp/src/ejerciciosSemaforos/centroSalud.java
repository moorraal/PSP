package ejerciciosSemaforos;

import java.util.concurrent.Semaphore;

public class centroSalud extends Thread{
	protected String Persona;
	protected int numeroSala = (int) (Math.random()*3);
	

	
	public centroSalud(String persona) {
		super();
		Persona = persona;
	}

	private static Semaphore semaforoSala = new Semaphore(1);
	private static Semaphore semaforoSala2 = new Semaphore(1);
	private static Semaphore semaforoSala3 = new Semaphore(1);
	private static Semaphore semaforoCentro = new Semaphore(3);

	
	public void run() {
		
			try {
				semaforoCentro.acquire();
				System.out.println(this.Persona+" ha entrado en el Hospital");
				Thread.sleep((long)(Math.random()*8000)+100);
				System.out.println(this.Persona +" : "+this.numeroSala);
				switch(this.numeroSala){
				case 0:
					semaforoSala.acquire();
					System.out.println(this.Persona+" ha entrado en la sala de Pediatria");
					Thread.sleep((long)(Math.random()*8000)+100);	
					semaforoSala.release();
					System.out.println(this.Persona+" ha salido de la sala de Pediatria");
				case 1:
					semaforoSala2.acquire();
					System.out.println(this.Persona+" ha entrado en la sala de Cardiologia");
					Thread.sleep((long)(Math.random()*8000)+100);
					semaforoSala2.release();
					System.out.println(this.Persona+" ha salido de la sala de Cardiologia");
					break;
				case 2:
					semaforoSala3.acquire();
					System.out.println(this.Persona+" ha entrado en la sala de Cuidados Intensivos");
					Thread.sleep((long)(Math.random()*8000)+100);
					semaforoSala3.release();
					System.out.println(this.Persona+" ha salido de la sala de Cuidados Intensivos");
					break;
				}
				
				
			
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
				
			}
			System.out.println(this.Persona+" ha salido del Hospital");
			semaforoCentro.release();
			
		}
	
	
	public static void main(String[] args) throws InterruptedException {
		centroSalud Paco = new centroSalud("Paco");
		centroSalud Navazo = new centroSalud("Navazo");
		centroSalud Carlos = new centroSalud("Carlos");
		centroSalud Miguel = new centroSalud("Miguel");
		centroSalud Maria = new centroSalud("Maria");
		centroSalud Bea = new centroSalud("Bea");
		centroSalud Lorena = new centroSalud("Lorena");
		centroSalud Alejandro = new centroSalud("Alejandro");
		centroSalud Aaron = new centroSalud("Aaron");
		centroSalud Pablo = new centroSalud("Pablo");
		centroSalud David = new centroSalud("David");
		Paco.start();
		Navazo.start();
		Carlos.start();
		Miguel.start();
		Maria.start();
		Bea.start();
		Lorena.start();
		Alejandro.start();
		Aaron.start();
		Pablo.start();
		David.start();
		Paco.join();
		Navazo.join();
		Carlos.join();
		Miguel.join();
		Maria.join();
		Bea.join();
		Lorena.join();
		Alejandro.join();
		Aaron.join();
		Pablo.join();
		David.join();
		
		
	}
}
