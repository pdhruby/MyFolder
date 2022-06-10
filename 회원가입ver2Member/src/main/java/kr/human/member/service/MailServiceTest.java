package kr.human.member.service;

public class MailServiceTest {
	public static void main(String[] args) {
		EmailService.sendMail("ithuman202204@gmail.com", "제목", "<h1>내용입니다.</h1>");
	}
}
