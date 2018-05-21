package Actividad2;

import java.util.concurrent.Semaphore;

public class Main {
	static Semaphore producer_sem = new Semaphore(5);
	static Semaphore consumer_sem = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);
	static int[] Buffer = new int[5];
	
	
	public static void main(String[] args) throws InterruptedException {
		Productor p1 =new Productor("Juan");
		Consumidor c1 = new Consumidor("Pablo");
		
		p1.start();
		c1.start();
		
		p1.join();
		c1.join();
	}

}
