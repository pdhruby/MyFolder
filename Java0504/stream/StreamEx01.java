package kr.human.stream;

import java.util.Random;

public class StreamEx01 {
	public static void main(String[] args) {
		// 중간연산 : 연산 결과가 다시 스트림이다. 반복적으로 적용 가능하다.
		// 최종연산 : 연산 결과가 스트림이 아닌 연산(1회성)
		
		//임의의 난수 6개 출력
		new Random().ints() // 스트림을 만든다.
		.distinct() // 중복제거
		//.filter(n -> n>=1 && n<=45) //걸러서
		.limit(6) // 6개만
		.sorted() // 정렬
		//.forEach((n)->System.out.println(n)); //출력 : 람다식 
		.forEach(System.out::println); //출력 : 정적메서드 지정(:: 연산자 사용) 
		
		
		// 로또번호
		new Random().ints(1, 46).distinct().limit(6).sorted()
		.forEach(n->System.out.println(n+" "));
		System.out.println();
	}
}
