package kr.human.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
맵 작업은 각 요소에 함수를 적용하여 다른 스트림을 생성합니다. ==> 중간작업
입력 및 출력 스트림의 요소 수는 동일합니다.
이 작업은 입력 스트림의 요소를 수정하지 않습니다.
Stream <T> 인터페이스의 다음 메서드 중 하나를 사용하여 스트림에 맵 작업을 적용 할 수 있습니다.

<R> Stream<R> map(Function<? super T,? extends R> mapper)
DoubleStream  mapToDouble(ToDoubleFunction<? super T> mapper)
IntStream     mapToInt(ToIntFunction<? super T> mapper)
LongStream    mapToLong(ToLongFunction<? super T> mapper)
*/
// 맵 연산을 이용한 스트림 작업
public class StreamEx07 {
	public static void main(String[] args) {
	IntStream
	.rangeClosed(1,10)
	.map(n->n*n)
	.forEach(n->System.out.println(n+""));
	System.out.println("\n"+"-".repeat(50));
		
	// 사원목록에서 이름만 대문자로 한줄에 출력하시오.
	Employee.persons().stream().map(Employee::getUpperlName)
	.forEach(n->System.out.println(n.toUpperCase()+" "));
	System.out.println("\n"+"-".repeat(50));
	
	Employee.persons().stream().map(Employee::getName)
	.forEach(n->System.out.println(n.toUpperCase()+" "));
	System.out.println("\n"+"-".repeat(50));
	
	// Streams map () 작업은 일대일 매핑을 생성합니다.
	// Streams flatMap ()은 일대다 매핑을 지원합니다.
	
	Stream.of(1,2,3,4,5)
	.flatMap(n->Stream.of(n,n+1)) //값을 스트림으로 만든다.
	.forEach(n->System.out.print(n+" ")); // 반복출력
	System.out.println("\n" + "-".repeat(50));
	
	
    Stream.of("XML", "JAVA", "HTML", "CSS")
    .map(name->name.chars()) // chars() : 문자열을 IntStream으로 만들어 준다.
    .flatMap(intStream -> intStream.mapToObj(n->(char)n)) // 문자로 변환
    .forEach(e->System.out.println(e)); // 출력
    System.out.println("-------------------------------------------");
    
    Stream.of("XML", "JAVA", "HTML", "CSS")
    .flatMap(name->IntStream.range(0, name.length()).mapToObj(name::charAt))
    .forEach(e->System.out.println(e)); // 출력
    System.out.println("-------------------------------------------");
	
	
	"대한민국".chars().forEach(System.out::println);
	"대한민국".chars()
	.mapToObj(e->(char)e)
	.forEach(System.out::println);
	}
}
