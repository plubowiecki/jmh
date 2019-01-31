package it.patrol;

import lombok.Builder;
import lombok.Data;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Objects;

public class BenchmarkAssignToVariable {

	@Benchmark
	public boolean assignToVariable() throws InterruptedException {
		MyObject object = createObject();
		return Objects.nonNull(object);
	}

	@Benchmark
	public boolean directlyToMethod() throws InterruptedException {
		return Objects.nonNull(createObject());
	}

	private MyObject createObject() {
		return MyObject.builder()
					   .id(1602202801L)
					   .name("name")
					   .build();
	}

	@Data
	@Builder
	static class MyObject {
		private Long id;
		private String name;
	}

}
