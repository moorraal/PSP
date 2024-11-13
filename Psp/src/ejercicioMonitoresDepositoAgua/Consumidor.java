package ejercicioMonitoresDepositoAgua;


public class Consumidor extends Thread {
    
    Monitor mon;
    
    Consumidor(Monitor mon){
        this.mon=mon;
    }
    
    public void run(){
        while(true){
          mon.extraerAgua();
        }
    }
}
