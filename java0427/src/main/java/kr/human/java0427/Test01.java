package kr.human.java0427;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

//현재 달력을 출력. 
public class Test01 {
	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now(); //현재 날짜 가져오기
		int year = now.getYear(); // 현재 년을 가져오기
		int month = now.getMonthValue(); //현재 달을 가져오기.

		// 달력 출력
		System.out.format("\n%16d년 %02d월\n\n", year, month);
		System.out.println("-".repeat(38));
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-".repeat(38));
		// 1일의 요일을 구하기
		int w = getWeek(getTotalDay(year, month, 1));
		// 1일의 위치를 맞추기 위하여 앞에 공백을 출력해주자
		for (int i = 0; i < w; i++)
			System.out.print("     ");
		// 1일부터 마지막 날짜까지 출력하자(단, 토요일이면 줄을 바꿔주자)
		for (int i = 1; i <= getLastDay(year, month); i++) {
			System.out.printf("%5d", i); // 날짜출력
			if (getWeek(getTotalDay(year, month, i)) == 6)
				System.out.println(); // 토요일이면 줄을 바꾸기.
		}
		System.out.println("\n\n");
	}


	// 요일을 숫자로 구하기(0은 일요일 ...6은 토요일)
	private static int getWeek(int total) {
		return total % 7;
	}

	// 총일수를 구하자.
	private static int getTotalDay(int year, int month, int day) {
		int total;
		// 1. 전년도까지의 일수
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		// 2. 전월까지의 일수
		for (int i = 1; i < month; i++)
			total += getLastDay(year, i);
		// 3. 일수
		total += day;
		return total;
	}

	// 주어진 년월의 마지막 날짜 구하기
	private static int getLastDay(int year, int month) {
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 월의 마지막 날짜들...
		m[1] = year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 29 : 28; // 년도가 윤년이면 2월 29일이다.
		return m[month - 1];
	}

}
