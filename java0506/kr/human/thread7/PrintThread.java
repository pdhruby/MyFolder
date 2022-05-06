package kr.human.thread7;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 소비자 스레드 : 공유 영역의 데이터를 소모하는 스레드
@NoArgsConstructor
@Getter
@Setter
public class PrintThread extends Thread {
    private SharedArea sharedArea;
    public void run() {
        if(!sharedArea.isReady()) {// 스레드를 대기 상태로 만든다.
        } 
        	try { 
        		//wait 메서드는 반드시 동기화 블록으로 감싸줘야 한다.
        		synchronized (sharedArea) {
    				sharedArea.wait();	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
        }
    	System.out.println(sharedArea.getResult());
    }
}
