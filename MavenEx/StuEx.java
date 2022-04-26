package kr.human.MavenEx;


class some{
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "하이";
	}
}

public class StuEx {
	public static void main(String[] args) {
		StudentVO vo1 = new StudentVO("22020211", "한사람", 78, 82, 54, 99);
		//System.out.println(vo1);
		StudentVO vo2 = new StudentVO("22020212", "두사람", 100, 82, 100, 99);
		//System.out.println(vo2);
		
		ClassVO classVO = new ClassVO(10);
		classVO.addStudent(vo1);
		classVO.addStudent(vo2);
		classVO.addStudent("22020213", "세사람", 100, 82, 100, 99);
		
		System.out.println(classVO.getStudentVO("22020211"));
		System.out.println(classVO.getStudentVO("22020219"));
		
		classVO.addStudent("22020214", "네사람", 77, 82, 100, 99);
		classVO.addStudent("22020215", "오사람", 77, 88, 100, 99);
		classVO.addStudent("22020216", "육사람", 77, 82, 65, 99);
		classVO.addStudent("22020217", "칠사람", 77, 82, 32, 99);
		
		System.out.println(classVO);
		System.out.println(classVO);
		System.out.println(classVO);
	
		some some = new some();
		System.out.println(some.toString());
	}
}
