package Actividad1;

import java.util.concurrent.Semaphore;

public class Tarea extends Thread {
	String c;
	Semaphore s;
	public Tarea(String arg, Semaphore s1){
		c = arg;
		s = s1;
	}
	
	
	public void run()
	{
		int tmp;
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i =0; i< Contador.NITER;i++){
			tmp = Contador.count; /* copy the global count locally */
			tmp = tmp+1; /* increment the local copy */
			Contador.count = tmp;
			
		}
		s.release();
	}
}