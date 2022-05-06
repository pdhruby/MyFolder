package kr.human.thread6;


public class PrintThread extends Thread {
    SharedArea sharedArea; // 공유영역
    // 생성자
    PrintThread(SharedArea area) {   
        sharedArea = area;
    }
    // 스레드 오버라이딩
    public void run() {
       for (int cnt = 0; cnt < 3; cnt ++) {
    	    sharedArea.getTotal();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
