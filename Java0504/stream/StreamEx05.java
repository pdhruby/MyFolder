package kr.human.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx05 {
	public static void main(String[] args) {
		// 스트림은 읽기만 가능하다. 변경하지못함(불변객체)
		// 그래서 중간 연산을 하면 새로운 스트림이 리턴된다.
		List<Integer> list = Arrays.asList(11,22,3,14,35,16,37,28);
		// Collect 연산 : 만들어라 -- 최종연산
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(sortedList);
		
		System.out.println(sortedList.stream().count() + "개"); // 최종연산
		
		// peek(Consumer<? super T> action 메서드를 이용하여 디버깅 가능하다.
		int sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
				.peek(n->System.out.println("가져오기 : " + n))
				.filter(n->n%2==1)
				.peek(n->System.out.println("거르기 : " + n))
				.map(n->n*n) // 각각의 요소를 변경
				.peek(n->System.out.println("변환 : "  + n))
				.reduce(0, Integer::sum); // 모든 요소에 대하여 반복하는 최종연산
		System.out.println("합계 : " + sum); // 1*1 + 3*3 + 5*5 + 7*7 + 9*9
		
	}
}
