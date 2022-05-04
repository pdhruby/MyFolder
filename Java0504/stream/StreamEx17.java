package kr.human.stream;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
수집기의 결과를 다른 유형으로 변환 할 수 있습니다.
Collectors 클래스의 collectorAndThen () 메서드는 다음과 같이 정의됩니다.
collectingAndThen(Collector<T,A,R> downstream, Function<R,RR>  finisher)
첫 번째 인수는 데이터를 수집하는 수집기입니다. 두 번째 인수는 결과를 변환하는 마무리 장치입니다.

스트림 요소에 대한 다양한 유형의 찾기 작업을 지원합니다.
Stream 인터페이스의 다음 메서드는 찾기 작업을 수행하는 데 사용됩니다.
Optional<T>   findAny()
Optional<T>   findFirst()
 */
public class StreamEx17 {
	public static void main(String[] args) {
		List<Employee> list = Employee.persons();

		List<String> list1= list.stream()
				            .map(Employee::getName)
				            .collect(Collectors.collectingAndThen(Collectors.toList(), result->Collections.unmodifiableList(result)));
		System.out.println(list1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Optional<Employee> anyFemale = list.stream().filter(Employee::isFemale).findAny();
		if(anyFemale.isPresent()) {
			System.out.println("any Female : " + anyFemale.get());
		}else {
			System.out.println("없다~~~~");
		}

		Optional<Employee> firstFemale = list.stream().filter(Employee::isFemale).findFirst();
		if(firstFemale.isPresent()) {
			System.out.println("First Female : " + firstFemale.get());
		}else {
			System.out.println("없다~~~~");
		}
		
	}
	
}
