package kr.human.thread3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 소비자 스레드 : 공유 영역의 데이터를 소모하는 스레드
@NoArgsConstructor
@Getter
@Setter
public class PrintThread extends Thread {
    private volatile SharedArea sharedArea;
    public void run() {
    
    	/* 이 반복문의 문제가 발생을 한다.
    	 * 반복문 안에서 isReady값이 변경되지 않는다.
    	 * 자바 컴파일러는 알아서 무한루프로 변경해서 컴파일 한다.
    	 * 반복문 내에서 isReady값이 변경되지 않지만 외부에서 변경이되어 종료되는 프로그램이다.
    	 * 이럴때 컴파일러 보고 제멋대로 해석하지 말라고 지정해 주어야 한다.
    	 * 이떄 사용하는 지시어가 "volatitle"이다.
    	 */ 
    	//계산이 완료되기 전까지는 헛돌기를 한다.
    	while(sharedArea.isReady()!= true) {
    		continue;
    	}
        System.out.println(sharedArea.getResult());
    }
}
