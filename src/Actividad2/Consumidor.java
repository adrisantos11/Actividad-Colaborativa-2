package Actividad2;

import java.util.Random;

public class Consumidor extends Thread{
	String c;
	public Consumidor(String arg) {
		c = arg;
	}

	public void run() {

		int itemCount = 10; 
		Random rm = new Random(); 
		int prod_position = 0; 
		while (itemCount > 0) {
			try {
				Main.consumer_sem.acquire();
				Main.mutex.acquire();

				//				Main.Buffer[prod_position] =rm.nextInt(6)+1;
				System.out.println("Consumidor lee "+ Main.Buffer[prod_position]+" en la posición " + prod_position); 

				try{ 
					Thread.sleep(250); 
				}catch(InterruptedException e){ 
					e.printStackTrace(); 
				} 

				if(prod_position>Main.tamaño_Buffer)
					prod_position=0;
				else {
					prod_position = (prod_position + 1) % Main.tamaño_Buffer; 
					itemCount--;
				}

				/* FIN REGIÓN CÍTICA */ 

				Main.mutex.release();
				Main.producer_sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();





			}
		}
	}
}