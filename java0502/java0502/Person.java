package kr.human.java0502;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// 직렬화 : 객체를 스트림으로 만든다.
// 역직렬화 : 스트림을 객체로 만든다.
// VO 만들때 밑에 3개 같이 구현해주는것이 해주는게 좋다!!!!!
// Serializable 인터페이스를 구현해줘야 직렬화/역직렬화를 지원한다. (오버라이드 할거없당)
// Comparable : 크기비교 가능하게 한다/
// Cloneable : 깊은복사 가능하게 한다.(클론 오버라이드는 그대로 쓰면된다.)


public class Person implements Comparable<Person> , Serializable , Cloneable {
	private String name;
	private int age;
	@Override
	public int compareTo(Person o) {
		//이름오름차순 나이 오름차순
		return name.compareTo(o.name) == 0 ? age-o.age : name.compareTo(o.name) ; 
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
