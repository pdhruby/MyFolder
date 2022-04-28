package kr.human.java0428;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// 윈도우를 종료하는 기능의 외부 클래스
class WinClose extends WindowAdapter {

}

public class WinEx {
	public static void main(String[] args) {
		JFrame frame = new JFrame("내부클래스 예제"); // 윈도우 만들고
		frame.setSize(500, 500); // 크기 지정
		frame.setLocationRelativeTo(null); // 화면 중앙에 나타나게 하고
		
		// 윈도우가 닫힐때 프로그램도 종료하라고 지정한다
		//WinClose close = new WinClose();
		//frame.addWindowListener(close);
		//frame.addWindowListener(new WinClose()); // 위의 두줄을 1줄로
		

		//내부 클래스로 만드는것이 관리상 편리하다. 하지만 1회성 용도이다.
		// 그렇다면 익명내부클래스로 만들어서 쓰면 더 좋지 않을까?
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); // 프로그램 강제 종료!!! 숫자는 0은 정상 종료 -1은 비 정상종료
			}
		});
		
		frame.setLayout(new FlowLayout()); // 컴포넌트들을 옆으로 배치하라고 배치 관리자 지정

		final JButton button = new JButton("눌러줘!!"); // 버튼생성
		// 버튼 클릭시 이벤트를 지정한다.
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button, "왜눌러");
			}
		});
		
		frame.add(button);
		
		
		frame.setVisible(true); // 이제 보여줘!!!
	}
}
