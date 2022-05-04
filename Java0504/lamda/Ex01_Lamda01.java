package kr.human.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface MyFunction{
	int max(int a, int b);
}


public class Ex01_Lamda01 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("일식이","두식이","삼식이","간나새끼");
	
		System.out.println(names);
		//정렬을 해서 출력하시오
		Collections.sort(names);
		System.out.println(names);
		
		//역순으로 정렬해서 출력하라.-> 기존의 방식
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(names);
		
		
		//2초후에 HelloWorld!!를 출력하는 스레드를 만들어보자!
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("hellow World!!!!");
			}
		}).start();
		
		
		// 위의 Comparator 인터페이스는 익명 객체이다.==>람다식으로 변경가능하다.1회용
		// 람다식 : 이름없는 메소드
	
		Collections.sort(names, ( o1, o2) -> o2.compareTo(o1));
		System.out.println(names);
		Collections.sort(names, ( o1, o2) -> o1.compareTo(o2));
		System.out.println(names);
		
		
		
		//Runnable 인터페이스를 람다식으로 표현해보자!!
		new Thread(()->{System.out.println("나는 언제 실행?");}).start();

		
		
		
		//사용자가 만든 인터페이스의 일반 사용
		System.out.println(new MyFunction() {

			@Override
			public int max(int a, int b) {
				// TODO Auto-generated method stub
				return a>b ? a: b;
			}
			
		}.max(10,23)); //myFunction인터페이스를 구현함과 동시에 객체를 생성하고
						//메서드 호출까지 한다.
		
		//사용자가 만든 인터페이스의 람다식 사용
		MyFunction mf = (a,b)-> a>b ? a: b;
		System.out.println(mf.max(22, 12));
			
	}
}
