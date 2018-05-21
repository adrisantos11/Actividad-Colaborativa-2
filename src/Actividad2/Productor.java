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
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			try{
				Main.mutex.acquire();
			}catch(InterruptedException e){
				e.printStackTrace();
			}

			// REGION CRÏTICA
			Main.Buffer[prod_position] = rm.nextInt(6)+1;;
			System.out.print("\n" + "Producer PUT: " + Main.Buffer[prod_position]+ " in position " + prod_position);
					try{
						Thread.sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
			prod_position = (prod_position + 1) % (Main.Buffer.length);
			itemCount--;

	 /* FIN REGIÓN CRÏTICA */
			Main.mutex.release();
			Main.consumer_sem.release();


		}

	}
}
