package kr.human.thread1;
// 스레드를 만드는 방법 2가지
// 1. Thread클래스를 상속받아 run()을 오버라이딩한다.
class AlphabetThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<26;i++) {
			System.out.print((char)('A'+i));
			try {Thread.sleep(500);}catch (Exception e) { ; }
		}
		System.out.println("\n알파벳스레드 종료!!!");
	}
}
// 2. Runnable 인터페이스를 구현한다.
class KoreaThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<26;i++) {
			System.out.print((char)('ㄱ'+i));
			try {Thread.sleep(500);}catch (Exception e) { ; }
		}
		System.out.println("\n한글스레드 종료!!!");
	}
}
public class ThreadEx01 {
	public static void main(String[] args) {
		// 시작하는 방법이 다르다!!!!
		Thread thread1 = new AlphabetThread(); // 직접 객체 생성
		Thread thread2 = new Thread(new KoreaThread()); // 스레드 생성자에 인수로 전달
		thread1.start(); //반드시 start()를 호출한다. run()을 호출하면 스레드로 작동되지 않는다.
		thread2.start();
		System.out.println("\n메인스레드 종료!!!");
	}
}
