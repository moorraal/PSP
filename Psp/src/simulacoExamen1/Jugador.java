package simulacoExamen1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Jugador extends Thread{
	private final int id;
    private final Carrera carrera;
    private final Semaphore semaforo;

    public Jugador(int id, Carrera carrera, Semaphore semaforo) {
        this.id = id;
        this.carrera = carrera;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            while (!carrera.hayGanador()) {
                semaforo.acquire(); // Entrar al semáforo
                carrera.mover(id);
                semaforo.release(); // Salir del semáforo
                Thread.sleep(500); // Simula tiempo entre turnos
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos jugadores van a participar en la carrera?");
        int numJugadores = sc.nextInt();

        final int META = 20;
        Carrera carrera = new Carrera(numJugadores, META);
        Semaphore semaforo = new Semaphore(5); // Solo un jugador a la vez

        // Crear y almacenar los jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador(i, carrera, semaforo);
            jugadores.add(jugador);
            jugador.start();
        }

        // Esperar a que todos los jugadores terminen
        for (Jugador jugador : jugadores) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar al jugador.");
            }
        }

        System.out.println("¡La carrera ha terminado!");
        sc.close();
    }
}
