package com.example.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MergeSort {
	public static List<Integer> mergeSort(List<Integer> list) {

		return sort(list);

	}

	private static List<Integer> sort(List<Integer> list) {
		if (list.size() <= 1)
			return list;

		List<Integer> left = sort(list.subList(0, list.size() / 2));
		List<Integer> right = sort(list.subList(list.size() / 2, list.size()));

		return merge(left, right);
	}

	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> merged = new ArrayList<>();

		ListIterator<Integer> iteratorLeft = left.listIterator();
		ListIterator<Integer> iteratorRight = right.listIterator();
		while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
			int l = iteratorLeft.next();
			int r = iteratorRight.next();
			if (l <= r) {
				merged.add(l);
				iteratorRight.previous();
			} else {
				merged.add(r);
				iteratorLeft.previous();
			}
		}

		while (iteratorLeft.hasNext())
			merged.add(iteratorLeft.next());

		while (iteratorRight.hasNext())
			merged.add(iteratorRight.next());

		return merged;
	}
}
