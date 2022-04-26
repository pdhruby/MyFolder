package kr.human.MavenEx;

public class initEx {
	public static void main(String[] args) {
		InitValue initValue;
		initValue = new InitValue();
		
		InitValue.viewStaticMember();
		
		//인스턴스변수의 초기화는 생성자에서하고
		//정적 변수의 초기화(복잡할경우)는 정적 초기화 블록에서 처리
	}
}
