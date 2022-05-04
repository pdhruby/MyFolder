package kr.human.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
파티셔닝은 그룹화의 특별한 경우입니다.
데이터 그룹화는 함수에서 반환 된 키를 기반으로합니다. 많은 그룹이있을 수 있습니다.
파티셔닝은 술어를 기반으로 두 그룹 만 처리합니다. true로 평가 된 값은 한 그룹이고 false는 다른 그룹입니다.
키가 항상 Boolean 유형 인 Map에서 데이터를 수집하는 partitioningBy () 메서드는 두 가지 버전에서 오버로드됩니다.

partitioningBy(Predicate<? super T> predicate)
partitioningBy(Predicate<? super T> predicate,  Collector<? super T,A,D> downstream)

 */
public class StreamEx16 {
	public static void main(String[] args) {
		Map<Boolean, List<Employee>> map1 = Employee.persons().stream()
				                            .collect(Collectors.partitioningBy(Employee::isFemale));
		System.out.println(map1);
		
		for(boolean key : map1.keySet()) {
			System.out.println(key + " : " + map1.get(key));
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Map<Boolean, String> map2 = Employee.persons().stream()
				.collect(Collectors.partitioningBy(Employee::isFemale, Collectors.mapping(Employee::getName, Collectors.joining(", "))));
		System.out.println(map2);
		
		for(boolean key : map2.keySet()) {
			System.out.println(key + " : " + map2.get(key));
		}
	}
	
}
