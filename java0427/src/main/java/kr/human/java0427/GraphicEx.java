package kr.human.java0427;

/*
 * 1.동일한 부모를 가진다
 * 2. 부모의 메서드를 오버라이딩 한다.
 * 3. 부모의 변수에 자식 객체를 대입해서 자식을 컨트롤한다.
 * 
 */


// 추상 클래스 : 추상메서드를 1개 이상 가지는 클래스. 미완성클래스이다.객체를 생성할수 없다.
				//상속받는 자식 클래스에게 의무를 부여한다. 반드시 오버라이딩하라고 정해준다.

abstract class Shape{
	public static final double PI = 3.141592;
	//public void draw() { System.out.println("도형을 그립니다."); }
	abstract public void draw(); // 내용이 없는 메서드(추상메서드). 규칙을 정하기 위해서 만든다.

}
// 추상클래스보다 추상도가 더 높은 클래스를 자바에서는 interface라고 한다.
// 일반변수나 메서드를 가질 수 없다.상수와 추상메서드만으로 구성된다.
interface Graphic{
	double PI = 3.1415; // 앞에 public static final이 자동으로 붙는다.
	void move(); 		// public이 자동으로 붙는다.
	void remove();		// 인터페이스는 상속이아니라 구현한다라고 한다.implements를 사용한다.
						// 인터페이스는 다중구현이 가능하다.
}
interface Graphics2{
	void rotate();
}
// 인터페이스의 상속
interface Graphics extends Graphic , Graphics2{
	
}


class Point extends Shape implements Graphic , Graphics2{ // 인터페이스의 다중구현이 가능하다.
	public void draw() { System.out.println("점을 그립니다."); }

	public void move() {
		
	}

	public void remove() {
			
	}

	public void rotate() {
		
		
	}
}
class Line extends Shape{
	public void draw() { System.out.println("선을 그립니다."); }
}
class Circle extends Shape{
	public void draw() { System.out.println("원을 그립니다."); }
}
class Rectangle extends Shape{
	public void draw() { System.out.println("사각형을 그립니다."); }
}
public class GraphicEx {
	public static void main(String[] args) {
		Shape[] shapes = {new Shape(),new Point(),new Line(), new Circle(), new Rectangle()};
		                     
		for(Shape shape : shapes) {
			shape.draw();
		}
	}
}
