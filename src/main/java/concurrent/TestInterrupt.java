package concurrent;

public class TestInterrupt {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			while (true) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println(Thread.currentThread().isInterrupted());
					System.out.println(Thread.interrupted());
					System.out.println(Thread.currentThread().isInterrupted());
					break;
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
		thread.interrupt();

	}
}
