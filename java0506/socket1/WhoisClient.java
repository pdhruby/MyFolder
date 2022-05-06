package socket1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WhoisClient {
	public static void main(String[] args) {
		// 도메인 이름의 정보를 조회하는 클라이언트를 만들어 보자
		String domainName = JOptionPane.showInputDialog("검색할 도메인 이름을 입력하시오");
		String hostName="whois.internic.net"; // 도메인 정보를 조회할 수 있는 서버
		int portNumber = 43;
		
		try(Socket socket = new Socket(hostName, portNumber)){
			// 서버로 도메인 이름을 보낸다.
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(domainName);
			pw.flush();
			
			// 서버로부터 도메인 정보를 받는다.
			Scanner sc = new Scanner(socket.getInputStream());
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			pw.close();
			sc.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
