package kr.green.chat5;
// 현재 접속자들의 목록을 가지고 있다가 메세지가 입력되면 모든 접속자에게 동일한 메세지를 전송하는 스레드 

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PerClientThread extends Thread{
	// 모든 접속자의 목록을 가지고는 리스트를 작성 --- 모든 사용자가 공유를 한다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>()); // 동기화 리스트로 작성
	// 클라이언트 소켓
	Socket socket;
	// 출력스트림
	PrintWriter pw;
	
	// 생성자 : 소켓을 받아 출력스트림을 만들어 리스트에 추가한다.
	public PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			pw = new PrintWriter(this.socket.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		super.run();
		// 최초의 전송되는 내용은 사용자의 이름이다.
		String name = null;
		Scanner sc = null;
		try {
			sc = new Scanner(socket.getInputStream());
			name = sc.nextLine().trim(); // 최초의 전송되는 내용은 사용자의 이름이다.
			sendAll("#" + name + "님이 입장하셨습니다.");
			sendAll("#현재 " + list.size() + "명이 대화중입니다.");
			while (true) {
				String message = sc.nextLine();
				if(message==null) break;
				sendAll(name + ">" + message);
			}
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			sendAll("#" + name + "님이 퇴장하셨습니다.");
			sendAll("#현재 " + list.size() + "명이 대화중입니다.");
			try {
				if(socket!=null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// 모든 접속자에게 메세지를 보내는 메서드
	private void sendAll(String message) {
		for(PrintWriter pw : list) {
			pw.println(message);
			pw.flush();
		}
	}
}
