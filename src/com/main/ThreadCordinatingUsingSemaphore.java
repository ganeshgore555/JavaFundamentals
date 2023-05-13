package com.main;

import java.util.concurrent.Semaphore;

public class ThreadCordinatingUsingSemaphore {

	static Boolean flag = false;
	static Integer value = 0;
	static Semaphore s = new Semaphore(1); 
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			while(value < 100) {
				if(!flag) {
					try {
						s.acquire();
						value++;
						flag = true;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						s.release();
					}
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			while(value < 100) {
				if(flag) {
					try {
						s.acquire();
						System.out.println(value);
						flag = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						s.release();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
