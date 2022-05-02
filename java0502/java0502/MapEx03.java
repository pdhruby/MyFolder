package kr.human.java0502;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MapEx03 {
	public static void main(String[] args) {
		// 1.5에 새롭게 추가!! 싱글 스레드에만 안전!!!
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1, "한사람");
		map.put(2, "두사람");
		map.put(3, "세사람");
		map.put(1, "네사람"); // 넣기 :  key는 set이다.
		System.out.println(map.size() + "개: "  + map);
		System.out.println(map.get(2)); // 1개얻기
		System.out.println(map.containsKey(4)); // 있느냐? 
		System.out.println(map.containsValue("오사람"));
		System.out.println("-".repeat(60));
		
		for(int key : map.keySet()) { // 키를 set으로 얻기
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("-".repeat(60));

		for(String value : map.values()) { // 값만 얻기
			System.out.println(value);
		}
		System.out.println("-".repeat(60));
		
		Iterator<String> it = map.values().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
