package Actividad3;

/**
 * Clase cocheSubida que simula el funcionamiento de los coches en la subida del puente
 * @author José Aceituno, Jorge Da Silva y Adrián Santos
 *
 */
public class CocheSubida extends Thread 
{
	
	//---------ATRIBUTOS-----------

	private int indice;
	
	
	//---------METODOS-----------

	/**
	 * Constructor de la clase cocheSubida
	 * @param indice recibe un indice de tipo entero, en este caso sera el número identificador del coche que se dispone a cruzar el puente
	 */
	public CocheSubida(int indice)
	{
		this.indice = indice;
	}
	
	/**
	 * Método que se encarga de lanzar el hilo y ejecutarlo
	 */
	@Override
	public void run()
	{
		try 
		{
			if (indice == 0)
				Principal.puente.acquire();
			
			Principal.exmut_s.acquire();
			Thread.sleep(1000);
			System.out.println("Ha subido el coche de indice: " + indice);
			Principal.contadorSubida--;			
			Principal.exmut_s.release();

			//Si no quedan coches por subir, devolvemos el semáforo
			if(Principal.contadorSubida == 0)
				Principal.puente.release();
			
		} catch (InterruptedException error) 
		{
			System.err.println("Error al subir un coche");
			error.printStackTrace();
		}
	}
	
}

