package kr.human.java0428;

import java.util.Scanner;

public class ExceptionEx {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("두개의 정수 입력 : ");
			int x = sc.nextInt();
			int y = sc.nextInt();
			int result = x/y;
			
			System.out.println(x+ "/"+y+"="+result);
			
			sc.close();
		}
}
