package concurrent;

import java.util.concurrent.atomic.*;

public class TestAtimtic {

	public static void main(String[] args) {

		AtomicLong atomicLong = new AtomicLong();
		// 对long来说，未初始化默认值是0
		System.out.println(atomicLong.get());

		// CAS典型操作，比较并赋值，没有自旋操作，尝试一次
		atomicLong.compareAndSet(0, 1);

		// 先操作后获取数值
		atomicLong.incrementAndGet();

		atomicLong.decrementAndGet();
		atomicLong.addAndGet(1);
		atomicLong.accumulateAndGet(1, (pre, x) -> pre * x);

		// 上面的镜像操作，先获取当前值，然后进行操作
		atomicLong.getAndIncrement();
		atomicLong.getAndDecrement();
		atomicLong.getAndAdd(1);
		atomicLong.getAndAccumulate(1, (pre, x) -> pre * x);

		// atomicLong.set();
		// AtomicBoolean;
		// AtomicInteger;
		// AtomicIntegerArray;
		// AtomicLongArray;
	}
}
