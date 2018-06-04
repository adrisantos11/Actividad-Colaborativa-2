package Actividad2;

/**
 * Clase consumidor que implementa exclusión mutua y extiende de hilo
 * @author Jorge Da Silva
 * @author José Aceituno
 * @author Adrián Santos
 * @see Thread
 *
 */
public class Consumidor extends Thread
{
	//---- VARIABLES ----
	String nombre;

	/**
	 * Constructor del hilo
	 * @param nombre el nombre del hilo
	 */
	public Consumidor(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Método que se encarga de lanzar el hilo y ejecutarlo
	 */
	public void run() 
	{

		int itemCount = 10; 
		int prod_position = 0;

		while (itemCount > 0) 
		{
			try 
			{
				//Inicio de la sección crítica
				Main.consumer_sem.acquire();
				Main.mutex.acquire();

				System.out.println("Consumidor lee "+ Main.Buffer[prod_position]+" en la posición " + prod_position); 

				Thread.sleep(250); 

				if(prod_position>Main.tamaño_Buffer)
					prod_position=0;
				else
				{
					prod_position = (prod_position + 1) % Main.tamaño_Buffer; 
					itemCount--;
				}

				// FIN REGIÓN CÍTICA 

				Main.mutex.release();
				Main.producer_sem.release();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}