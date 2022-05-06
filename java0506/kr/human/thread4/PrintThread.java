package kr.human.thread4;

public class PrintThread extends Thread {
    SharedArea sharedArea; // 공유영역
    // 생성자
    PrintThread(SharedArea area) {   
        sharedArea = area;
    }
    // 스레드 오버라이딩
    public void run() {
       for (int cnt = 0; cnt < 3; cnt ++) {
    	   // 이부분도 작업 전환이 이루어지면 않된다.
           int sum = sharedArea.account1.balance +
                     sharedArea.account2.balance;
            System.out.println("계좌 합계 : " + sum);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
