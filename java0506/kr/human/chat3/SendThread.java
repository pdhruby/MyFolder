package kr.human.chat3;
// 메세지를 보내는 스레드

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	Socket      socket;
	PrintWriter pw;
	Scanner     scanner;
	// 생성자에서 소켓을 받아 멤버를 초기화 하자
	public SendThread(Socket socket) {
		this.socket = socket;
		try {
			this.pw = new PrintWriter(this.socket.getOutputStream());
			scanner = new Scanner(System.in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// run메서드 오버라이딩
	@Override
	public void run() {
		super.run();
		//키보드로 입력받아 상대변느로 전송한다.
		String msg="";
		while(socket!=null && !msg.equalsIgnoreCase("bye")) {
			System.out.print("보낼 내용 : " );
			msg = scanner.nextLine();
			pw.println(msg);
			pw.flush();
		}
		try {
			pw.close();
			scanner.close();
			if(socket!=null) socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
