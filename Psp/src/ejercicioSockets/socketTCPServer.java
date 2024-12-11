package ejercicioSockets;

/*Ejemplo para el intercambio básico de información: el cliente envía un entero
 * con el valor 100 al servidory este le responde a su vez con otro entero con
 * el valor 200.*/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCPServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream ou;
	
	public socketTCPServer(int puerto) throws IOException {
		serverSocket = new ServerSocket();
		InetSocketAddress addr = new InetSocketAddress ("localhost",puerto);
		//Asocia el serverSocket a una direccion
		serverSocket.bind(addr);
	}
	
	public void start() throws IOException {
		System.out.println("(Servidor) Esperando conexiones...");
		
		//Una vez recibida la petición de conexión se crea el objeto socket
		socket = serverSocket.accept();
		//Flujos de entrada y salida de datos. Permiten leer bytes.
		is = socket.getInputStream();
		ou = socket.getOutputStream();
		System.out.println("(Servidor) Conexión establecida...");
	}
	
	public void stop() throws IOException {
		System.out.println("(Servidor) Cerrando conexiones...");
		is.close();
		ou.close();
		socket.close();
		serverSocket.close();
		System.out.println("(Servidor) Conexion cerrada...");
	}

	public static void main(String[] args) {
		//mayor indica 1 si es mayor y 0 si es menor
		int edad,mayor=0;
		try {
			socketTCPServer servidor = new socketTCPServer(49171);
			
			servidor.start();
			
			
			edad= servidor.is.read();
			if(edad>=18) {
				mayor=1;
			}
			//Con el método write manda el número al cliente
			servidor.ou.write(mayor);
			servidor.stop();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}

