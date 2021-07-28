package concurrent;

public class TestCacheMiss {

	@sun.misc.Contended
	public static class FilledLong {
		public volatile long value = 0L;
	}

	public static class FilledLong2 {
		public volatile long value = 0L;
		private long p1, p2, p3, p4, p5, p6;
	}

}
