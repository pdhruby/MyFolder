package kr.human.thread5;

// 공유영역 : 은행의 모든 계좌 정보
public class SharedArea {
	Account account1; // 1번 계좌
	Account account2; // 2번 계좌

	// 계좌를 가지고 처리하는 내용은 여기에 있는것이 더 효과적이다.
	public void getTotal() {
		synchronized(this)
		{
		   int sum = account1.balance +
				   account2.balance;
		   System.out.println("계좌 합계 : " + sum);
		}
	}
	
}
