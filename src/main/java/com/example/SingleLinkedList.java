package com.example;

public class SingleLinkedList<T> {

	SingleLinkedList<T> next;
	T element;

	public void add(T element) {
		if (this.element == null) {
			this.element = element;
			return;
		}

		SingleLinkedList<T> e = this;
		while (e.next != null) {
			e = e.next;
		}
		e.next = new SingleLinkedList<>();
		e.next.element = element;
	}

	public SingleLinkedList<T> reverse() {
		T first = this.element;
		SingleLinkedList<T> second = this.next;

		SingleLinkedList<T> tmp = null;
		SingleLinkedList<T> current = this;
		SingleLinkedList<T> next = this.next;
		while (next != null) {
			tmp = current;
			current = next;
			next = next.next;
			current.next = tmp;
		}

		this.next = current.next;
		this.element = current.element;
		second.next = current;
		current.next = null;
		current.element = first;

		return this;
	}

	public int size() {
		SingleLinkedList<T> e = this;
		int counter = 0;
		while (e != null) {
			counter++;
			e = e.next;
		}
		return counter;
	}

	public T get(int i) {
		if (this.element == null)
			return null;

		SingleLinkedList<T> e = this;
		for (int j = 0; j < i; j++) {
			e = e.next;
			if (e == null)
				return null;
		}
		return e.element;
	}

	@Override
	public String toString() {
		SingleLinkedList<T> e = this;
		StringBuffer sb = new StringBuffer();
		while (e != null && e.element != null) {
			sb.append(e.element);
			e = e.next;
			if (e != null) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

}