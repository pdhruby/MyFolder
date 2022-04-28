package kr.human.java0428;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String str = "한놈,두식이,석삼,너구리,오징어";
		StringTokenizer st = new StringTokenizer(str);
		System.out.println(st.countTokens() + "개");

		StringTokenizer st2 = new StringTokenizer(str, ","); // 구분자를 기준으로 토큰으로 나눈다.
		System.out.println(st2.countTokens() + "개");

		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

		str = "한놈,두식이,석삼,,,너구리,,오징어";
		// 연속된 구분자 무시
		System.out.println(new StringTokenizer(str, ",").countTokens() + "개");
		System.out.println(str.split(",").length + "개");

		str = "사과=100,배=900,딸기=1000,감=300";
		// 위의 문자열을 사과(100원) 형식으로 변경하여 출력하시오
		// 세번째 인수는 구분자를 토큰에 포함할지를 지정한다.
		StringTokenizer st3 = new StringTokenizer(str, "=,", true);
		while (st3.hasMoreTokens()) {
			String temp = st3.nextToken();
			if (temp.equals(",")) // ,면 1개가 종료된다. "원)"출력하고 줄바꿈
				System.out.println("원)");
			else if (temp.equals("=")) // = 이면 금액시작 "("로 바꿔서 출력
				System.out.print("(");
			else // 값은 그냥 출력하고
				System.out.print(temp);
		}
		System.out.println("원)"); // 맨 마지막자료는 ,가 없으므로 마무리가 않된다.
	}
}
