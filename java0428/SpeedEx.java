package kr.human.java0428;

public class SpeedEx {
	public static void main(String[] args) {
		String str = "";
		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();
		
		
	
		//String 객체는 불변객체이다. 변할수 없다. 연산을 하면 항상 새로운 객체를 만들어서 리턴
		
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			str += "꽝";
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
		// StringBuffer 나  StringBuilder 는 가변객체로 연산을 하면 자기 자신ㅂ변경한다.
		// StringBuilder 는 멀티스레드 프로그램에 안전하게 설계되어있고
		// StrinNGIMPERSTAMDP=][\\\
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			sBuffer.append("꽝");
		}
		
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			sBuilder.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
	}
}
