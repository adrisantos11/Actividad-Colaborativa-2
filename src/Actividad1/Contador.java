package Actividad1;

import java.util.concurrent.Semaphore;

/**
 * Clase contador de exclusión mutua
 * @author Jorge Da Silva
 * @author José Aceituno
 * @author Adrián Santos
 */
public class Contador {


	//---- VARIABLES ----
	static final  int NITER=1000000;
	static volatile int count = 0;

	/**
	 * Método main del programa
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Semaphore s = new Semaphore(1);
			
			Tarea hl= new Tarea("h1",s);
			Tarea h2= new Tarea("h2",s);
			
			//Empezamos los hilos
			hl.start();
			h2.start();
			//Juntamos los hilos
			hl.join();
			h2.join();
			
			if (count < 2 * NITER)
				System.out.println("BOOM! count es " + count + " deberia ser " + (2*NITER));
			else
				System.out.println("OK! count es " + count);
			
		} catch (InterruptedException error) 
		{
			System.err.println("Error en el main principal");
			error.printStackTrace();
		}
	}

}