package ejercicioMonitoresDepositoAgua;

public class Monitor {
	
	 private static int agua;
	    //private boolean hayElemento;
	    
	    Monitor(){
	        agua=0;
	        //hayElemento=false;
	    }
	
public synchronized void llenarAgua(){
    	
        while(this.agua>=1000) {
        try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        }
        if(this.agua >= 100) {
        	this.agua=agua+10;
            System.out.println("LLenando agua de 5 en 5 debido a que hay menos de 100 litros de agua: ");
            notifyAll();// Despertar el siguiente hilo
        }else if(this.agua==0) {
        this.agua=agua+10;
        System.out.println("LLenando agua de 10 en 10 debido a que hay 0 litros de agua: ");
        notifyAll();// Despertar el siguiente hilo
        }else if(this.agua>=900) {
        	 this.agua=agua+10;
             System.out.println("LLenando agua de 10 en 10 debido a que hay 900 litros de agua: ");
             notifyAll();// Despertar el siguiente hilo
        }
       
    }
public synchronized void extraerAgua(){
    while(this.agua==0){
        try{
             wait();
        }catch(Exception e){}
       
    }
    if(this.agua>=1000) {
    	this.agua=agua-10;
    	System.out.println("Vaciando agua de 10 en 10 debido a que hay mas de 1000 litros de agua");
    	notifyAll();
    /*}else if(this.agua==0) {
    	System.out.println("Vaciando agua de 5 en 5 debido a que hay mas de 900 litros de agua");
    	this.agua=agua+10;
    	 notify();*/
    }else if(this.agua>=100) {
    	System.out.println("Vaciando agua de 5 en 5 debido a que hay menos de 100 litros de agua");
    }
   
}

}
