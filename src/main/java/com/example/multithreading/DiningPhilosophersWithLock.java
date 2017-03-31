package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersWithLock {

	public static void main(String[] args) {
		int philosophersCount = 5;
		List<Fork> forks = new ArrayList<>();

		for (int i = 0; i < philosophersCount; i++) {
			forks.add(new Fork(i));
		}

		ExecutorService es = Executors.newFixedThreadPool(philosophersCount);

		for (int i = 0; i < philosophersCount; i++) {
			es.submit(new Philosopher(i, forks.get(i), forks.get((i + 1) % philosophersCount)));
		}

		if (es != null) {
			es.shutdown();
		}
	}
}

class Philosopher implements Runnable {

	private int id;
	private Fork lower;
	private Fork higher;

	public Philosopher(int id, Fork left, Fork right) {
		this.id = id;
		this.lower = left.getId() > right.getId() ? right : left;
		this.higher = left.getId() > right.getId() ? left : right;
	}

	@Override
	public void run() {
		boolean eaten = false;
		while (!eaten) {
			lower.lock();
			try {
				System.out.println("philosopher " + id + " picked up fork " + lower.getId());
				higher.lock();
				try {
					System.out.println("philosopher " + id + " picked up fork " + higher.getId());
					System.out.println("philosopher " + id + " is eating");
					try {
						Thread.sleep((long) (100 * Math.random()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					eaten = true;
					System.out.println("philosopher " + id + " put down fork " + higher.getId());
				} finally {
					higher.unlock();
				}
				System.out.println("philosopher " + id + " put down fork " + lower.getId());
			} finally {
				lower.unlock();
			}

		}
	}
}

class Fork extends ReentrantLock {

	private int id;

	public Fork(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
