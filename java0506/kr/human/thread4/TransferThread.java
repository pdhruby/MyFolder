package kr.human.thread4;

public class TransferThread extends Thread {
    SharedArea sharedArea;
    TransferThread(SharedArea area) {   // 생성자
        sharedArea = area;
    }
    public void run() {
       // 은행 업무 창구에서 입출금이 이루어지고 있다. 
       for (int cnt = 0; cnt < 12; cnt ++) {
            sharedArea.account1.withdraw(1000000);
            System.out.print("이몽룡 계좌에서 1000000원 출금");
            // 이분에서 작업 전환이 이루어지면 잔액이 29000000원 된다.
            sharedArea.account2.deposit(1000000);
            System.out.println("성춘향 계좌에 1000000원 입금");
        }
    }
}
