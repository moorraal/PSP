package simulacoExamen1;

import java.util.Random;

public class Carrera {
	   private int turno = 0; // Turno del jugador actual
	    private final int[] posiciones; // Posiciones de los jugadores
	    private final int meta; // Meta de la carrera
	    private boolean hayGanador = false;

	    public Carrera(int numJugadores, int meta) {
	        this.meta = meta;
	        this.posiciones = new int[numJugadores];
	    }

	    public synchronized void mover(int jugador) {
	        while (jugador != turno && hayGanador) {
	            try {
	                wait(); // Espera su turno
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        // Tirar el dado y mover
	        int dado = new Random().nextInt(6) + 1;
	        posiciones[jugador] += dado;
	        System.out.println("Jugador " + jugador + " avanza " + dado + " casillas. Posición actual: " + posiciones[jugador]);

	        // Verificar si hay ganador
	        if (posiciones[jugador] >= meta) {
	            hayGanador = true;
	            System.out.println("¡Jugador " + jugador + " gana la carrera!");
	        }

	        // Cambiar turno
	        turno = (turno + 1) % posiciones.length;
	        notifyAll(); // Notifica a los demás jugadores
	    }

	    public boolean hayGanador() {
	        return hayGanador;
	    }
	}

