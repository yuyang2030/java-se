package concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author YY
 */
public class TestLockSupport {

	public void testPark() {
		Thread subThread = new Thread(() -> {
			System.out.println("sub thread start park");
			System.out.println(this.getClass().getSimpleName());
			LockSupport.park();
			System.out.println("sub thread finish park");
			System.out.println("sub thread is interrupted: " + Thread.currentThread().isInterrupted());
		});
		subThread.start();
	}

	public void testParkInterruptReturn() {
		Runnable target;
		Thread subThread = new Thread(() -> {
			// 只有被中断了才返回！
			while (!Thread.currentThread().isInterrupted()) {
				LockSupport.park();
			}
		});
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("start park");
		LockSupport.unpark(Thread.currentThread());
		LockSupport.park();
		System.out.println("finish park");
		System.out.println("park again");
		LockSupport.unpark(Thread.currentThread());
		LockSupport.park();
		LockSupport.park(new Object());
		System.out.println("finish park again");

		TestLockSupport testLockSupport = new TestLockSupport();
		testLockSupport.testPark();

		// subThread.start();
		// Thread.sleep(4_000);
		//// System.out.println("main thread interrupt sub thread");
		//// subThread.interrupt();
		// System.out.println("main thread unpark sub-thread");
		// LockSupport.unpark(subThread);

		Thread t = Thread.currentThread();
		LockSupport.park(t);

	}

}
