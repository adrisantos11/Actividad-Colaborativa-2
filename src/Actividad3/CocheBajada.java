package Actividad3;

public class CocheBajada extends Thread
{

	private int indice;

	public CocheBajada(int indice)
	{
		this.indice = indice;
	}

	@Override
	public void run()
	{
		try 
		{
//			Principal.puente.acquire();
			if (indice == 0)
				Principal.puente.acquire();
			
			Principal.exmut_b.acquire();
			Thread.sleep(1000);
			System.out.println("Ha bajado el coche de indice: " + indice);
			Principal.contadorBajada--;			
			Principal.exmut_b.release();
			



			//Si no quedan coches por subir, devolvemos el semáforo
			if(Principal.contadorBajada == 0)
				Principal.puente.release();

		} catch (InterruptedException error) 
		{
			System.err.println("Error al subir un coche");
			error.printStackTrace();
		}
	}

}

