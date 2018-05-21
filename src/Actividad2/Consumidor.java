package Actividad2;

public class Consumidor extends Thread{
	String c;
	public Consumidor(String arg) {
		c = arg;
	}
	
	public void run() {
		try {
			Main.consumer_sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
