package kr.human.thread1;

import javax.swing.JOptionPane;

//싱글스레드 : 프로세스 내에 실행 흐름이 1개인 프로그램!!!
public class SingleThreadEx {
	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("이름이 뭐니?");
		JOptionPane.showMessageDialog(null, name +"씨 방가방가!!!");
		for(int i =0;i< 20;i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
