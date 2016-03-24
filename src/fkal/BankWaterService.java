package fkal;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author fkal
 *
 */
public class BankWaterService implements Runnable {
	
	/**
	 * 创建4个屏障，处理完之后执行当前类的run方法
	 */
	private CyclicBarrier c=new CyclicBarrier(4,this);
	/**
	 * 假设只有4个sheet，所以只启动4个线程
	 */
	private ExecutorService executor=Executors.newFixedThreadPool(4);
	/**
	 * 保存每个sheet计算的银行流水结果
	 */
	private ConcurrentHashMap<String,Integer>sheetBankWaterCount=new ConcurrentHashMap<String,Integer>();
	
	private void count(){
		for(int i=0;i<4;i++){
			executor.execute(new Runnable(){

				@Override
				public void run() {
					// 计算当前sheet的银行流水数据
					sheetBankWaterCount.put(Thread.currentThread().getName(),1);
					try {
						c.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int result=0;
		for(Entry<String,Integer>sheet:sheetBankWaterCount.entrySet()){
			result+=sheet.getValue();
		}
		//输出结果
		sheetBankWaterCount.put("result",result);
		System.out.println("count="+result);
		executor.shutdown();
	}
	public static void main(String []args){
		BankWaterService bankWaterCount=new BankWaterService();
		bankWaterCount.count();
	}
}
