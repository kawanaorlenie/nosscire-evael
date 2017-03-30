package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
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
			lower.pickUp(id);
			higher.pickUp(id);
			System.out.println(id);
			eaten = true;
			higher.putDown(id);
			lower.putDown(id);
		}

	}
}

class Fork {

	private int id;
	private Lock lock = new ReentrantLock();

	public Fork(int id) {
		this.id = id;
	}

	public synchronized void pickUp(int philosopherId) {
		lock.lock();
		System.out.println("philosopher " + philosopherId + " picked up fork " + id);
	}

	public synchronized void putDown(int philosopherId) {
		System.out.println("philosopher " + philosopherId + " put down fork " + id);
		lock.unlock();
	}

	public int getId() {
		return this.id;
	}
}
