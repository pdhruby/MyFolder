package kr.human.util;

public class CalcUtil {
	public static int sum(int n){
	int s = n;
	while(n>=1){
		s+=--n;
	}
	return s;
	}


}
