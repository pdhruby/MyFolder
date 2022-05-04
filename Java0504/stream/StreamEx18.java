package kr.human.stream;

import java.util.List;
import java.util.stream.Collectors;

/*
Stream 인터페이스의 다음 메서드는 일치 작업을 수행하는 데 사용됩니다.

boolean allMatch(Predicate<? super T> predicate)
boolean anyMatch(Predicate<? super T> predicate)
boolean noneMatch(Predicate<? super  T> predicate)
 */
public class StreamEx18 {
	public static void main(String[] args) {
		List<Employee> list = Employee.persons();
		for (Employee e : list)
			System.out.println(e);

		System.out.println();

		boolean allFemale = list.stream().allMatch(Employee::isFemale);
		System.out.println("allMatch : " + allFemale);

		boolean year1971 = list.stream().anyMatch(p -> p.getDob().getYear() == 1971);
		System.out.println("1971년  : " + year1971);
		System.out.println();

		String names = Employee.persons().stream().filter(Employee::isFemale).map(Employee::getName)
				.collect(Collectors.joining(", "));
		System.out.println(names);
		System.out.println();

		names = Employee.persons().parallelStream().filter(Employee::isFemale).map(Employee::getName)
				.collect(Collectors.joining(", "));
		System.out.println(names);
		System.out.println();

		names = Employee.persons().stream().filter(Employee::isFemale).parallel().map(Employee::getName) // .parallel()
				.collect(Collectors.joining(", "));
		System.out.println(names);
		System.out.println();

	}

}
