package Actividad3;

import java.util.concurrent.Semaphore;

/**
 * Clase Principal, que se encarga de ejecutar el programa
 * @author José Aceituno, Jorge Da Silva y Adrián Santos
 *
 */
public class Principal 
{
	
	//---------ATRIBUTOS-----------
	
	public volatile static int contadorSubida = 0;
	public volatile static int contadorBajada = 0;
	
	public static Semaphore puente;
	public static Semaphore exmut_s;
	public static Semaphore exmut_b;
	
	
	
	//---------MAIN-----------
	
	public static void main(String[] args)
	{
		//Inicializamos los semáforos a 1
		try 
		{
			contadorSubida = 5;
			contadorBajada = 8;
			
			puente  = new Semaphore(1);
			exmut_s = new Semaphore(contadorSubida);
			exmut_b = new Semaphore(contadorBajada);
			
			CocheSubida[] cochesSubida = new CocheSubida[contadorSubida];
			for (int i = 0; i < contadorSubida; i++)
			{
				cochesSubida[i] = new CocheSubida(i);
				
			}
			
			CocheBajada[] cochesBajada = new CocheBajada[contadorBajada];
			for (int i = 0; i < contadorBajada; i++)
			{
				cochesBajada[i] = new CocheBajada(i);
				
			}
			
			System.out.println("Hay: " + cochesSubida.length + " coches por subir");
			System.out.println("Hay: " + cochesBajada.length + " coches por bajar");
			
			
			for (int i = 0; i < cochesBajada.length; i++)
			{
				cochesBajada[i].run();
				cochesBajada[i].join();
			}
			
			for (int i = 0; i < cochesSubida.length; i++)
			{
				cochesSubida[i].run();
				cochesSubida[i].join();

			}
		} catch (InterruptedException error) 
		{
			System.err.println("Error en el main");
			error.printStackTrace();
		}

	}

}
