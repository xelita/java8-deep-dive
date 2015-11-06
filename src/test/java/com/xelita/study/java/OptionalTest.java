
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
	public void optionalFilter() throws Exception {
		Optional<Integer> val = Optional.of(10);
		Optional<Integer> result = val.filter(s -> s > 10);
		assertThat(result.isPresent(), is(false));
	}

	@Test
	public void optionalOrElse() throws Exception {
		Optional<Integer> val = Optional.empty();
		assertThat(val.orElse(10), is(10));
	}

	@Test
	public void optionalOrElseGet() throws Exception {
		Optional<Integer> val = Optional.empty();
		assertThat(val.orElseGet(() -> 10), is(10));
	}

	@Test(expected = IllegalStateException.class)
	public void optionalOrElseThrow() throws Exception {
		Optional<Integer> val = Optional.empty();
		val.orElseThrow(IllegalStateException::new);
	}
}
