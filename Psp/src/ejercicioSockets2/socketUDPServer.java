package ejercicioSockets2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class socketUDPServer {

	public static void main(String[] args) {
		DatagramSocket socket;
		try {
			System.out.println("(Servidor) Creando socket...");
			socket = new DatagramSocket(49171);
			System.out.println("(Servidor) Recibiendo datragrama...");
			
			byte[] bufferLectura = new byte[64];
			//Datagrama con un array de bytes
			DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura,bufferLectura.length);
			//Recibe un datagrama del socket
			socket.receive(datagramaEntrada);
			System.out.println("(Servidor) Enviando datagrama...");
			String respuesta = new String(bufferLectura);
			//encargado de llamar al metodo y conseguir un String que sera mayor o menor
			String respuestaEdad=menorOMayor(respuesta);
			

			
			
			byte[] mensajeEnviado = new String(respuestaEdad).getBytes();
			DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,datagramaEntrada.getAddress(),datagramaEntrada.getPort());
			//Envia un datagrama a través del socket
			socket.send(datagramaSalida);
			
			System.out.println("(Servidor) Cerrando socket...");
			socket.close();
			System.out.println("(Servidor) Socket cerrado...");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static String menorOMayor(String edad) {
		//el trim se encarga de limpiar el input String quitando espacios al principio o al final
		String respuestaLimpia = edad.trim();
		int edadNumero = Integer.parseInt(respuestaLimpia);
		
		String mayorOMenor="menor";
		
		if(edadNumero>=18) {
			mayorOMenor="mayor";
		}
		return mayorOMenor;
		
		
	}

}
