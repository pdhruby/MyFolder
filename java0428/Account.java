package kr.human.java0428;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account { //은행 계좌 정보
	private String accountNo; // 계좌번호
	private String ownwerName;  // 예금주
	private int balance; // 잔액

	//입금 
	public void deposit(int amount) {
		balance +=amount;
	}
	
	//출금
	public int withdraw(int amount) throws Exception { // 이메서드는 예외를 발생시키는 메서드다.
														// 이메서드를 사용하는 쪽에서 반드시 예외처리하도록 강제한다.
		if(balance < amount) {
			throw new Exception("잔액이 부족합니다."); // 예외던지기 
		}
		balance -= amount;
		return amount;
	}
}

