package com.itmyhome.thread;
/**
 * 这是一个并发测试程序
 * @author Administrator
 *
 */
public class ConcurrencyTest {

	private static final long count = 1000000000l;
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}
	
	private static void concurrency() throws InterruptedException{
		
		long start = System.currentTimeMillis();
		
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				int a = 0;
				for(long i=0;i<count;i++){
					 a += 1;
				}
			}
			
		});
		thread.start();
		int b = 0;
		for(long i=0;i<count;i++){
			 b--;
		}
		long costTime = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrency..."+costTime  + "ms,b=" +b);
	}
	
	private static void serial(){
		long start = System.currentTimeMillis();
		int a = 0;
		for(long i=0;i<count;i++){
			 a += 1;
		}
		int b = 0;
		for(long i=0;i<count;i++){
			 b--;
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.println("serial...."+costTime + "ms,b=" +b);
	}
}
