package kr.human.tag;

import java.text.DecimalFormat;
import java.util.Random;

public class ELMethod {
	// EL로 사용할것을 정적 메서드로 만들어야 한다.
	public static String comma(int number) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(number);
	}
	public static int rand100() {
		return new Random().nextInt(101);
		
	}
	public static void main(String[] args) {
		System.out.println(ELMethod.comma(12345));
		System.out.println(ELMethod.comma(0));
		System.out.println(ELMethod.comma(12));
	}
}
