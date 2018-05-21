package Actividad2;

import java.util.concurrent.Semaphore;

public class Main {
	static Semaphore producer_sem = new Semaphore(5);
	static Semaphore consumer_sem = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);
	static int[] Buffer = new int[5];
	
	
	public static void main(String[] args) {
		
	}

}
