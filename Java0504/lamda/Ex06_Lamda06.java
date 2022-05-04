package kr.human.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Ex06_Lamda06 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++) list.add(new Random().nextInt(101));
		System.out.println(list);
		
		// 각각의 요소에 10을 곱하고 2로 나눈 값을 출력해라!!!
		for(int n : list) System.out.print(n*10/2 + " ");
		System.out.println();
		
		list.forEach(n -> {System.out.print(n*10/2 + " ");});
		System.out.println();
		
		// 각각의 요소를 곱하기 2한 값으로 바꿔라!!!
		for(int i=0;i<list.size();i++) list.set(i, list.get(i)*2);
		System.out.println(list);
		
		list.replaceAll(i -> i*2);
		System.out.println(list);
		
		// 300이상인 요소를 모두 지워라!!!
//		for(int i=list.size()-1;i>=0;i--) {
//			if(list.get(i)>=300) {
//				list.remove(i);
//			}
//		}
		list.removeIf((n)-> n >= 300 );
		System.out.println(list);
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(".-", "a");			map.put("-...", "b");
		map.put("-.-.", "c");		map.put("-..", "d");
		map.put(".", "e");			map.put("..-.", "f");
		map.put("--.", "g");		map.put("....", "h");
		map.put("..", "i");			map.put(".---", "j");
		map.put("-.-", "k");		map.put(".-..", "l");
		map.put("--", "m");			map.put("-.", "n");
		map.put("---", "o");		map.put(".--.", "p");
		map.put("--.-", "q");		map.put(".-.", "r");
		map.put("...", "s");		map.put("-", "t");
		map.put("..-", "u");		map.put("...-", "v");
		map.put(".--", "w");		map.put("-..-", "x");
		map.put("-.--", "y");		map.put("--..", "z");
		// 람다전 출력
		for(String key : map.keySet()) {
			System.out.println(map.get(key) + " : " + key);
		}
		System.out.println();
		// 람다식을 이용한 출력
		map.forEach((k,v)->{System.out.println(v + " : " + k);});
	}
}
