package kr.human.thread6;

// 공유영역 : 은행의 모든 계좌 정보
public class SharedArea {
    Account account1;   // 1번 계좌
    Account account2;   // 2번 계좌
    
    // 계좌를 가지고 처리하는 내용은 여기에 있는것이 더 효과적이다.
    public void getTotal() {
    	// 이부분도 작업 전환이 이루어지면 않된다.
 	   synchronized (this) {
 		   int sum = account1.balance + account2.balance;
 		   System.out.println("계좌 합계 : " + sum);
 	   }
    }
    
    public void transfer() {
    	// 동기화 블록 : 작업 전환이 이루어지지 말아라~~~
 	   synchronized (this) {
 		   account1.withdraw(1000000);
 		   System.out.print("이몽룡 계좌에서 1000000원 출금");
 		   // 이분에서 작업 전환이 이루어지면 잔액이 29000000원 된다.
 		   account2.deposit(1000000);
 		   System.out.println("성춘향 계좌에 1000000원 입금");
 	   }
    }
    
    //위의 두개 메서드를 보면 메서드 내용 전체가 동기화 블록이다.
    // 이때는 동기화블록 보다는 동기화 메서드로 만드는것이 더 효과적이다.
    
}
