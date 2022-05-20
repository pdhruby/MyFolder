package kr.human.util;

public class IntArrayPrint {
	public static void print(Integer[] array) {
		System.out.print(array.length + "개 : ");
		for(int i : array) System.out.print( i + " ");
		System.out.println();
	}
}
