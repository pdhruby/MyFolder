package kr.human.vo;

import kr.human.java0427.Var;

public class Var3 extends Var {
	

	public void view() {
		
		Var var = new Var();//내가 만든 클래스라도 다른 패키지에 있으면 임포트해야한다.
		// 같은 클래스 내부에서는 모두 사용가능하다.
	
		

		//에러다 !!! private멤버는 그 틀래스 내부에서만 사용가능하다.
		System.out.println("private 변수 : " + var.Value);
		
		System.out.println("default 변수 : " + var.proValue);
		// default는 같은 패키지 내에서는 사용가능하다.
		
		System.out.println("protectd 변수 : " + var.proValue);
		//다른패키지의 자식은 사용가능하다.
		
		System.out.println("public 변수 : " + var.pubValue);
	}
}
