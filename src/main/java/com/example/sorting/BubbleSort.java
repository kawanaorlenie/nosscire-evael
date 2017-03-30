package com.example.sorting;

import java.util.List;

public class BubbleSort {

	public static List<Integer> sort(List<Integer> list) {

		for (int j = list.size() - 1; j > 1; j--)
			for (int i = 0; i < j; i++) {
				if (list.get(i) > list.get(i + 1)) {
					int tmp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, tmp);
				}
			}
		return list;
	}
}
