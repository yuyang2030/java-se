package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCreateThread {

	public static class ChildThread extends Thread {
		@Override
		public void run() {
			System.out.println("This is child thread which extends Thread");
		}
	}

	public static class RunThread implements Runnable {
		@Override
		public void run() {
			System.out.println("This is runnable thread");
		}
	}

	public static class CallThread implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.println("This is call thread implements Callable<T>");
			return 0;
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 第一种：继承 Thread实现的线程子类
		Thread childThread = new ChildThread();
		childThread.start();
		// 第二种： 继承 Runnable接口实现的线程
		Thread runnableThread = new Thread(new RunThread());
		runnableThread.start();
		// 第三种：继承 Callable<T> 接口实现的线程
		FutureTask<Integer> futureTask = new FutureTask<>(new CallThread());
		Thread callableThread = new Thread(futureTask);
		callableThread.start();
		callableThread.join();
		if (futureTask.isDone()) {
			System.out.println("futureTask return：" + futureTask.get());
		}
	}
}
