package kr.green.chat5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GUIChatServer extends JFrame {
	JTextArea messageTA;
	ServerSocket serverSocket;
	
	public GUIChatServer() {
		super("멀티 채팅 서버 Ver 0.0009");
		setSize(500, 700);
		setLocationRelativeTo(null);
		// 종료시 서버 소켓을 닫아주고 프로그램을 완전히 종료한다.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 서버 소켓을 닫고 종료한다.
				if(serverSocket!=null)
					try {
						serverSocket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				System.exit(0);
			}
		});
		setLayout(new BorderLayout());
		messageTA = new JTextArea(15, 33); // 출력창 생성
		messageTA.setEditable(false); // 수정 불가
		messageTA.setFont(new Font("굴림", Font.BOLD, 16)); // 폰트 변경
		JScrollPane jScrollPane = new JScrollPane(messageTA); // 스크롤 가능하게 만들기
		add(jScrollPane, BorderLayout.CENTER); // 화면 중앙에 배치
		
		try {
			serverSocket = new ServerSocket(9898);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
			messageTA.append(sdf.format(new Date()) + "에 9898포트로 서버를 시작했습니다.\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GUIChatServer server = new GUIChatServer();
		while(true) { // 무한대로 클라이언트의 접속을 받아준다.
			try {
				// 접속대기
				Socket socket = server.serverSocket.accept();
				// 접속하면 스레드를 시작한다.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
				server.messageTA.append(sdf.format(new Date()) + "에 " + socket.getInetAddress() + "에서 접속함!!!!\n");
				// 스레드 시작 --- 접속자 1명단 스레드가 1개씩 생성된다.
				new PerClientThread(socket).start();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	}
	
}
