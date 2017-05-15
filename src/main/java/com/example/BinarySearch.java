package com.example;

import java.util.List;

public class BinarySearch {

	public static Integer binarySearch(List<Integer> list, Integer toFind) {
		int min = 0;
		int max = list.size();
		int index = (max - min) / 2;
		while (list.get(index) != toFind && max - min >= 1) {
			System.out.println(String.format("max %d, min %d, index %d", max, min, index));
			if (list.get(index) > toFind)
				max = index;
			else
				min = index;
			index = min + (max - min) / 2;
		}
		if (list.get(index) == toFind) {
			System.out.println("found: " + list.get(index));
			return toFind;
		} else
			return null;
	}
}
