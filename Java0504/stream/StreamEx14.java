package kr.human.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Collectors 클래스의 joining () 메서드는 CharSequence 스트림을 연결하고 그 결과를 String으로 반환하는 수집기를 반환합니다.
joining () 메서드는 오버로드되었으며 세 가지 버전이 있습니다.

joining ()은 모든 요소를 ​​연결합니다.
joining (CharSequence delimiter)는 두 요소 사이에 사용되는 구분 기호를 사용합니다.
joining (CharSequence 구분 기호, CharSequence 접두사, CharSequence 접미사)는 구분 기호, 접두사 및 접미사를 사용합니다. 
접두사는 시작 부분에 추가되고 접미사는 끝 부분에 추가됩니다.
 */
public class StreamEx14 {
	public static void main(String[] args) {
		
		List<Employee> employees = Employee.persons();
		
		String names = employees.stream().map(Employee::getName).collect(Collectors.joining());
		System.out.println(names);
		
		names = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println(names);

		names = employees.stream().map(Employee::getName).collect(Collectors.joining(", ", "Hello ", ". Goodbye."));
		System.out.println(names);
		
		System.out.println(ArrayToString(new int[] {1,2,3,4,5,6,7}));
		System.out.println(ArrayToString(new long[] {1,2,3,4,5,6,7}));
	}
	
	public static String ArrayToString(int[] ar) {
		return Arrays.stream(ar).mapToObj(n->n+"").collect(Collectors.joining(", ", "[", "]"));
	}
	public static String ArrayToString(long[] ar) {
		return Arrays.stream(ar).mapToObj(n->n+"").collect(Collectors.joining(", ", "[", "]"));
	}
}
