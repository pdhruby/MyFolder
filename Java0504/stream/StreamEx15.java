package kr.human.stream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Collectors 클래스의 groupingBy () 메서드는 데이터를 맵에서 수집하기 전에 그룹화하는 수집기를 반환합니다. SQL의 "group by"절과 유사합니다.
groupingBy () 메서드는 오버로드되었으며 세 가지 버전이 있습니다.

groupingBy(Function<? super  T,?  extends K>  classifier)
groupingBy(Function<? super  T,?  extends K>  classifier,  Collector<? super T,A,D> downstream)
groupingBy(Function<? super  T,?  extends K>  classifier, Supplier<M>  mapFactory, Collector<? super T,A,D> downstream)

 */
public class StreamEx15 {
	public static void main(String[] args) {
		// 성별 인원수
		Map<Employee.Gender, Long> countByGender = Employee.persons().stream()
												   .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countByGender);
		// 성별로 이름을 ,로 구분해서 문자열로
		Map<Employee.Gender, String> nameByGender =  Employee.persons().stream()
				                                     .collect(Collectors.groupingBy(Employee::getGender, 
				                                    		                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));
		System.out.println(nameByGender);

		// 성별로 구분해서 이름을 리스트로
		Map<Employee.Gender, List<String>> namesByGender =  Employee.persons().stream()
				                                            .collect(Collectors.groupingBy(Employee::getGender, 
				                                            		                       Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(namesByGender);
		
		// 성별로 구분해서 월별 맵으로 
		Map<Employee.Gender, Map<Object,String>> map =  Employee.persons().stream()
                   .collect(Collectors.groupingBy(Employee::getGender, 
	                                              Collectors.groupingBy(p->p.getDob().getMonth(),
	                                              Collectors.mapping(Employee::getName, Collectors.joining(", ")))));
		System.out.println(map);
		
		// 성별로 구분해서 수입의 통계를 맵으로 
		Map<Employee.Gender, DoubleSummaryStatistics> incomeStatsByGender = Employee.persons().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getIncome)));
		System.out.println(incomeStatsByGender);
	}
}
