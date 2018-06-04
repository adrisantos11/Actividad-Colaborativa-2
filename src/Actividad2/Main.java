package Actividad2;

import java.util.concurrent.Semaphore;

/**
 * Clase main del programa que se encarga de mostrar las funcionalides de consumidor-productor
 * @author Jorge Da Silva
 * @author José Aceituno
 * @author Adrían Santos
 *
 */
public class Main 
{
	
	//---- VARIABLES ----
	static int tamaño_Buffer = 5;
	volatile static Semaphore producer_sem = new Semaphore(tamaño_Buffer);
	volatile static Semaphore consumer_sem = new Semaphore(0);
	volatile static Semaphore mutex = new Semaphore(1);
	static int[] Buffer = new int[tamaño_Buffer];
	
	
	/**
	 * Main del programa
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Productor p1 = new Productor("Hola");
		Consumidor c1 = new Consumidor("Hola2");
		try 
		{
			//Empezamos los hilos
			p1.start();
			c1.start();
			//Juntamos los hilos
			p1.join();
			c1.join();
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.err.println(e);
		}
	}

}