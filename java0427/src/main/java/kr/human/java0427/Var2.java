package kr.human.java0427;

public class Var2 {
	

	public void view() {
		
		Var var = new Var();
		// 같은 클래스 내부에서는 모두 사용가능하다.
	
		

		//에러다 !!! private멤버는 그 틀래스 내부에서만 사용가능하다.
		//System.out.println("private 변수 : " + var.Value);
		System.out.println("default 변수 : " + var.proValue);
		// default는 같은 패키지 내에서는 사용가능하다.
		System.out.println("protectd 변수 : " + var.proValue);
		System.out.println("public 변수 : " + var.pubValue);
	}
}
