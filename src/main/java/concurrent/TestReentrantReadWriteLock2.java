package concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReentrantReadWriteLock2 {

	public static void main(String[] args) {

		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
		ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
		ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

		writeLock.lock();
		readLock.lock();
		writeLock.unlock();
		System.out.println("this is a test.");

		int readHoldCount = reentrantReadWriteLock.getReadHoldCount();
		for (int i = 0; i < readHoldCount; i++) {
			readLock.unlock();
		}
		writeLock.lock();

	}

}
