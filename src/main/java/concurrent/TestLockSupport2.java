package concurrent;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport2 {

	public static void main(String[] args) throws InterruptedException {

		Thread subThread = new Thread(() -> {
			// 只要当前线程没有被中断，那么就会再次park阻塞
			while (!Thread.currentThread().isInterrupted()) {
				LockSupport.park();
			}
			System.out.println("get out of dead loop");
		});

		subThread.start();
		System.out.println("try to unpark sub thread");
		LockSupport.unpark(subThread);
		Thread.sleep(5_000);
		System.out.println("try to interrupt sub thread");
		subThread.interrupt();

	}

}
