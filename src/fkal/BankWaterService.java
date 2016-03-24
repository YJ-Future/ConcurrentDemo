package fkal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
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
	private CyclicBarrier c=new CyclicBarrier(4);
	/**
	 * 假设只有4个sheet，所以只启动4个线程
	 */
	private Executor executor=Executors.newFixedThreadPool(4);
	/**
	 * 保存每个sheet计算的银行流水结果
	 */
	private ConcurrentHashMap<String,Integer>sheetBankWaterCount=new ConcurrentHashMap<String,Integer>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
