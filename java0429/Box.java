package ko.human.java0429;


import lombok.Data;

//컴파일시 자료형이 결정되는것이 아니라
// 사용시 자료형을 지정하여 사용가능하게 한다.
//클래스를 만들어주는 클래스
@Data // T: Type

public class Box<T> {
	private T item;
	

}
