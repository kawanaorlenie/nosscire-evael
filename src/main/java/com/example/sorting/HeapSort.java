package com.example.sorting;

import java.util.List;

public class HeapSort {

	public List<Integer> sort(List<Integer> list) {
		int length = list.size();
		while (length > 0) {
			list = heapify(list, length);
			replace(list,0,--length);
		}
		return list;
	}

	List<Integer> heapify(List<Integer> list, int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			swap(list, i, length);
		}
		return list;
	}

	List<Integer> swap(List<Integer> list, int parentIndex, int length) {
		int leftChildIndex = parentIndex * 2 + 1;
		int rightChildIndex = parentIndex * 2 + 2;
		
		int parent = list.get(parentIndex);
		int leftChild = list.get(leftChildIndex);
		int indexToSwap = -1;
		if (rightChildIndex >= length || leftChild > list.get(rightChildIndex)) {
			if (leftChild > parent) {
				indexToSwap = leftChildIndex;
			}
		} else {
			if (list.get(rightChildIndex) > parent) {
				indexToSwap = rightChildIndex;
			}
		}
		if (indexToSwap > 0) {
			replace(list,indexToSwap,parentIndex);
			if (indexToSwap < length / 2)
				swap(list, indexToSwap, length);
		}
		return list;
	}

	private void replace(List<Integer> list, int a, int b) {
		int tmp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, tmp);
	}

}
