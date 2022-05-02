package kr.human.java0502;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapEx04 {
	public static void main(String[] args) {
		Map<String, Person> pMap = new TreeMap<String, Person>();
		Person p1 = new Person("한사람",34);
		Person p2 = new Person("두사람",24);
		Person p3 = new Person("세사람",45);
		Person p4 = new Person("네사람",31);
		Person p5 = new Person("오사람",38);
		
		pMap.put(p1.getName(), p1);
		pMap.put(p2.getName(), p2);
		pMap.put(p3.getName(), p3);
		pMap.put(p4.getName(), p4);
		pMap.put(p5.getName(), p5);
	
		Scanner sc = new Scanner(System.in);
		System.out.println("찾는사람의 이름을  입력하시오");
		String name = sc.nextLine();
		if(pMap.containsKey(name)) {
			System.out.println("찾은 사람 : " + pMap.get(name));
		}else {
			System.out.println(name + "씨는 없는 회원입니다.");
		}
		sc.close();
	}
}
