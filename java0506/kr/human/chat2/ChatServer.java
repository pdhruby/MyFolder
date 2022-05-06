package kr.human.chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 멍청한 1:1채팅을 만들어보자.  상대편이 답을 하지 않으면 보내지 못하는 채팅 
public class ChatServer {
	public static void main(String[] args) {
		// 1. 변수 준비
		ServerSocket serverSocket=null;
		Socket       socket = null;
		PrintWriter  pw = null;
		Scanner      sc = null;
		try {
			// 2.서버소켓을 만들어 접속을 대기한다.
			serverSocket = new ServerSocket(1004);
			System.out.println("접속대기중....");
			socket = serverSocket.accept();
			System.out.println("접속 성공 : " + socket);
			
			// 3. 통신을 하기 위해 보내고 받는 스트림을 얻는다.
			pw = new PrintWriter(socket.getOutputStream());
			sc = new Scanner(socket.getInputStream());
			// 4. 메세지를 보내고 받아보자!!
			String message = "";
			Scanner userScanner = new Scanner(System.in);
			do {
				// 보낼 메세지를 입력받아 보낸다.
				System.out.print("보낼 메세지 입력 : ");
				message = userScanner.nextLine();
				pw.println(message);
				pw.flush();
				// 보내온 메세지를 읽어 출력한다.
				message = sc.nextLine();
				System.out.println("받은 내용 : " + message);
			}while(message!=null && !message.equals(""));
			userScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 5. 닫기
			try {
				sc.close();
				pw.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
