package ejercicioSockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketTCPCliente {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private InputStream in;
	private OutputStream ou;
	
	public socketTCPCliente(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public void start () throws UnknownHostException, IOException {
		System.out.println( "(Cliente) Estableciendo conexión...");
		socket = new Socket();
		InetSocketAddress addr = new InetSocketAddress("localhost",49171);
		socket.connect(addr);
		ou = socket.getOutputStream();
		in = socket.getInputStream();
		System.out.println("(Cliente) Conexión establecida...");
	}
	
	public void stop () throws IOException {
		System.out.println( "(Cliente) Cerrando conexiones...");
		in.close();
		ou.close();
		socket.close();
		System.out.println( "(Cliente) Conexiones cerradas...");
	}
	
	public static void main(String[] args) {
		int edadCliente = (int) (Math.random()*25+5);
		//mayor indica 1 si es mayor y 0 si es menor
		int mayor;
		socketTCPCliente cliente = new socketTCPCliente("localhost", 49171);
		
		System.out.println("La edad del cliente es : "+edadCliente);
		
		try {
			
			cliente.start();
			cliente.ou.write(edadCliente);
			mayor = cliente.in.read();
			//Comprueba si es 1 es mayor de edad y si es 0 es menor
			if(mayor==1) {
				System.out.println("Es mayor de edad dicho por el servidor");
			}else {
				System.out.println("Es menor de edad dicho por el servidor");
			}
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}

