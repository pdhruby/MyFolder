package kr.human.util;

public class ArrayPrint<T> {
	// 제네릭 메서드  
	public static<T>  void print(T[] array) {
		System.out.print(array.length + "개 : ");
		for(T i : array) System.out.print( i + " ");
		System.out.println();
	}
}