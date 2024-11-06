package sincronizacionCuentaBancaria;

import java.util.Random;

public class usuario extends Thread{
	protected String dni, nombre;
	protected int cantidad;
	protected cuenta c;
	
	protected usuario(String dni, String nombre, cuenta c) {
		this.dni = dni;
		this.nombre = nombre;
		this.c = c;
	}
	protected String getDni() {
		return dni;
	}
	protected void setDni(String dni) {
		this.dni = dni;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected cuenta getC() {
		return c;
	}
	protected void setC(cuenta c) {
		this.c = c;
	}
	
	protected synchronized void ingresar(cuenta c, double cantidad) {
		try {
			Thread.sleep(3000);
			System.out.println(nombre+" ha entrado a ingresar");
			c.setSaldo(c.getSaldo()+cantidad);
			System.out.println(nombre+" ha salido de ingresar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected /*synchronized*/ void retirar(cuenta c, double cantidad) {
		try {
			Thread.sleep(3000);
			System.out.println(nombre+" ha entrado a retirar");
			c.setSaldo(c.getSaldo()-cantidad);			
			System.out.println(nombre+" ha salido de retirar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		int numAle = new Random().nextInt(2);
		if(numAle==0) {
		ingresar(c,cantidad);
		}else retirar(c,cantidad);
	}
}