package kr.human.java0428;


class Some{ // 컴파일시 뒤에 자동으로 extends Objectg가 붙는다.
			// 모든클래스는 object 클래스에 있는 11개의 메서드를 바로 사용가능하다
	
	private String name;
	private int age;
	
	public Some() {
		
	}
	public Some(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Some [name=" + name + ", age=" + age + "]";
	}
	// 내용이 같으면 같은 객체로 판단하고 싶다. 그런 경우는 반드시 equals메서드를 오버라이딩 해야한다.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Some other = (Some) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}


public class ObjectEx {
	public static void main(String[] args) {
		Some some1 = new Some("한사람",22);
		System.out.println(some1);
		Some some2 = new Some("한사람",22);
		System.out.println(some2);

		System.out.println(some1.equals(some2) ? "같은사람":"다른사람");
		
		//해시코드는 JVM이 객체를 구분하기 위해서 붙이는 번호이다.
		System.out.println(some1.hashCode());
		System.out.println(some2.hashCode());
	}

}
