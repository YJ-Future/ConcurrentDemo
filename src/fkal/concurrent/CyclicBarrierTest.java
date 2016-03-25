package fkal.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	static CyclicBarrier c=new CyclicBarrier(2,new A());
	
	public static void main(String []args){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(2);
			}
			
		}).start();
		
		try {
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(1);
		
	}
	
	private static class A implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(3);
		}
		
	}
	
	
}
