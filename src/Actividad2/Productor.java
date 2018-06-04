package Actividad2;

import java.util.Random;

/**
 * Clase productor que implementa exclusión mutua y extiende de hilo
 * @author Jorge Da Silva
 * @author José Aceituno
 * @author Adrián Santos
 * @see Thread
 *
 */
public class Productor extends Thread
{
	//---- VARIABLES ----
	String nombre;

	/**
	 * Constructor del hilo
	 * @param nombre el nombre del hilo
	 */
	public Productor(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Método que se encarga de lanzar el hilo y ejecutarlo
	 */
	public void run()
	{

		int itemCount = 10;
		Random rm = new Random();
		int prod_position = 0;

		while(itemCount > 0)
		{
			try
			{
				// REGION CRÍTICA
				Main.producer_sem.acquire();
				Main.mutex.acquire();

				Main.Buffer[prod_position] = rm.nextInt(6)+1;;
				System.out.println("El productor inicializa un: " + Main.Buffer[prod_position]+ " en la posición " + prod_position);

				Thread.sleep(500);

				if(prod_position > Main.tamaño_Buffer)
					prod_position = 0;
				else 
				{
					prod_position = (prod_position + 1) % (Main.tamaño_Buffer);
					itemCount--;
				}
				// FIN REGIÓN CRÏTICA 
				Main.mutex.release();
				Main.consumer_sem.release();

			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}
}