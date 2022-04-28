package kr.human.java0428;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Name{
	private String name;
	
	// 소멸자 : 자바 객체가 소멸될때 자동으로 실행되는 메서드
	@Override
	protected void finalize() throws Throwable {
		System.out.println(name+"님이 돌아가셨습니다.");
	}
}

public class FinalizeEx {
	public static void main(String[] args) {
		Name name = new Name("한사람");
		Name name2 = new Name("두사람");
		System.out.println(name);
		System.out.println(name2);
		
		// 사용한 객체들에게 null을 대입하면 가비지컬렉터(쓰레기 수집기,메모리 정리)가
		// 메모리에게 아무것도 참조하지 않는 객체를 제거하는데 도움이 된다.
		name = null;
		System.gc(); //JVM에게 메모리 정리를 될 수 있는한 빨리해라라고 부탁한다.
	}
}
