package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRandom {

	public static class TestRunnable implements Runnable {

		private Random random;

		public TestRunnable(Random random) {
			this.random = random;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println(random.nextInt());
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Random sharedRandom = new Random();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			TestRunnable runnable = new TestRunnable(sharedRandom);
			Thread thread = new Thread(runnable);
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.join();
		}

	}

}
