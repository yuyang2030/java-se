package concurrent;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestThreadLocalRandom {

	public static class ThreadTest implements Runnable {

		private ThreadLocalRandom localRandom;

		@Override
		public void run() {
			localRandom = ThreadLocalRandom.current();
			for (int i = 1; i < 4; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalRandom.current().nextInt());
			}
		}

	}

	public static void testRandom() {
		Random random = new Random();

	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new ThreadTest(), "t1");
		Thread t2 = new Thread(new ThreadTest(), "t2");
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		int a = 100;
	}

}
