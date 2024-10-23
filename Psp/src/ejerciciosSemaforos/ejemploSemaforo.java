package ejerciciosSemaforos;

import java.util.concurrent.Semaphore;

public class ejemploSemaforo extends Thread{
	private static int contador = 0;
	private static Semaphore semaforo = new Semaphore(1);

	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				semaforo.acquire();
				Thread.sleep((long)(Math.random()*2000)+100);
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
				
			}
			System.out.println(contador++);
			semaforo.release();
		}
	}

	public static void main(String[] args) {
		new ejemploSemaforo().start();
		new ejemploSemaforo().start();
		new ejemploSemaforo().start();
	}
}
