package com.example.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {

	private HeapSort heapSort;

	@Before
	public void setup() {
		heapSort = new HeapSort();
	}

	@Test
	public void shouldSwap() {
		List<Integer> swaped = heapSort.swap(Arrays.asList(7, 8, 2), 0, 3);
		assertEquals(Arrays.asList(8, 7, 2), swaped);

		swaped = heapSort.swap(Arrays.asList(7, 2, 8), 0, 3);
		assertEquals(Arrays.asList(8, 2, 7), swaped);

		swaped = heapSort.swap(Arrays.asList(1, 2), 0, 2);
		assertEquals(Arrays.asList(2, 1), swaped);
	}

	@Test
	public void shouldHeapify() {
		List<Integer> heapified = heapSort.heapify(Arrays.asList(8, 7, 2, 3, 9, 1, 10, 4, 6), 9);
		assertEquals(Arrays.asList(10, 9, 8, 6, 7, 1, 2, 4, 3), heapified);

		heapified = heapSort.heapify(Arrays.asList(8, 7, 2, 3, 9, 1, 4, 6), 8);
		assertEquals(Arrays.asList(9, 8, 4, 6, 7, 1, 2, 3), heapified);
	}

	@Test
	public void shouldSortList() {
		List<Integer> list = Stream.generate(() -> (int) (Math.random() * 100)).limit(2)
				.collect(Collectors.toList());
		List<Integer> expected = list.stream().sorted().collect(Collectors.toList());
		List<Integer> sorted = heapSort.sort(list);
		assertEquals(expected, sorted);
	}

}
