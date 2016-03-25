package fkal.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<Runnable>blockingQue=new LinkedBlockingQueue<>(5);
		ThreadPoolExecutor threadPool=new ThreadPoolExecutor(3,10,10,TimeUnit.SECONDS,blockingQue);
		
		threadPool.execute(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("run1");
			}
		});
		//threadPool.shutdownNow(); 返回List<Runnable> 没有执行完的任务列表 
		threadPool.shutdown();//调用时结束现在没有任务的线程 
	}

}
