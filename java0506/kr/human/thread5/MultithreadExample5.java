package kr.human.thread5;
/*
이 프로그램의 문제점 : 엉뚱한 시점에 작업 전환이 이루어지기 때문이다.
ciritical section : 멀티 스레드 프로그램은 CPU에 의해서 작업전환이 자동으로 이루어진다.
                    작업 전환이 이루어지면 문제가 발생할 소지가 있는 부분을 ciritical section이라 한다.
 */
public class MultithreadExample5 {
    public static void main(String args[]) {
        SharedArea area = new SharedArea();
        area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
        area.account2 = new Account("222-222-2222", "성춘향", 10000000);
        TransferThread thread1 = new TransferThread(area);
        PrintThread thread2 = new PrintThread(area);
        thread1.start();
        thread2.start();
    }
}
