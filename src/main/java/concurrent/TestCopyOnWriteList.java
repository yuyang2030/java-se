package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteList {

	public static class Run implements Runnable {

		private CopyOnWriteArrayList<String> copyOnWriteArrayList;

		public Run(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
			this.copyOnWriteArrayList = copyOnWriteArrayList;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				this.copyOnWriteArrayList.add(Thread.currentThread().getName() + i);
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {

		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.iterator();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Run(list), "thread" + i + "_");
			threads.add(thread);
		}
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println(list);
	}

}
