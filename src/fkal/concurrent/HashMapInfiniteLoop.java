package fkal.concurrent;

import java.util.HashMap;

/**
 * hashmap死循环问题
 * @author YU
 *
 */
public class HashMapInfiniteLoop {
	
	private static HashMap<Integer,Integer> map=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					int i=1;
				}
			}
		},"test1").start();;
	}

}
