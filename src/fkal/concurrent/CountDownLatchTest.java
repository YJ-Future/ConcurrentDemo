package fkal.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static 	CountDownLatch c=new CountDownLatch(2);
	public CountDownLatchTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}
			
		}).start();
		c.await();
		System.out.println("3");
	}

}
