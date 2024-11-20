package solucionDeposito;
public class Monitor {
        
    private static int nivel; //Nivel del dep�sito
    boolean vaciando; //False si est� llenando, True si est� vaciando.
    int nivel_maximo=1000; // Dep�sito lleno
    int nivel_minimo=0; // Dep�sito vacio
    
    Monitor()
    {
        nivel=nivel_minimo; // Se vac�a el dep�sito
        vaciando=false; // Se comienza llenando el dep�sito
    }
    
      public synchronized void insertarElemento()
      {
      if (!vaciando) //Mientras se est� llenando el dep�sito
        {
        nivel=nivel+10; // Se van a�adiendo de 10 en 10 litros
      	System.out.println("A�adiendo 10 litros, Nivel: "+nivel);
       if (nivel>=nivel_maximo) // Si se llega al nivel m�ximo
          {
              try{
                	System.out.println("Se para el llenado ");
                 	vaciando=true; // Se invierte el sentido y se comienza a vaciar r�pidamente
                   wait(); // Se detiene el llenado
              }catch(Exception e){}
          }
          else if (nivel==900) // Si se llega al nivel 900
            {
                notify(); // Se despierta al proceso de vaciado
            }
        }
      else if (nivel<=100) // Si se est� vaciando el deposito y se llega al nivel 100 o menos
        {
        	nivel=nivel+5; // Se comienza a llenar lentamente.
        	System.out.println("A�adiendo 5 litros, Nivel: "+nivel);
        }
        

        }
    
    
    public synchronized void extraerElemento()
    {
        if (vaciando)  //Mientras se est� vaciando el dep�sito
        {
        nivel=nivel-10; // Se van extrayendo de 10 en 10 litros
        System.out.println("Extrayendo 10 litros, Nivel: "+nivel);
          if (nivel<=nivel_minimo) // Si se llega al nivel m�nimo
          {
              try{
                	System.out.println("Se para el vaciado ");
                 	vaciando=false; // Se invierte el sentido y se comienza a llenar r�pidamente
                   wait(); // Se detiene el vaciado
              }catch(Exception e){}
          }
          else if (nivel==100) // Si se llega al nivel 100
            {
                notify(); // Se despierta al proceso de llenado
            }
        }
      else if (nivel>=900) // Si se est� llenando el deposito y se llega al nivel 900 o mas
        {
        	nivel=nivel-5; // Se comienza a vaciar lentamente.
        	System.out.println("Extrayendo 5 litros, Nivel: "+nivel);
        } 
    }
    
}
