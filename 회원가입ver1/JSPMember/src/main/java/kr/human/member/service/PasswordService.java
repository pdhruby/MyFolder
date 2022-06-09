package kr.human.member.service;

import java.util.Random;

public class PasswordService {
	public static String makeNewPassword() {
		Random random = new Random();
		String newPassword ="";
		
		for(int i=0; i<10; i++) {
			switch (random.nextInt(4)) {
			case 0:
				newPassword += random.nextInt(10);
				break;
			case 1:
				newPassword += (char)('A'+random.nextInt(26));
				break;
			case 2:
				newPassword += (char)('a'+random.nextInt(26));
				break;
			case 3:
				newPassword += "~!@#$%^&*+-".charAt(random.nextInt(11));
				break;

			default:
				break;
			}
		}
		return newPassword;
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i<10; i++)
		{
			System.out.println(makeNewPassword());
		}
	}
}
