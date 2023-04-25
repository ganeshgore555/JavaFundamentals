package com.main;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class FutureUsage implements Runnable {

	Integer thread = 0;
	public FutureUsage(Integer thread) {
		super();
		this.thread = thread;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		Supplier<Person> s = () -> {
			return new Person("Ganesh", 30);
		};		
	}

	@Override
	public void run() {
		try {
			System.out.println("Start");
			Thread.sleep(3000);
			System.out.println("End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
