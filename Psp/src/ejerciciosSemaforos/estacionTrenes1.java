package ejerciciosSemaforos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class estacionTrenes1 extends Thread {
    protected int nAle = (int) (Math.random()*3);
    protected int id; // idTrenPasajeros,idTrenCarga
    private static Scanner sc = new Scanner(System.in);
    private static Semaphore estacion = new Semaphore(10);
    private static Semaphore v1 = new Semaphore(1);
    private static Semaphore v2 = new Semaphore(1);
    private static Semaphore v3 = new Semaphore(1);
    private static int contadorPasajeros = 0;
    private static int contadorCarga = 0;
    protected int nAleTren = new Random().nextInt(2);
    

    public estacionTrenes1(int id) {
        this.id = id;
    }

    public void run() {
        try {
             // 0 para carga, 1 para pasajeros
            String tipoTren;
            estacion.acquire();
            if (nAleTren == 0) {
            	contadorCarga+=1;
                System.out.println("El tren de carga " + this.id + " ha entrado a la estación");
                tipoTren="carga";
                Thread.sleep(3000);
                switch (nAle) {
                case 0:
                    v1.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 1");
                    Thread.sleep(3000);
                    v1.release();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 1");
                    break;
                case 1:
                    v2.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 2");
                    Thread.sleep(3000);
                    v2.release();

                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 2");
                    break;
                case 2:
                    v3.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 3");
                    Thread.sleep(3000);
                    v3.release();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 3");
                    break;
            }
            } else {
            	contadorPasajeros+=1;
                System.out.println("El tren de pasajeros " + this.id + " ha entrado a la estación");
                Thread.sleep(3000);
                tipoTren="pasajeros";
                switch (nAle) {
                
                case 0:
                    v1.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 1");
                    
                    Thread.sleep(3000);
                    v1.release();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 1");
                    break;
                case 1:
                    v2.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 2");
                    Thread.sleep(3000);
                    v2.release();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 2");
                    break;
                case 2:
                    v3.acquire();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha entrado a la vía 3");
                    Thread.sleep(3000);
                    v3.release();
                    System.out.println("El tren de " + tipoTren + " " + this.id + " ha salido de la vía 3");
                    break;
            }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("El tren " + this.id + " ha salido de la estacion");
            estacion.release();
        }
    }

  

    public static void main(String[] args) {
        int trenes;


        System.out.println("Cuántos trenes van a entrar en el día de hoy: ");
        trenes = sc.nextInt();

        ArrayList<Thread> hilosTrenes = new ArrayList<>();



        // Crear y empezar hilos de trenes
        for (int i = 1; i <= trenes; i++) {
        	estacionTrenes1 hiloTren = new estacionTrenes1(i);
            hilosTrenes.add(hiloTren);
            hiloTren.start();
        }

       
        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilosTrenes) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar al hilo de tren.");
            }
        }


        System.out.println("Ha habido "+contadorCarga+" trenes de carga en la estacion");
        System.out.println("Ha habido "+contadorPasajeros+" trenes de pasajeros en la estacion");
    }
}
