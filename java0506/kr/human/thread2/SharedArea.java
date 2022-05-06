package kr.human.thread2;

import lombok.Data;

// 두개의 스레드가 데이터를 공유하는 클래스
@Data
public class SharedArea {
    private double result;
}
