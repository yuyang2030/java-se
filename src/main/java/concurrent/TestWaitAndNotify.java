package concurrent;

import java.util.ArrayDeque;
import java.util.Random;

public class TestWaitAndNotify {

	private static Random random = new Random();
	private static final ArrayDeque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws InterruptedException {

		Runnable producer = () -> {
			while (true) {
				synchronized (stack) {
					while (stack.size() >= 10) {
						try {
							stack.wait();
						} catch (InterruptedException e) {
							System.out.println("Error in wait: " + e.getMessage());
						}
					}
					int ele = random.nextInt();
					stack.add(ele);
					System.out.println(Thread.currentThread().getName() + " produce " + ele);
					stack.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Runnable consumer = () -> {
			while (true) {
				synchronized (stack) {
					while (stack.size() == 0) {
						try {
							stack.wait();
						} catch (InterruptedException e) {
							System.out.println("Error in wait: " + e.getMessage());
						}
					}
					int ele = stack.pop();
					System.out.println(Thread.currentThread().getName() + " consume " + ele);
					stack.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread tProducer1 = new Thread(producer, "Producer1");
		Thread tProducer2 = new Thread(producer, "Producer2");
		Thread tConsumer = new Thread(consumer, "Consumer");
		tConsumer.start();
		tProducer1.start();
		tProducer2.start();
		tConsumer.join();
	}
}
