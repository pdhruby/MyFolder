package kr.human.lamda;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex04_Lamda04 {

	
	public static void main(String[] args) {
		//인수가 1개 리턴값이 1개인 함수 ==> Function 인터페이스 구현
		// 정수를 문자로 변환하는 람다식
		Function<Integer, String> int2String = (a)->(a+"");
		System.out.println(int2String.apply(123)+123);
	
		//문자열을 정수로 변환하는 람다식
		Function<String, Integer> string2Int = (a)->(Integer.parseInt(a));
		System.out.println(string2Int.apply("2")*123);  
		
		
		//인수가 없고 리턴값이 1개인 함수 ==> Supplier 인터페이스 구현
		// 1~100사이의 난수를 1개 얻는 람다식
		
		Supplier<Integer> rand = ()->(int)(Math.random()*101);
		System.out.println(rand.get());
		System.out.println(rand.get());
		System.out.println(rand.get());
		System.out.println(rand.get());
		

		// 인수가 1개있고 리턴값이 없다.(출력용) ==> Consumer 인터페이스 구현
		Consumer<String> printMessage = str -> System.out.println("(" + str + ")");
		printMessage.accept("한사람");
		printMessage.accept("두인간");
		printMessage.accept("하하하");
		
	    //정수 2개를 보내서 문자열로 결합해서 리턴하는 람다식
		BiFunction<Integer, Integer, String> add =  (a,b) -> a+""+b;
		System.out.println(add.apply(123, 456));
		
		
		//총점과 갯수를 인수로 받아 평균을 소수이하 2자리로 만들어 String 리턴하는 함수
		//BiFunction<Integer, Integer, String> avg = (a,b)-> ((double)a/b).;
		double num = 3.5353535;
	}
}
