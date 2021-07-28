package concurrent;

public class TestReOrder {

	public static class ReadThread extends Thread {
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				if (ready) {
					System.out.println(num + num);
				}
				System.out.println("read thread ...");
			}
		}
	}

	public static class WriteThread extends Thread {

		@Override
		public void run() {
			num = 2;
			ready = true;
			System.out.println("write thread over ...");
		}
	}

	public static int num = 0;
	public static boolean ready = false;

	public static void main(String[] args) throws Exception {
		ReadThread rt = new ReadThread();
		rt.start();

		WriteThread wt = new WriteThread();
		wt.start();

		Thread.sleep(10);
		rt.interrupt();
		System.out.println("main exit");

	}

}
