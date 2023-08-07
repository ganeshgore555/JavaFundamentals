package com.main;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCordinatingUsingAtomic {

	static volatile boolean flag = false;
	static AtomicInteger value = new AtomicInteger(0);
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			while(value.get() < 100) {
				if(!flag) {
					try {
						value.incrementAndGet();
						flag = true;
					}finally {

					}
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			while(value.get() < 100) {
				if(flag) {
					try {
						System.out.println(value.get());
						flag = false;
					}finally {
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
