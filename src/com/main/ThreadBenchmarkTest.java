package com.main;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadBenchmarkTest {

	public static void main(String[] args) {
		
		final AtomicInteger atomicInteger = new AtomicInteger();
		Runnable runnable = () -> {
		  try {
		    Thread.sleep(Duration.ofSeconds(1));
		  } catch(Exception e) {
		      System.out.println(e);
		  }
		  atomicInteger.incrementAndGet();
		  //System.out.println("Work Done - " + atomicInteger.incrementAndGet());
		};
		
		Instant start = Instant.now();
		
		try (var executor = Executors.newFixedThreadPool(1000)) {
		  for(int i = 0; i < 10000; i++) {
		    executor.submit(runnable);
		  }
		}

		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();  
		System.out.println("Total elapsed time : " + timeElapsed);
		
		
		Instant startVirtual = Instant.now();

		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		  for(int i = 0; i < 10000; i++) {
		    executor.submit(runnable);
		  }
		}

		Instant finishVirtual = Instant.now();
		long timeElapsedForVirtual = Duration.between(startVirtual, finishVirtual).toMillis();  
		System.out.println("Total elapsed time : " + timeElapsedForVirtual);	
	}

}
