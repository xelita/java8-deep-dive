
/*
 * ====================================================================
 * Copyright by Benjamin Sempere,
 * All rights reserved.
 * ====================================================================
 * Author  : Benjamin Sempere
 * E-mail  : benjamin@sempere.org
 * Homepage: www.sempere.org
 * ====================================================================
 */

package com.xelita.study.java;

import org.junit.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.*;

public class StreamTest {

	@Test
	public void map() throws Exception {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> results = values.stream().map(val -> val * 2).collect(Collectors.toList());
		assertArrayEquals(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, results.toArray());
	}
}
