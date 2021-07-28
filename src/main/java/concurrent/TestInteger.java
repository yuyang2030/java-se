package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TestInteger {

	public static ReentrantLock globalLock = new ReentrantLock();

	public void testInteger1() {
		Integer a = 100000000;
		for (int i = 0; i <= 10; i++) {
			a = a + i;
			System.out.println("a: " + a + ", id: " + System.identityHashCode(a));
		}
	}

	public static class Adder implements Runnable {
		private Integer count;
		private ReentrantLock lock;

		public Adder(Integer count, ReentrantLock lock) {
			this.count = count;
			System.out.println(System.identityHashCode(this.count));
			this.lock = lock;
		}

		@Override
		public void run() {
			globalLock.lock();
			try {
				count = count + 1;
			} finally {
				globalLock.unlock();
			}
		}
	}

	public void testThreadAdd() {
		ReentrantLock lock = new ReentrantLock();
		Integer count = new Integer(10000000);
		List<Thread> threads = new ArrayList<>();
		System.out.println(System.identityHashCode(count));
		for (int i = 1; i <= 10; i++) {
			Thread thread = new Thread(new Adder(count, lock));
		}
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("count is:" + count);
	}

	public void testBox() {
		Integer c = Integer.valueOf(100);
		c = c + 1;
		Integer a = 100;
		Integer a1 = 100;
		System.out.println(a == a1);
	}

	public void test3(Integer parameter) {
		int b = 100;
	}

	public void test4() {
		Integer a = 1000;
		Integer b = 100;
		a = a + b;

		int c = 100;
	}

	public void test5() {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		Long h = 2L;

		// Long.valueOf()
		// System.out.println(c==d);
		// System.out.println(e==f);
		// System.out.println(c==(a+b));
		// System.out.println(c.equals(a+b));
		// System.out.println(g==(a+b));
		System.out.println(g.equals(a + b));
		// System.out.println(g.equals(a+h));
	}

	public static void main(String[] args) {
		TestInteger testInteger = new TestInteger();
		// testInteger.testInteger1();
		// testInteger.testBox();

		testInteger.test5();
		Integer parameter = 1000;
		// Integer.valueOf()
		testInteger.test3(parameter);

	}
}
