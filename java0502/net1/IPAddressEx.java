package kr.human.net1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressEx {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			System.out.println(address.getHostName());
			System.out.println(address.getHostAddress());
			System.out.println("-".repeat(50));
			
			InetAddress[] inetAddresses = InetAddress.getAllByName("name.com");
			for(InetAddress addr : inetAddresses) {
				System.out.println(addr);
			}
			
			System.out.println("-".repeat(50));
			
			
			System.out.println(InetAddress.getLocalHost());
			System.out.println(InetAddress.getLoopbackAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
