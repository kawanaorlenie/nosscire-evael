package com.example;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

//Nale�y uwa�a� na to ile pami�ci si� alokuje 
// i unika� rekurencji � podczas kodowania rozwi�zania.

//Nale�y by� przygotowanym na dyskusje o z�o�ono�ci obliczeniowej 
// i pami�ciowej r�nych algorytm�w.
public class BinarySearchTest {

	// @Test
	public void shouldFindNumber() {
		int limit = 100;

		Stream.iterate(1, n -> n + 1).limit(10).forEach(i -> assertEquals(
				BinarySearch.binarySearch(Stream.iterate(1, n -> n + 1).limit(limit).collect(Collectors.toList()), i),
				i));
	}

	@Test
	public void isFirstCapital() {
		String toTest = "Napis";
		assertTrue(toTest.charAt(0) <= 'Z' && toTest.charAt(0) >= 'A');
	}

	@Test
	public void isPowerOfTwo() {
		// http://www.skorks.com/2010/10/write-a-function-to-determine-if-a-number-is-a-power-of-2/
		int isPower = 8;
		assertTrue("8 is power of two", (isPower & isPower - 1) == 0);
		int isNotPower = 7;
		assertFalse("7 is not power of two", (isNotPower & isNotPower - 1) == 0);
	}

	@Test
	public void isPowerOf() {
		int power = 3;
		double d = Math.log(27) / Math.log(power);
		assertTrue("27 is power of 3", Math.ceil(d) == Math.floor(d));

		d = Math.log(26) / Math.log(power);
		assertFalse("26 is not power of 3", Math.ceil(d) == Math.floor(d));
	}

	// Odwracanie jednokierunkowej listy odsy�aczowej
	// jaka to jest odsy�aczowa? //TODO
	@Test
	public void reversArray() {
		int[] toReverse = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] expected = { 8, 7, 6, 5, 4, 3, 2, 1 };

		assertTrue(Arrays.equals(expected, reverse(toReverse)));
	}

	// Odwracanie jednokierunkowej listy odsy�aczowej
	// jaka to jest odsy�aczowa? //TODO
	@Test
	public void reversArray2() {
		int[] toReverse = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] expected = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		assertTrue(Arrays.equals(expected, reverse2(toReverse)));
	}

	public int[] reverse(int[] toReverse) {
		int size = toReverse.length;
		for (int j = 0; j < size - 1; j++) {
			for (int i = 0; i < size - 1 - j; i++) {
				int tmp = toReverse[i];
				toReverse[i] = toReverse[i + 1];
				toReverse[i + 1] = tmp;
			}
		}
		return toReverse;
	}

	public int[] reverse2(int[] toReverse) {
		int size = toReverse.length;
		for (int j = 0; j < size / 2; j++) {
			int tmp = toReverse[j];
			toReverse[j] = toReverse[size - j - 1];
			toReverse[size - j - 1] = tmp;
			System.out.println(Arrays.toString(toReverse));
		}
		return toReverse;
	}

	// Napisz algorytm licz�cy silnie (bez rekurencji).
	@Test
	public void silniaBezRekurencji() {
		int liczba = 4;
		int silnia = 1;
		for (int i = 1; i <= liczba; i++)
			silnia = silnia * i;
		assertEquals(24, silnia);

	}

	// W jakim typie nale�y trzyma� ceny (np. ceny produkt�w w sklepie
	// internetowym)?
	// Dlaczego double nie jest dobrym typem do przechowywania informacji o
	// kwotach pieni�nych i co mo�na zamiast niego u�y�?

	// http://stackoverflow.com/a/3730040
	@Test
	public void floatForPrice() {
		System.out.println(1.03 - .42);
		assertFalse("not equals!", 1.03 - .42 == 0.61);
	}

	@Test
	public void stringHashcode() {
		String s = "asdfaaasdf";
		System.out.println(s.hashCode());
		int n = s.length() - 1;
		int hashcode = 0;
		int hashcode2 = 0;
		for (char c : s.toCharArray()) {
			// s[0]*31^(n - 1) + s[1]*31^(n - 2) + ... + s[n - 1]
			hashcode = (int)(hashcode + (int) (c * (int) Math.pow(31, n)));
System.out.println("1: "+hashcode);
			hashcode2 = 31 * hashcode2 + c;
			System.out.println("2: "+hashcode2);

			n--;
		}
		System.out.println(hashcode);
		System.out.println(hashcode2);
	}

	// Z�o�ono�ci obliczeniowe:
	// dost�pu do elementu (maj�c jego warto��) w tablicy - O(n)
	// dost�pu do elementu (maj�c jego warto��) w tablicy posortowanej - O(logn)
	// dost�pu do elementu (maj�c jego warto��) w tablicy hashowanej //TODO
	// z�o�ono�� dost�pu do elementu w drzewie (np. binary tree) //TODO
	// z�o�ono�� obliczeniowa quicksorta //TODO
	// z�o�ono�� obliczeniowa sortowania b�belkowego, przez wstawianie i przez
	// wybieranie //TODO
	//
	// Problem 5 filozof�w i jakie s� mo�liwe rozwi�zania. //TODO
	// Problem producenta i konsumenta oraz jego implementacja. //TODO
	// Znajomo�� algorytm�w: silnia, fibonacci
	// Napisz algorytm licz�cy kolejne elementy ci�gu Fibonacciego (bez
	// rekurencji).
	// Napisz algorytm odwracania jednokierunkowej listy odsy�aczowej (bez
	// alokowania nowej listy).
	// Co to jest �stabilno�� algorytmu sortowania�?

	// Przyk�adowe algorytmy do po�wiczenia na kartce:
	// Silnia(n)
	// Fibonacci(n)
	// Odwracanie jednokierunkowej listy odsy�aczowej
	// Znajdowanie najbli�szego wsp�lnego rodzica w drzewie maj�c podane w�z�y
	// drzewa
	// Sprawd� czy liczba jest pot�g� innej liczby np. 3
	// Sprawd� czy liczba jest pot�g� 2 (3 mo�liwe podej�cia: bruteforce,
	// logarytm, przesuni�cia bitowe)
	// Odwr�� string (NIE alokuj�c nowego stringa)
	// Algorytm justowania stringa
	// Napisz funkcje, kt�ra odpowiada na pytanie czy pierwszy znak w podanym
	// stringu jest z du�ej czy ma�ej litery
	// Pole ko�a
	// Napisa� funkcj�, kt�ra dla zadanego na wej�ciu (dowolnego) String'a
	// zamienia pierwszy znak na jego du�y odpowiednik (je�li jest liter�).
	// Zaimplementuj hashcode dla String (kluczowe: znajomo�� zasad hashcode w
	// Java oraz wykorzystanie 4 bajt�w).

}
