package com.example.sorting;

import java.util.List;

public class InsertionSort {
	public static List<Integer> sort(List<Integer> list) {

		for (int i = 1; i < list.size(); i++) {
			int j = i - 1;
			int key = list.get(i);
			while (j >= 0 && key < list.get(j)) {
				Integer toMove = list.get(j);
				list.set(j, key);
				list.set(j + 1, toMove);
				j--;
			}
		}
		return list;

	}
}
