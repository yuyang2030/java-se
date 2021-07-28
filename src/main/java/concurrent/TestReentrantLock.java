package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

	public static void main(String[] args) {

		// lock要在不同的线程之间共享
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		try {
			// some logic
		} finally {
			lock.unlock();
		}

	}

}
