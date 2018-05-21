package Actividad1;

import java.util.concurrent.Semaphore;

public class Contador {
	
	
	static final  int NITER=1000000;
	static volatile int count = 0;
	
		public static void main(String[] args) throws InterruptedException {
			// T000 Auto-generated method stub
			Semaphore s = new Semaphore(1);
			System.out.print("contador");
			Tarea hl= new Tarea("h1",s);
			Tarea h2= new Tarea("h2",s);
			hl.start();
			h2.start();
			hl.join();
			h2.join();
			if (count < 2 * NITER)
				System.out.print("\n"+" BOOM! count es " + count+" deberia ser "+2*NITER);
				else
					System.out.print("\n"+" OK! count es "+ count);
	}

}