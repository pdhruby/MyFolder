package kr.human.thread2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 생산자 스레드 : 데이터를 만들어 주는 스레드 
@NoArgsConstructor
@Getter
@Setter
public class CalcThread extends Thread {
    
	private SharedArea sharedArea;
    
    public void run() {
    	// 무한 급수를 이용하여 원주율을 구해서 공유 영역에 저장해준다. 
        double total = 0.0;
        for (int cnt = 1; cnt < 1000000000; cnt += 2)
            if (cnt / 2 % 2 == 0)
                total += 1.0 / cnt;
            else
                total -= 1.0 / cnt;
        //System.out.println("원주율 : " + (total * 4));
        sharedArea.setResult(total * 4);
    }
}
