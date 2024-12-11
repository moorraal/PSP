package ejercicioSockets2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class socketUDPCliente {

	public static void main(String[] args) {
		int edadCliente = (int) (Math.random()*25+5);
		
		String strMensaje = Integer.toString(edadCliente);
		System.out.println("La edad del cliente es "+edadCliente);
		
		//Representa un socket para el envío y recepción de datagramas
		DatagramSocket socketUDP;
		try {
			System.out.println("Cliente): Estableciendo parámetros de conexión...");
			//Proporciona la dirección IP del equipo a través del nombre
			InetAddress hostServidor = InetAddress.getByName("localhost");
			int puertoServidor = 49171;
			System.out.println("(Cliente) Creando socket...");
			socketUDP = new DatagramSocket();
			System.out.println("(Cliente) Enviando datagrama...");
			byte[] mensaje = strMensaje.getBytes();
			DatagramPacket peticion = new DatagramPacket(mensaje,mensaje.length,hostServidor,puertoServidor);
			socketUDP.send(peticion);
			
			System.out.println("(Cliente) Recibiendo datagrama...");
			byte[] buffer = new byte[64];
			DatagramPacket respuesta = new DatagramPacket(buffer,buffer.length,hostServidor,puertoServidor);
			socketUDP.receive(respuesta);
			System.out.println("(Cliente) Mensaje recibido: "+new String(buffer));
			String respuestaServidor = new String(buffer);
			esMayorOMenor(respuestaServidor);
			
			System.out.println("(Cliente) Cerrando socket...");
			socketUDP.close();
			System.out.println("(Cliente) Socket cerrado...");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void esMayorOMenor(String mayorOMenor) {
		if(mayorOMenor.equals("mayor")) {
			System.out.println("El servidor dijo que era mayor");
		}else
			System.out.println("El servidor dijo que era menor");
	}

}
