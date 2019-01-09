package it.patrol;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

public class BenchmarkFor {

	@Benchmark
	@Fork(value = 1)
	public int benchmarkFor1000() {
		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum++;
		}
		return sum;
	}

	@Benchmark
	@Fork(value = 1)
	public int benchmarkFor100() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum++;
		}
		return sum;
	}

}
