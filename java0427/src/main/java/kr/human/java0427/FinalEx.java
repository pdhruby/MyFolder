package kr.human.java0427;



class Some2{
	// 메서드 앞에 final 이 붙으면 오버라이딩 금지!!!!
	final public void show() {
		System.out.println("나는 오버라이딩할 수 없다!!!.");
	}
}

// 클래스앞에 final이 붙으면 상속 금지!!!
final class FinalClass{
	
}

//에러다!!!! final 클래스는 상속 금지!!!
class ChildFinalClass extends FinalClass{
	
}


class ChildSome2 extends Some2{
	// 에러다!!!! 왜? final 메서드는 오버라이딩 금지!!!
	final public void show() {
		System.out.println("나는 오버라이딩할 수 없다!!!.");
	}
}
public class FinalEx {
	//변수명 앞에 final이 붙으면  변경금지!!!
	static final int MAX = 1024;
	
	public static void main(String[] args) {
		System.out.println("MAX = " + MAX);
		//Max = 2048; // 에러난다 변경할수 없다.
	}
}
