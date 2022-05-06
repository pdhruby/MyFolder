package kr.human.thread1;

import javax.swing.JOptionPane;

//멀티스레드 : 프로세스 내에 실행 흐름이 여러개인 프로그램!!! 모든스레드가 종료해야 프로그램 종료
public class MultiThreadEx02 {
	public static void main(String[] args) {
		
		new Thread() {
			@Override
			public void run() {
				for(int i =0;i< 20;i++) {
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //스레드 객체를 만들어 실행\
					
				}
			}
		}.start();

		
		
		String name = JOptionPane.showInputDialog("이름이 뭐니?");
		JOptionPane.showMessageDialog(null, name +"씨 방가방가!!!");

		
	}
}
