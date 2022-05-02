package kr.human.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx09 {
	public static void main(String[] args) {
		//자료형별로 저장이 가능하다.
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("data1.dat"));
			dos.writeByte(123);
			dos.writeInt(345);
			dos.writeDouble(3.14);
			dos.writeUTF("한글!!!");
			dos.flush();
			System.out.println("데이터 타입별로 저장하기");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("data1.dat"))){
			// 데이터를 정확하게 읽으려면 저장 순서를 반드시 알아야 한다.
			byte b = dis.readByte();
			int i = dis.readInt();
			double d = dis.readDouble();
			String str = dis.readUTF();
			
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
			System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
