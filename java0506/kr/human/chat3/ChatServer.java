package kr.human.chat3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 멍청한 1:1채팅을 만들어보자.  상대편이 답을 하지 않으면 보내지 못하는 채팅 
public class ChatServer {
	public static void main(String[] args) {
		// 1. 변수 준비
		ServerSocket serverSocket=null;
		Socket       socket = null;
		try {
			// 2.서버소켓을 만들어 접속을 대기한다.
			serverSocket = new ServerSocket(1004);
			System.out.println("접속대기중....");
			socket = serverSocket.accept();
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
			try {
				// 여기서 클라언트 소켓을 닫아주면 않됨
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
