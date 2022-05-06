package socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) {
		// 서버
		ServerSocket serverSocket = null;
		Socket       clientSocket = null;
		
		try {
			// 1. 포트번호를 인수로 서버를 시작한다.
			serverSocket = new ServerSocket(10004);
			System.out.println("127.0.0.1의 10004번 포트를 열어 서버를 시작!!!");
			// 2. client의 요청을 무한대기한다.
			System.out.println("클라이언트의 접속을 기다립니다.");
			clientSocket = serverSocket.accept();
			System.out.println("연경 성공 : " + clientSocket);
			
			// 3. 연결되면 클라이언트로 부터 정보를 받고 보낸다.
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			// 받기
			Scanner sc = new Scanner(is);
			System.out.println("받은 내용 : " + sc.nextLine());
			// 보내기
			PrintWriter pw = new PrintWriter(os);
			pw.write("반갑다 클라이언트!!!!!\n\n\n\n");
			pw.flush();

			pw.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4. 닫기
				clientSocket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

