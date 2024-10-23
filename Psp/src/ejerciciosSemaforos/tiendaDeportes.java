package ejerciciosSemaforos;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class tiendaDeportes extends Thread{
	protected static int caja1, caja2, caja3;
		public static int cajas= (int) (Math.random()*2);
		protected int id;
		protected int nAle = (int) (Math.random()*cajas);
		private static Scanner sc = new Scanner(System.in);
		private static Semaphore tienda = new Semaphore(10);
		private static Semaphore c1 = new Semaphore(1);
		private static Semaphore c2 = new Semaphore(1);
		private static Semaphore c3 = new Semaphore(1);
		
		
	
		public tiendaDeportes(int id) {
			super();
			this.id = id;
		}

		public tiendaDeportes() {
		}

		
		public void run() {
			
			try {
				tienda.acquire();
				System.out.println("El cliente " + this.id + " ha entrado a la tienda de deportes");
				Thread.sleep(3000);
				switch(cajas){
				case 0:
					c1.acquire();
					
					System.out.println("El cliente "+ this.id +" ha entrado en la caja 1");
					caja1 += (int) (Math.random()*100+1);
					Thread.sleep(3000);
					c1.release();
					System.out.println("El cliente "+ this.id +" ha salido de la caja 1");
					break;
				case 1:
					c2.acquire();
					
					System.out.println("El cliente "+ this.id +" ha entrado en la caja 2");
					caja2 += (int) (Math.random()*100+1);
					Thread.sleep(3000);
					c2.release();
					System.out.println("El cliente "+ this.id +" ha salido de la caja 2");
					break;
				case 2:
					c3.acquire();
					
					System.out.println("El cliente "+ this.id +" ha entrado en la caja 3");
					caja3 += (int) (Math.random()*100+1);
					Thread.sleep(3000);
					c3.release();
					System.out.println("El cliente "+ this.id +" ha salido de la caja 3");
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("El cliente "+this.id+" ha salido de la tienda");
			tienda.release();
		}
		
		public static void main(String[] args) {
			double clientes = 0;
			
			if(cajas==0) {
				System.out.println("Hay 1 caja abierta");
			}else if(cajas==1) {
				System.out.println("Hay 2 cajas abiertas");
			}else if(cajas==2){
				System.out.println("Hay 3 cajas abiertas");
			}else {
				System.out.println("Hay 4 cajas abiertas");
			}
			
		
			System.out.println("Cuantos clientes van a entrar en el día de hoy: ");
			clientes = sc.nextInt();

			ArrayList<Thread> hilos = new ArrayList<>();
			
			for (int i = 1; i <= clientes; i++) {
				tiendaDeportes hilo = new tiendaDeportes(i);
				hilos.add(hilo);
				hilo.start(); // Iniciar el hilo
			}

			// Opcional: Esperar a que todos los hilos terminen
			for (Thread hilo : hilos) {
				try {
					hilo.join();
				} catch (InterruptedException e) {
					System.out.println("Error al esperar al hilo.");
				}
				
			}
			System.out.println("Total de la caja1 es: " + caja1);
			System.out.println("Total de la caja2 es: " + caja2);
			System.out.println("Total de la caja3 es: " + caja3);
			System.out.println("Total de las cajas es: " + (caja1 + caja2 + caja3));
			
			
		}
		
}
