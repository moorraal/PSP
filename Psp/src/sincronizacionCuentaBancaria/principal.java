package sincronizacionCuentaBancaria;

/* Realiza una aplicación para que los alumnos de 2º de DAM puedan ingresar 
 * y retirar dinero para las gestiones de la clase.
   No se podrán solapar las tareas en el tiempo.
 * */
public class principal {
	
	
	public static void main(String[] args) throws InterruptedException {
		cuenta c1 = new cuenta("asert",45);
		
		usuario u1 = new usuario("123","Javier",c1);
		usuario u2 = new usuario("456","Maria",c1);
		usuario u3 = new usuario("789","Alfredo",c1);
		usuario u4 = new usuario("442","Miguel",c1);
		usuario u5 = new usuario("642","Bea",c1);
		usuario u6 = new usuario("938","Lorena",c1);
		usuario u7 = new usuario("756","Aaron",c1);
		usuario u8 = new usuario("127","Diego",c1);
		usuario u9 = new usuario("857","Sergio",c1);
		
		u1.start();
		u2.start();
		u4.start();
		u5.start();
		u6.start();
		u7.start();
		u8.start();
		u9.start();
		
		u1.join();
		u2.join();
		u4.join();
		u5.join();
		u6.join();
		u7.join();
		u8.join();
		u9.join();
					

	}

}