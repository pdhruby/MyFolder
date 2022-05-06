package kr.human.chat3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 데이터를 받아서 출력해주는 스레드
public class ReceiveThread extends Thread{
	Socket  socket;
	Scanner scanner;
	// 생성자에서 소켓을 받아 입력받는 스캐너 객체를 만든다.  
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			scanner = new Scanner(this.socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		super.run();
		String msg = "";
		// 받은 메세지가 bye가 아닌동안 반복
		while(!msg.equalsIgnoreCase("bye")) {
			if(socket!=null && scanner.hasNextLine()) {
				msg = scanner.nextLine();
				System.out.println("받은내용 : " + msg);
			}
		}
		// 닫기
		try {
			scanner.close();
			if(socket!=null)socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
