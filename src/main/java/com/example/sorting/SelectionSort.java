package com.example.sorting;

import java.util.List;

public class SelectionSort {
	public static List<Integer> sort(List<Integer> list) {

		for (int i = 0; i < list.size(); i++) {
			int min = Integer.MAX_VALUE;
			int indexMin = -1;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j) < min) {
					min = list.get(j);
					indexMin = j;
				}
			}
			list.set(indexMin, list.get(i));
			list.set(i, min);
		}

		return list;
	}
}
