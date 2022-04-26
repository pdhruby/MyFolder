package kr.human.MavenEx;

public class PersonEx {
	public static void main(String[] args) {
		Person kimc = new Person("한사람",27,true);
		Person leec = kimc;
		
		//얕은복사 : 내용이 복사되는것이아니라 주소가 복사된다.
		//같은 주소를 가리킨다.
		System.out.println(kimc);
		System.out.println(leec);
		
		// 이씨의 이름을 변경했지만.
		leec.setName("이순신");

		// 김씨도 바뀐다. 객체는 1개고 두변수가 같은객체를 가리킨다.
		System.out.println(kimc);
		System.out.println(leec);
		System.out.println();
		
		//깊은복사 : 값을 복사해준다.
		
		Person parkc = new Person();
		parkc.setName(leec.getName());
		parkc.setAge(leec.getAge());
		parkc.setGender(leec.isGender());
		
		System.out.println(leec);
		System.out.println(parkc);
		
		parkc.setName("박문수");
		
		System.out.println(leec);
		System.out.println(parkc);
		System.out.println();
		
		
		// 복사생성자를 이용한 깊은 복사!!!!
		Person sonc = new Person(kimc);
		System.out.println(kimc);
		System.out.println(sonc);
		
		sonc.setName("손흥민");
		System.out.println(kimc);
		System.out.println(sonc);
		
		
		
	}
}
