package Actividad3;

public class CocheSubida extends Thread 
{
	private int indice;

	public CocheSubida(int indice)
	{
		this.indice = indice;
	}

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

