package kr.human.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

/*
숫자 스트림에서 합계, 최대, 최소, 평균등을 계산하려면
숫자가 아닌 스트림을 숫자 스트림 유형(IntStream, LongStream 또는 DoubleStream)으로 맵핑해서 처리해야 한다.
*/
public class StreamEx09 {
	public static void main(String[] args) {
		// 수입합계
		double totalIncome = Employee.persons().stream().mapToDouble(Employee::getIncome).sum();
		System.out.println("수입합계 : " + totalIncome);
		// 최고 수입 사원
		Optional<Employee> emp = Employee.persons().stream()
				                 .max(Comparator.comparingDouble(Employee::getIncome));
		if(emp.isPresent())
			System.out.println("최고 수입 사원 : " + emp.get());
		
		OptionalDouble maxIncome = Employee.persons().stream().mapToDouble(Employee::getIncome).max();
		OptionalDouble minIncome = Employee.persons().stream().mapToDouble(Employee::getIncome).min();
		OptionalDouble avgIncome = Employee.persons().stream().mapToDouble(Employee::getIncome).average();
		double totalIncome2 = Employee.persons().stream().mapToDouble(Employee::getIncome).sum();
		System.out.println("최고수입 : " + maxIncome.getAsDouble());
		System.out.println("최저수입 : " + minIncome.getAsDouble());
		System.out.println("평균수입 : " + avgIncome.getAsDouble());
		System.out.println("수입합계 : " + totalIncome2);
		// 사원수
		long count = Employee.persons().stream().count();
		System.out.println("사원수 : " + count);
		count = Employee.persons().stream().mapToLong(p->1L).sum();
		System.out.println("사원수 : " + count);
		count = Employee.persons().stream().map(p->1L).reduce(0L, Long::sum);
		System.out.println("사원수 : " + count);
		count = Employee.persons().stream().reduce(0L, (pc, e)->pc+1L, Long::sum);
		System.out.println("사원수 : " + count);
		
	}
}
