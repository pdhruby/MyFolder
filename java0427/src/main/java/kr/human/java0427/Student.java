package kr.human.java0427;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Human{
	private String stuNo;
	
	public Student(String stuNo, String name) {
		super(name);
		this.stuNo = stuNo;
	}

	// 오버라디이 : 기능 변경
	public void think() {
		System.out.println("이번 중간고사를 잘봐야할텐데 !!!");
	}
	
	//기능 추가
	public void stud() {
		System.out.println("하늘천 땅지 검을현.... ");
	}
	
	
}
