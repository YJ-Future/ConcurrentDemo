package fkal.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	private static final Exchanger<String>exgr=new Exchanger<>();
	
	private static ExecutorService threadPool=Executors.newFixedThreadPool(2);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			threadPool.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String A="from a string";
					try {
						exgr.exchange(A);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			threadPool.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String B="from b string";
					try {
						String A=exgr.exchange(B);
						System.out.println("A和B录入的数据是否一致："+A.equals(B));
						System.out.println("A录入的数据是："+A);
						System.out.println("B录入的数据是："+B);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			threadPool.shutdown();
	}

}
