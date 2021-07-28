package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestAqs {

	public static void main(String[] args) {
		AtomicInteger count = new AtomicInteger();
		ReentrantLock lock = new ReentrantLock();

		Runnable runnable = () -> {
			lock.lock();
			count.getAndIncrement();
			lock.unlock();
		};

	}

}
