package kr.human.util;

public class StringArrayPrint {
	public static void print(String[] array) {
		System.out.print(array.length + "개 : ");
		for(String i : array) System.out.print( i + " ");
		System.out.println();
	}
}
