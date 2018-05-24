package Actividad1;

import java.util.concurrent.Semaphore;

public class Tarea extends Thread 
{
	
	private String nombre;
	private Semaphore semáforo;
	
	public Tarea(String nombre, Semaphore semáforo)
	{
		this.nombre = nombre;
		this.semáforo = semáforo;
	}
	
	
	public void run()
	{
		try 
		{
			int tmp;
			semáforo.acquire();
			for (int i =0; i< Contador.NITER;i++){
				tmp = Contador.count; /* copy the global count locally */
				tmp = tmp+1; /* increment the local copy */
				Contador.count = tmp;
				
			}
			
			semáforo.release();
		} catch (InterruptedException e) 
		{
			System.err.println("Error en: " + getClass().getName());
			e.printStackTrace();
		}
		
	}
}