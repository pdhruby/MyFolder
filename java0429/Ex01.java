package ko.human.java0429;

import java.util.Arrays;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		// 자바 클래스의 최고 조상이 object이기 떄문에 무엇이든 담을수 있지만 
		Object[] objects = {1,1.2,"문자열", new Date()};
		System.out.print(Arrays.toString(objects));
		
		for(int i=0; i<objects.length; i++) {
			System.out.println(objects[i]);// 출력이라면 가능!!!
											// 가공 처리한다면?
			
			//항상 형변환해서 사용해야 한다.
			if(i==0) {
				Integer ii = (Integer)objects[i];
			}else if(i==1) {
				Double dd = (Double)objects[i];
			
			}
		}
	}
}
