package Actividad2;

import java.util.concurrent.Semaphore;

public class Main {
	static int tamaño_Buffer = 5;
	volatile static Semaphore producer_sem = new Semaphore(tamaño_Buffer);
	volatile static Semaphore consumer_sem = new Semaphore(0);
	volatile static Semaphore mutex = new Semaphore(1);
	static int[] Buffer = new int[tamaño_Buffer];
	
	
	public static void main(String[] args) {
		Productor p1 = new Productor("Hola");
		Consumidor c1 = new Consumidor("Hola2");
		try {
			p1.start();
			c1.start();
			p1.join();
			c1.join();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}