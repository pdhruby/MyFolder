package kr.human.thread7;

public class ProgressThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("계산중");
		while(true) {
			System.out.println(".");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
