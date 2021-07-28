package concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class TestAtomic {

	public static void main(String[] args) {

		AtomicLong atomicLong = new AtomicLong();
		atomicLong.incrementAndGet();

	}
}
