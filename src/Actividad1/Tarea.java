package Actividad1;

import java.util.concurrent.Semaphore;

/**
 * Clase hilo que incrementa un contador compartido con exclusión mutua
 * @author Jorge Da Silva
 * @author José Aceituno
 * @author Adrián Santos
 *
 */
public class Tarea extends Thread 
{
	
	//---- VARIABLES ----
	private String nombre;
	private Semaphore semáforo;
	
	/**
	 * Constructor del hilo
	 * @param nombre el nombre del hilo
	 * @param semáforo el semaforo del hilo
	 */
	public Tarea(String nombre, Semaphore semáforo)
	{
		this.nombre = nombre;
		this.semáforo = semáforo;
	}
	
	/**
	 * Método que se encarga de lanzar el hilo y ejecutarlo
	 */
	@Override
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
	
	/**
	 * Getter del nombre
	 * @return devuelve el nombre del hilo
	 */
	public String getNombre()
	{
		return nombre;
	}
}