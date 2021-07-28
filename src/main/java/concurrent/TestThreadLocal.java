package concurrent;

public class TestThreadLocal {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("hello world.");
		Thread childThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("child: " + threadLocal.get());
			}
		});
		childThread.start();
		threadLocal.remove();
		System.out.println("parent: " + threadLocal.get());

	}
}
