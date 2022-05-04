package kr.human.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
reduce () 연산은 스트림의 모든 요소를 ​​결합하여 단일 값을 생성합니다.
T  reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
Optional<T> reduce(BinaryOperator<T> accumulator)
*/
public class StreamEx08 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int sum = list.stream().reduce(0, Integer::sum);
		System.out.println("합계 : " + sum);

		System.out.print("합계 : " + list.stream().reduce(0,Integer::sum));
		
		// 사원들의 수입합계
		System.out.print("\n수입합계 : " + 
				Employee.persons().stream().map(e->e.getIncome()).reduce(0.0,Double::sum));

		System.out.print("\n수입합계 : " + 
				Employee.persons().stream()
				.reduce(0.0, (pSum, person)->pSum+person.getIncome(), Double::sum)
				);
		
		//                                                     누산기                         결합기          
		// <U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
		double sum2 = Employee.persons().stream()
				.reduce(0.0, (Double partialSum, Employee emp)->{
					double acc = partialSum + emp.getIncome();
					System.out.println(Thread.currentThread().getName() + 
							" - accumulator : partialSum = " + partialSum + 
							" Employee = " + emp + ", " + acc);
					return acc;
				},
				(a,b) ->{
					double comb = a + b;
					System.out.println(Thread.currentThread().getName() + 
							" - combiner : a = " + a + ", b = " + b + 
							" combiner = " + comb);
					return comb;
				});
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("수입합계 : " + sum2);
		
		sum2 = Employee.persons().parallelStream() // 병렬 스트림 : 멀티스레드 처럼 작동
				.reduce(0.0, (Double partialSum, Employee emp)->{
					double acc = partialSum + emp.getIncome();
					System.out.println(Thread.currentThread().getName() + 
							" - accumulator : partialSum = " + partialSum + 
							" Employee = " + emp + ", " + acc);
					return acc;
				},
				(a,b) ->{
					double comb = a + b;
					System.out.println(Thread.currentThread().getName() + 
							" - combiner : a = " + a + ", b = " + b + 
							" combiner = " + comb);
					return comb;
				});
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("수입합계 : " + sum2);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		
		// Optional<T> 결과를 래핑하거나 결과가없는 경우 사용됩니다.
		
		Optional<Integer> max = Stream.of(1,2,3,4,5,6).reduce(Integer::max);
		System.out.println(max);
		if(max.isPresent()) {
			System.out.println("최대값 : " + max.get());
		}else {
			System.out.println("값이 없어요!!!");
		}
		
		max = Stream.<Integer>empty().reduce(Integer::max);
		if(max.isPresent()) {
			System.out.println("최대값 : " + max.get());
		}else {
			System.out.println("값이 없어요!!!");
		}
		
		Optional<Employee> person = Employee.persons().stream()
									.reduce((e1, e2)->e1.getIncome()>e2.getIncome() ? e1 : e2);
		
		if(person.isPresent()) {
			System.out.println("최대 수입인 사람 : " + person.get());
		}else {
			System.out.println("값이 없어요!!!");
		}
		
		
		
		
	}
}
