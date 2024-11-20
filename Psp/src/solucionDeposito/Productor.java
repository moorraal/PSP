package solucionDeposito;
public class Productor extends Thread{
 
    Monitor mon;
    
    Productor(Monitor mon){
        this.mon=mon;
    }
    public void run(){
    	 while(true){ 
    		 try {
         		Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             mon.insertarElemento();
         }
    }
}
