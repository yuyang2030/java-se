package concurrent;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
	@Data
	@ToString
	public static class P {
		private String name;
		public P(String name) {
			this.name = name;
		}
	}
	public static void main(String[] args) {
		// 如果你要修改的是引用类型，然后还想像操作原子类一样操作引用类型对象，可以使用AtomicReference包装一样
		// 然后得到的atomicReference就是一个原子类了，可以在其上进行各种原子操作
		AtomicReference atomicReference = new AtomicReference();
		P first = new P("fist");
		P second = new P("second");
		atomicReference.set(first);
		System.out.println(atomicReference.get());
		atomicReference.compareAndSet(first, second);
		System.out.println(atomicReference.get());
	}
}
