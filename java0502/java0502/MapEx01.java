package kr.human.java0502;

import java.util.Hashtable;
import java.util.Iterator;

public class MapEx01 {
	public static void main(String[] args) {
		// 예전거.....
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "한사람");
		hashtable.put(2, "두사람");
		hashtable.put(3, "세사람");
		hashtable.put(1, "네사람"); // 넣기 :  key는 set이다.
		System.out.println(hashtable.size() + "개: "  + hashtable);
		System.out.println(hashtable.get(2)); // 1개얻기
		System.out.println(hashtable.contains("오사람")); // 있느냐? 
		System.out.println(hashtable.contains("두사람"));
		
		for(int key : hashtable.keySet()) { // 키를 set으로 얻기
			System.out.println(key + " : " + hashtable.get(key));
		}
		System.out.println("-".repeat(60));

		for(String value : hashtable.values()) { // 값만 얻기
			System.out.println(value);
		}
		System.out.println("-".repeat(60));
		
		Iterator<String> it = hashtable.values().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
