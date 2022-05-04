package kr.human.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
스트림에서 맵으로 데이터를 수집 할 수 있습니다.

Collectors 클래스의 세 가지 버전 메서드에서 오버로드 된 toMap ()은 Map에서 데이터를 수집하기 위해 수집기를 반환합니다.
toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M>  mapSupplier)

첫 번째 버전은 두 개의 인수를 사용합니다. 두 인수는 모두 함수입니다.
첫 번째 인수는 스트림 요소를 맵의 키에 매핑합니다.
두 번째 인수는 스트림 요소를 맵의 값에 매핑합니다.
중복 키가 발견되면 IllegalStateException이 발생합니다.
 */
public class StreamEx13 {
	public static void main(String[] args) {
		
		Map<Long, String> map = Employee.persons().stream()
				                .collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(map);
		System.out.println(map.get(4L));
		
		Map<Employee.Gender, String> map2 = Employee.persons().stream()
								.collect(Collectors.toMap(Employee::getGender, Employee::getName, (oldValue, newValue)->String.join(",", oldValue, newValue)));
		System.out.println(map2);
		
		
		Map<Employee.Gender, Long> map3 = Employee.persons().stream()
								.collect(Collectors.toMap(Employee::getGender, p->1L,(oldValue, newValue)->oldValue+newValue));
		System.out.println(map3);
		
		Map<Employee.Gender, Employee> map4 = Employee.persons().stream()
								.collect(Collectors.toMap(Employee::getGender, Function.identity(),
										(oldPerson, newPerson)  -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
		System.out.println(map4);
		
	}
}
