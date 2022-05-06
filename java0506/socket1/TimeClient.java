package socket1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			// 1. IP주소와 포트번호를 이용하여 서버에 접속합니다.
			System.out.println("127.0.0.1서버의 10004번포트에 접속을 시도합니다.");
			socket = new Socket("192.168.0.69", 10004);
			System.out.println("연결 성공 : " + socket);
			// 2. 서버로 부터 시간을 받는다.
			Scanner sc = new Scanner(socket.getInputStream());
			String message = sc.nextLine();
			System.out.println("서버 시간 : " + message);
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. 닫기
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
