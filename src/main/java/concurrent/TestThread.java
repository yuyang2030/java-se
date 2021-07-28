package concurrent;

import jdk.nashorn.internal.codegen.CompilerConstants;
import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThread {

	public static class RunnableClass implements Runnable {
		@Override
		public void run() {
			Object lock = new Object();
			System.out.println(this.getClass().getSimpleName());
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().isInterrupted());
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		Thread thread = new Thread(new RunnableClass());
		thread.start();
		thread.interrupt();
		thread.join();

	}

}
