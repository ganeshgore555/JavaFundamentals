package com.main;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Collections {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(12);
		q.add(1);
		q.add(2);
		q.add(10);
		q.add(12);
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		PriorityBlockingQueue<Integer> bq = new PriorityBlockingQueue<>();

		Thread t1 = new Thread(() -> {
			int count = 0;
			while(count < 10) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
				bq.add(randomNum);
				count++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Thread t2 = new Thread(() -> {
			int count = 0;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while(count < 10) {
				count++;
				try {
					System.out.println(bq.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.start();
	}
}
