package concurrent;

public class TestSleep {

	public static void main(String[] args) throws Exception {
		Object lock = new Object();

		Runnable r1 = () -> {
			synchronized (lock) {
				try {
					System.out.println("r1 acquire lock.");
					Thread.sleep(10_000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException !");
				}
			}
		};

		Runnable r2 = () -> {
			synchronized (lock) {
				try {
					System.out.println("r2 acquire lock.");
					Thread.sleep(5_000);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException !");
				}
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		Thread.sleep(100);
		t2.start();
		Thread.sleep(4_000);
		t1.interrupt();
		t2.join();
	}
}
