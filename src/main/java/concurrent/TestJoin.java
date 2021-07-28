package concurrent;

public class TestJoin {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			try {
				Thread.sleep(100_0000);
			} catch (InterruptedException e) {
				System.out.println("t1 was interrupted.");
			}
		};

		Thread mainThread = Thread.currentThread();

		Runnable r2 = () -> {
			try {
				Thread.sleep(5_000);
				System.out.println("t2 try to interrupt mainThread");
				mainThread.interrupt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

		try {
			System.out.println("main thread wait for t1 finished.");
			t1.join();
		} catch (InterruptedException e) {
			System.out.println("main thread was interrupted by t2 when wait for t1 finished.");
		}

		t1.interrupt();

	}
}
