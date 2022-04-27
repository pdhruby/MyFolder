package kr.human.java0427;

import kr.human.vo.PersonVo;

public class ex02 {
	public static void main(String[] args) {
	
		// 패키지가 다른 동일한 이름의 클래스를 여러개 사용하려면 
		// 많이 사용하는 패키지를 임포트하고 적게 사용하는 클래스는 
		// 전체이름을 써서 사용하면 된다.(패키지전체이름.클래스명)
		PersonVo vo1 = new PersonVo();
		
		kr.human.vo2.PersonVo vo2 = new kr.human.vo2.PersonVo();
		
	}

}
