package ko.human.java0429;

import java.util.LinkedList;

// Queue : 입력과 출력이 앞뒤로 있는 자료구조. First In Fist Out(FIFO) 자료구조
public class Queuex03 {
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue.size()+"개 :" +queue);
		System.out.println(queue.poll());
		
		while(!queue.isEmpty())
			System.out.println(queue.poll());
	}

}
