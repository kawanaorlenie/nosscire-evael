package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophers {

/*	public static void main(String[] args) {
		int philosophersCount = 5;
		List<Fork> forks = new ArrayList<>();

		for (int i = 0; i < philosophersCount; i++) {
			forks.add(new DiningPhilosophers().new Fork(i));
		}

		ExecutorService es = Executors.newFixedThreadPool(philosophersCount);

		for (int i = 0; i < philosophersCount; i++) {
			es.submit(
					new DiningPhilosophers().new Philosopher(i, forks.get(i), forks.get((i + 1) % philosophersCount)));
		}

		if (es != null) {
			es.shutdown();
		}
	}*/

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
				if (lower.pickUp(id)) {
					while (!higher.pickUp(id)) {
					}
					System.out.println(id);
					eaten = true;
					higher.putDown(id);
					lower.putDown(id);
				}
			}
		}

	}

	class Fork {

		private int id;
		private int philosopherId = -1;

		public Fork(int id) {
			this.id = id;
		}

		public synchronized boolean pickUp(int philosopherId) {
			if (this.philosopherId < 0) {
				this.philosopherId = philosopherId;
				System.out.println("philosopher " + philosopherId + " picked up fork " + id);
				return true;
			}
			return false;
		}

		public synchronized boolean putDown(int philosopherId) {
			if (this.philosopherId >= 0) {
				this.philosopherId = -1;
				System.out.println("philosopher " + philosopherId + " put down fork " + id);
				return true;
			}
			return false;
		}

		public int getId() {
			return this.id;
		}
	}
}
