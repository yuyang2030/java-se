package concurrent;

import java.util.concurrent.ThreadLocalRandom;

public class TestFalseUseOfThreadLocalRandom {

	public static class Run1 implements Runnable {
		ThreadLocalRandom localRandom;
		public Run1(ThreadLocalRandom localRandom) {
			this.localRandom = localRandom;
		}
		@Override
		public void run() {
			System.out.println(localRandom.nextInt());
		}
	}

	public static class Run2 implements Runnable {
		ThreadLocalRandom localRandom = ThreadLocalRandom.current();
		@Override
		public void run() {
			System.out.println(localRandom.nextInt());
		}
	}

	public static class Run3 implements Runnable {
		ThreadLocalRandom localRandom;
		@Override
		public void run() {
			localRandom = ThreadLocalRandom.current();
			System.out.println(localRandom.nextInt());
		}
	}

	public static class Run4 implements Runnable {
		@Override
		public void run() {
			System.out.println(ThreadLocalRandom.current().nextInt());
		}
	}

	public static void main(String[] args) {

	}
}
