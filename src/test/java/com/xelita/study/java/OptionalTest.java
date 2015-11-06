
package com.xelita.study.java;

import org.junit.*;

import java.util.*;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class OptionalTest {

	@Test
	public void optionalOfNullableInitializedWithNull() throws Exception {
		Optional<String> val = Optional.ofNullable(null);
		assertThat(val.isPresent(), is(false));
	}

	@Test
	public void optionalOfNullableInitializedWithNonNullValue() throws Exception {
		Optional<String> val = Optional.ofNullable("hello");
		assertThat(val.get(), is("hello"));
	}

	@Test
	public void orElse() throws Exception {
		Optional<Integer> val = Optional.empty();
		assertThat(val.orElse(10), is(10));
	}

	@Test
	public void orElseGet() throws Exception {
		Optional<Integer> val = Optional.empty();
		assertThat(val.orElseGet(() -> 10), is(10));
	}

	@Test(expected = IllegalStateException.class)
	public void orElseThrow() throws Exception {
		Optional<Integer> val = Optional.empty();
		val.orElseThrow(IllegalStateException::new);
	}

	@Test
	public void ifPresent() throws Exception {
		List<Integer> values = new ArrayList<>();
		Optional<Integer> val = Optional.of(10);
		val.filter(s -> s < 100).ifPresent(values::add);
		assertThat(values.size(), is(1));
	}

	@Test
	public void filter() throws Exception {
		Optional<Integer> val = Optional.of(10);
		Optional<Integer> result = val.filter(s -> s > 10);
		assertThat(result.isPresent(), is(false));
	}

	@Test
	public void map() throws Exception {
		Optional<Integer> val = Optional.of(10);
		Optional<Integer> result = val.map(s -> s / 2);
		assertThat(result.get(), is(5));
	}
}
