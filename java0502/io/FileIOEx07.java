package kr.human.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileIOEx07 {
	public static void main(String[] args) {

		String urlAddress = "https://images.khan.co.kr/freecomics/3843/";

		for (int i = 1; i <= 36; i++) {
			File file = new File(String.format("%03d권", i));
			if(!file.exists()) { //폴더가 존재하지 않으면
				file.mkdirs();
			}
			for (int j = 1; j <= 58; j++) {
				try{
					URL url = new URL(urlAddress + String.format("%03d/%03d.jpg", i, j));
					
					InputStream fis = url.openStream();
					FileOutputStream fos = new FileOutputStream(String.format("%03d권/%03d.jpg", i, j));
					
					byte[] data = new byte[2048];
					int n = 0;
					while ((n = fis.read(data)) > 0) { // 읽기
						fos.write(data, 0, n);
						fos.flush();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i + "권 복사완료!!!");
		}
	}
}
