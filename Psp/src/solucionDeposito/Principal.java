package solucionDeposito;

public class Principal {
   
    public static void main(String[] args) {
        
        Monitor varCompartida=new Monitor();
        
        //Se inician ambos hilos
        new Productor(varCompartida).start(); 
        new Consumidor(varCompartida).start();
    }
    
}
