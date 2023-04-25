package com.main;

public class SynchronizationUsage implements Runnable{

	Integer i = 0;
	Integer thread = 0;	
	
	public SynchronizationUsage(Integer thread) {
		super();
		this.thread = thread;
	}

	public static void main(String[] args) {
		SynchronizationUsage s1 = new SynchronizationUsage(1);
		Thread t1 = new Thread(s1);
		t1.start();
		SynchronizationUsage s2 = new SynchronizationUsage(2);
		Thread t2 = new Thread(s2);
		t2.start();
		SynchronizationUsage s3 = new SynchronizationUsage(3);
		Thread t3 = new Thread(s3);
		t3.start();
	}

	@Override
	public void run() {
		while(i < 100)
		synchronized (i) {
			i+=1;
			System.out.println(thread+"-"+i);
		}
	}

}
