package concurrent;

public class TestYield {

	public static void main(String[] args) throws Exception {

		Runnable r = () -> {
			while (true) {
				try {
					Thread.sleep(1_000);
					System.out.println(Thread.currentThread().getName() + " yield");
					Thread.yield();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					break;
				}
			}
		};
		Thread t1 = new Thread(r, "Thread-1");
		Thread t2 = new Thread(r, "Thread-2");
		Thread t3 = new Thread(r, "Thread-3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(10_000);
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
	}
}
