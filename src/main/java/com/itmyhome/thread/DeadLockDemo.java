package com.itmyhome.thread;

public class DeadLockDemo {
	private static String A = "A";
	private static String B = "B";
	
	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}
	
	private void deadLock(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (A) {
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					synchronized (B) {
						System.out.println("cccc");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (B) {
					
					synchronized (A) {
						System.out.println("222222");
					}
				}				
			}
			
		});
		t1.start();
		t2.start();
	}
}