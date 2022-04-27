package kr.human.java0427;

public class Var {
	private int priValue = 11;
	int defValue = 22;
	protected int proValue =3;
	public int pubValue = 4;

	public void view() {
		// 같은 클래스 내부에서는 모두 사용가능하다.
		System.out.println("private 변수 : " + priValue);
		System.out.println("default 변수 : " + defValue);
		System.out.println("protectd 변수 : " + proValue);
		System.out.println("public 변수 : " + pubValue);
	}
}
