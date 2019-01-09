package it.patrol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Objects;
import java.util.Optional;

public class BenchmarkOptional {

	@State(Scope.Thread)
	@Getter
	public static class NullObject {

		private TestObject testObject;
	}

	@State(Scope.Thread)
	@Getter
	public static class NotNullObject {

		private TestObject testObject = new TestObject("notNull");
	}

	@Getter
	@AllArgsConstructor
	private static class TestObject {

		private String value;
	}

	@Benchmark
	public String testStaticMethodNullArgument(NullObject nullObject) {
		if (Objects.nonNull(nullObject) &&
				Objects.nonNull(nullObject.getTestObject()) &&
				Objects.nonNull(nullObject.getTestObject().getValue())) {
			return nullObject.getTestObject().getValue();
		}
		return "";
	}

	@Benchmark
	public String testEqualNullArgument(NullObject nullObject) {
		if (nullObject != null &&
				nullObject.getTestObject() != null &&
				nullObject.getTestObject().getValue() != null) {
			return nullObject.getTestObject().getValue();
		}
		return "";
	}

	@Benchmark
	public String testOptionalNullArgument(NullObject nullObject) {
		return Optional.ofNullable(nullObject)
					   .map(NullObject::getTestObject)
					   .map(TestObject::getValue)
					   .orElse("");
	}

	@Benchmark
	public String testStaticMethodNotNullArgument(NotNullObject notNullObject) {
		if (Objects.nonNull(notNullObject) &&
				Objects.nonNull(notNullObject.getTestObject()) &&
				Objects.nonNull(notNullObject.getTestObject().getValue())) {
			return notNullObject.getTestObject().getValue();
		}
		return "";
	}

	@Benchmark
	public String testEqualNotNullArgument(NotNullObject notNullObject) {
		if (notNullObject != null &&
				notNullObject.getTestObject() != null &&
				notNullObject.getTestObject().getValue() != null) {
			return notNullObject.getTestObject().getValue();
		}
		return "";
	}

	@Benchmark
	public String testOptionalNotNullArgument(NotNullObject notNullObject) {
		return Optional.ofNullable(notNullObject)
					   .map(NotNullObject::getTestObject)
					   .map(TestObject::getValue)
					   .orElse("");
	}

}
