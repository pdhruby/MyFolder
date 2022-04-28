package kr.human.java0428;

import java.net.InterfaceAddress;

/*
 * 내부 클래스 : 클래스 내부에 클래스를 만든다. 책은 9장!!!
 *               묶어 놓는것이 더 효과적일때, 외부 클래스의 변수에 쉽게 접근하기 위해서
 * 인스턴스 내부 클래스 
 * 정적 내부 클래스 : static이 붙은 내부 클래스
 * 로컬 내부 클래스 : 메서드 안에 만든 클래스. 메서드 안에서만 사용
 */

class Outer{
	private int outer = 11;
	static int sOuter = 22;
	//인스턴스 내부 클래스 
	class InstanceInner{
		int ii = 33;
		public void show() {
			outer = 44444;
			System.out.println(outer);
			System.out.println(sOuter);
			System.out.println(ii);
		}
		/*
		public static void staticShow() {
			//System.out.println(outer);
			System.out.println(sOuter);
			//System.out.println(ii);
		}
		*/
	}
	//정적 내부클래스
	static class StaticInner{
		int si = 44;
		static int ssi = 55;
		public void show() {
			final int x  = 10;
			// 로컬 클래스 : 메서드 안에서 만들어 사용한다. 메서드내에서만 사용가능
			class LocalClass{
				public void show() {
					System.out.println(x); // 1.7 이전에는 final인 지역변수만 접근 가능
				}
			}
			
			LocalClass localClass = new LocalClass();
			
			//System.out.println(outer);
			System.out.println(sOuter); // static 클래스에서는 static멤버만 사용가능
			System.out.println(si);
			System.out.println(ssi);
		}
		public static void staticShow() {
			// System.out.println(outer);
			System.out.println(sOuter);
			// System.out.println(si);
			System.out.println(ssi);
		}
	}
}
public class InnerClassEx {
	interface Show{
		void showMessage(String message);
		
	}
	
	
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		System.out.println(outer.sOuter);
		System.out.println(Outer.sOuter);
		
		//인스턴스 내부클래스의 객체 생성
		Outer.InstanceInner ii = outer.new InstanceInner();
		ii.show();
		
		
		//정적 내부클래스의 객체 생성 
		Outer.StaticInner si = new Outer.StaticInner();
		si.show(); // 인스턴스 메서드의 호출
		Outer.StaticInner.staticShow(); // 정적메서드의 호출
	
		//인터페이스에 new를 붙이면 어떻게 될까?
		//인터페이스를 구현함과 동시에 객체를 생성해서 메서드까지 호출한다.
		//익명 내부 클래스 : 다른곳에서는 사용하지 않고 이곳에서 딱1번만 사용할 경우에 쓴다
		new Show() {
			
			public void showMessage(String message) {
				System.out.println("-=["+message + "]=-");
			}
		}.showMessage("익명 내부클래스의 호출");
	
	}
}
