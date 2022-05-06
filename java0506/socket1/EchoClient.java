package socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		// 서버에 접속하는 클라이언트를 만들자
		Socket clientSocket = null;
		
		try {
			// 1. IP주소와 포트번호를 이용하여 서버에 접속한다.
			clientSocket = new Socket("192.168.0.10", 10004);
			System.out.println("연결성공 : " + clientSocket);
			// 2. 통신을 한다.
			// 3. 연결되면 클라이언트로 부터 정보를 보내고 받는다.
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			// 보내기
			PrintWriter pw = new PrintWriter(os);
			pw.write("");
			pw.flush();
			// 받기
			Scanner sc = new Scanner(is);
			System.out.println("받은 내용 : " + sc.nextLine());

			sc.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

