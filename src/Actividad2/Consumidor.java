package Actividad2;

public class Consumidor extends Thread{
	String c;
	public Consumidor(String arg) {
		c = arg;
	}
	
	public void run() {
		int itemCount = 0;
		
		if (Main.Buffer[itemCount] != 0) {
			try {
				Main.consumer_sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Main.mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println("Consumidor consume: " + Main.Buffer[itemCount] + " en posición " + itemCount);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			} else {
				itemCount++;
				Main.mutex.release();
				Main.producer_sem.release();
		}			
	}
}
