package kr.human.MavenEx;

public class CardTest {
	public static void main(String[] args) {
		
		for(int i=0; i<52; i++) {
			CardVO cardVO = new CardVO(i);
			System.out.print(cardVO +" ");
			if((i+1)%13==0) System.out.println();
		}
	}
}
