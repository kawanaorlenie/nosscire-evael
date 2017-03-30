package com.example.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.sorting.BubbleSort;

public class BubbleSortTest {

	@Test
	public void shouldSortList() {
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> sorted = BubbleSort.sort(Arrays.asList(8, 7, 2, 3, 5, 9, 1, 10, 4, 6));
		assertEquals(expected, sorted);
	}

}
