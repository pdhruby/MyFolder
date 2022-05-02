package kr.human.io2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// 문자 단위 입출력하는 클래스들은 클래스명이 Reader, Writer로 끝난다.
public class TextIOEx01 {
	public static void main(String[] args) {
		// 문자 단위 출력
		try(FileWriter fw = new FileWriter("text.txt")){
			fw.write("저장이 될까요?\n");
			fw.write("정말 저장이 될까요?\n");
			fw.write("진짜 저장이 될까요?\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 문자 단위 입력
		try(FileReader fr = new FileReader("text.txt")){
			int n = 0;
			while((n=fr.read())>0) { // 1글자씩 읽기
				System.out.print((char)n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(60));
		
		// 문자 단위 입력
		try(FileReader fr = new FileReader("text.txt")){
			int n = 0;
			char[] data = new char[1024];
			while((n=fr.read(data))>0) { // char배열로 읽기
				System.out.print(new String(data, 0, n));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(60));
		
		// BufferedReader는 readLine()으로 1줄씩 읽기 가능
		try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
			String line="";
			while((line=br.readLine())!=null) System.out.println(line); // 1줄씩 읽기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(60));
		
		try(Scanner sc = new Scanner(new File("text.txt"))){
			while(sc.hasNextLine()) System.out.println(sc.nextLine()); // 1줄씩 읽기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("-".repeat(60));
	}
}
