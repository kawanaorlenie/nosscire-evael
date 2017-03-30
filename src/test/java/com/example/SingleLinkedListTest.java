package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class SingleLinkedListTest {

	@Test
	public void reverseTest() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		origin.add("bnm,");
		origin.add("cvbn");
		origin.add("dfgh");
		assertEquals("asdf, bnm,, cvbn, dfgh", origin.toString());
		assertEquals("dfgh, cvbn, bnm,, asdf", origin.reverse().toString());
	}

	@Test
	public void shouldAddElement() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		assertEquals("asdf", origin.get(0));
	}

	@Test
	public void shouldAddElementsInOrder() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		origin.add("bnm,");
		assertEquals("asdf", origin.get(0));
		assertEquals("bnm,", origin.get(1));
	}

	@Test
	public void get_shouldReturnNull_WhenNoElement() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		assertNull(origin.get(0));
	}

	@Test
	public void get_shouldReturnNull_WhenOutOfBound() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		assertNull(origin.get(1));
	}

	@Test
	public void toString_ShouldRetrunEmpty_WhenListEmpty() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		assertEquals("", origin.toString());
	}

	@Test
	public void toString_ShouldRetrunConcatenated() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		origin.add("jkl;");
		assertEquals("asdf, jkl;", origin.toString());
	}

	@Test
	public void size() {
		SingleLinkedList<String> origin = new SingleLinkedList<>();
		origin.add("asdf");
		origin.add("jkl;");
		assertEquals(2, origin.size());
	}
}
