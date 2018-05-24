package Actividad2;

import java.util.Random;

public class Productor extends Thread{
	String c;
	public Productor(String arg){
		c = arg;
	}

	public void run()
	{

		int itemCount = 10;
		Random rm = new Random();
		int prod_position = 0;

		while(itemCount > 0)
		{
			try{
				Main.producer_sem.acquire();
				Main.mutex.acquire();

				// REGION CRÍTICA
				Main.Buffer[prod_position] = rm.nextInt(6)+1;;
				System.out.println("El productor inicializa un: " + Main.Buffer[prod_position]+ " en la posición " + prod_position);
				try 
				{
					Thread.sleep(500);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				if(prod_position > Main.tamaño_Buffer)
					prod_position = 0;
				else {
					prod_position = (prod_position + 1) % (Main.tamaño_Buffer);
					itemCount--;
				}
				/* FIN REGIÓN CRÏTICA */
				Main.mutex.release();
				Main.consumer_sem.release();

			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}
	}
}