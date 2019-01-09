package it.patrol;

import org.openjdk.jmh.annotations.Benchmark;

public class BenchmarkDefault {

	@Benchmark
	public int benchmark() throws InterruptedException {
		Thread.sleep(1000);
		return 0;
	}

}
