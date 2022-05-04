package kr.human.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/*
java.util 패키지에는 통계를 수집하는 세 가지 클래스가 있습니다.

DoubleSummaryStatistics
LongSummaryStatistics
IntSummaryStatistics
이를 사용하여 숫자 데이터 그룹에 대한 요약 통계를 계산할 수 있습니다.
 */
public class StreamEx12 {
	public static void main(String[] args) {
		
		DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
		stats.accept(100.0);
		stats.accept(200.0);
		stats.accept(225.0);
		stats.accept(312.0);
		stats.accept(543.0);
		stats.accept(765.0);
		stats.accept(229.0);
		
		System.out.println(stats);
		System.out.println(stats.getCount());
		System.out.println(stats.getSum());
		System.out.println(stats.getAverage());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		
		
		DoubleSummaryStatistics incomeStat = Employee.persons().stream().map(Employee::getIncome)
				.collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
		System.out.println(incomeStat);
		
		
		incomeStat = Employee.persons().stream().collect(Collectors.summarizingDouble(Employee::getIncome));
		System.out.println(incomeStat);
		
		
	}
}
