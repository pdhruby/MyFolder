package ko.human.java0429;
//List : 입력 순서가 중요할때 사용하는 자료구조

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class ListEx03 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("한사람");
		v.add("두사람");
		v.add("세사람");
		v.add("네사람");
		v.add("오사람"); // add: 추가
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); // capacity :용량, size : 개수
		
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v);
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); //자동으로 용량증가
		
		v.addElement("나인간");
		v.addElement("너인간"); // 추가
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); //자동으로 용량증가
		
		v.set(0, "고친놈");
		v.setElementAt("변경인", 2); // 수정
		
		System.out.println(v.get(4)); // 가져오기
		System.out.println(v.elementAt(4)); // 가져오기
		
		v.remove(3);
		v.remove("세사람"); //지우기 
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); //자동으로 용량증가
		
		v.add(0,"추가인");
		v.add(5,"추가인"); //삽입
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); //자동으로 용량증가
		
		// 반복 1 
		for( int i = 0; i <v.size(); i++) {
			System.out.println(v.get(i));
		}
		System.out.println("-".repeat(50));
		
		// 반복2
		for(String s : v) {
			System.out.println(s);
		}
		//반복3
		Iterator<String> it = v.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println("-".repeat(50));
		//반복4
		Enumeration<String> em = v.elements();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		System.out.println("-".repeat(0));
		
		ListIterator<String> it2 = v.listIterator();
		System.out.println(it.next());
		System.out.println(it.next());

		System.out.println(it.next());
		v.clear();
		System.out.println(v.capacity() + ", " + v.size() + " : "  + v); //자동으로 용량증가
		
		
	}
}
