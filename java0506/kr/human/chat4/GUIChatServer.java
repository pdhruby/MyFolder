package kr.human.chat4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// 메인스레드에서는 보내기를 하고 별도로 만든 스레드에서는 받기를 수행
@SuppressWarnings("serial")
public class GUIChatServer extends JFrame implements Runnable, ActionListener{
	// 프로그램에서 제어할 컴포넌트들을 필드로 선언
	JButton 	sendBtn;
	JTextField 	messageTF;
	JTextArea	messageTA;
	// 네트워크에 필요한 변수
	Socket      socket; // 통신
	PrintWriter pw;     // 보내기
	Scanner     sc;     // 받기
	
	// 생성자에서 디자인
	public GUIChatServer(){
		super("허접한 채팅 Ver 0.0009");
		setSize(550, 700); // 크기지정
		setLocationRelativeTo(null); // 화면중앙배치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료지정
		setLayout(new BorderLayout()); // 레이아웃메니저지정
		// 하단 디자인
		JPanel bottomPanel = new JPanel(); // 여러개를 묶기위한 판넬생성
		bottomPanel.setBorder(BorderFactory.createEtchedBorder()); // 테두리 지정
		messageTF = new JTextField(40); // 입력란 작성
		messageTF.addActionListener(this); // 이벤트 지정
		bottomPanel.add(messageTF); // 판넬에 붙이기
		sendBtn = new JButton("전송"); // 버튼 생성
		sendBtn.addActionListener(this); // 이벤트 지정
		bottomPanel.add(sendBtn); // 판넬에 붙이기
		add(bottomPanel, BorderLayout.SOUTH); // 판넬은 윈도우 하단에 붙이기
		// 중앙디자인
		messageTA = new JTextArea(15, 33); // 출력창 생성
		messageTA.setEditable(false); // 수정 불가
		messageTA.setFont(new Font("굴림", Font.BOLD, 16)); // 폰트 변경
		JScrollPane jScrollPane = new JScrollPane(messageTA); // 스크롤 가능하게 만들기
		add(jScrollPane, BorderLayout.CENTER); // 화면 중앙에 배치
		
		setResizable(false); // 크기변경 못하게
		setVisible(true); // 보여줘
	}
	public static void main(String[] args) {
		GUIChatServer server = new GUIChatServer();
		// 접속전에는 버튼과 텍스트 필드 접근 금지
		server.sendBtn.setEnabled(false);
		server.messageTF.setEnabled(false);
		// 서버를 시작
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			server.messageTA.append("서버시작.....\n");
			server.messageTA.append("클라언트의 접속을 기다립니다.....\n");
			// 접속대기
			server.socket = serverSocket.accept();
			// 접속되면
			server.messageTA.append(server.socket.getInetAddress().getHostAddress() + " 클라언트가 접속했습니다.....\n");
			server.pw = new PrintWriter(server.socket.getOutputStream());
			server.sc = new Scanner(server.socket.getInputStream());
			
			// 접속후에는 버튼과 텍스트 필드 접근
			server.sendBtn.setEnabled(true);
			server.messageTF.setEnabled(true);
			server.messageTF.requestFocus(); // 커서위치 지정
			
			// 받는 스레드 시작
			Thread thread = new Thread(server);
			thread.setDaemon(true);
			thread.start();
			
			// 서버소켓 닫기
			if(serverSocket!=null) serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {// 텍스트 필드에서 엔터를 치거나 전송 버튼을 누르면 작동할 메서드
		String message = messageTF.getText(); // 입력내용 읽고
		if(message!=null && !message.trim().equals("")) {
			// 내화면에 표시
			messageTA.append("나> "  + message + "\n");
			messageTF.setText("");
			messageTF.requestFocus();
			// 상대방 화면에도 나와야 한다.
			pw.write(message + "\n");
			pw.flush();
		}
	}

	@Override
	public void run() { // 상대방에서 넘어온 데이터를 읽어서 화면에 출력한다.
		String message = "";
		while(!message.equalsIgnoreCase("bye")) {
			message = sc.nextLine();
			messageTA.append("너> "  + message + "\n");
		}
	}

}
