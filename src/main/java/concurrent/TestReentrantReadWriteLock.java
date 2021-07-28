package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantReadWriteLock {

	private ReentrantLock lock = new ReentrantLock();
	private Integer value = 0;

	Integer add() {
		lock.lock();
		try {
			value++;
			if (value > 2) {
				value = 2;
			}
			return value;
		} finally {
			lock.unlock();
		}
	}

	void read() {
		if (value > 2) {
			System.out.printf("\n read error value: %s", value);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestReentrantReadWriteLock testLock = new TestReentrantReadWriteLock();
		Runnable read = () -> {
			while (!Thread.currentThread().isInterrupted()) {
				testLock.read();
			}
		};

		Runnable write = () -> {
			while (!Thread.currentThread().isInterrupted()) {
				testLock.add();
			}
		};
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Thread readThread = new Thread(read);
			threads.add(readThread);
		}
		Thread writeThread = new Thread(write);
		threads.add(writeThread);

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

	}

}
