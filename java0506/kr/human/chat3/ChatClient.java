package kr.human.chat3;

import java.io.IOException;
import java.net.Socket;

// 멍청한 1:1채팅을 만들어보자.  상대편이 답을 하지 않으면 보내지 못하는 채팅 
public class ChatClient {
	public static void main(String[] args) {
		// 1. 변수 준비
		Socket       socket = null;

		try {
			// 2.소켓을 만들어 접속을 한다.
			System.out.println("접속 중....");
			socket = new Socket("127.0.0.1", 1004);
			System.out.println("접속 성공 : " + socket);
			
			// 3. 스레드를 시작한다.
			ReceiveThread receiveThread = new ReceiveThread(socket);
			SendThread sendThread = new SendThread(socket);
			
			receiveThread.start();
			sendThread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5. 닫기
			/*
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
		}
	}
}
