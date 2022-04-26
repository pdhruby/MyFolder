package kr.human.MavenEx;
// 1반의 성적을 처리할 클래스
public class ClassVO {
	// 1. 변수를 선언한다.
	private StudentVO[] studentVOs;
	private int index=0; // 배열의 첨자
	// 2. 생성자를 만든다
	public ClassVO() {
		this(30); // 학생수를 지정하지 않으면 30명을 기본으로 한다.
	}
	
	public ClassVO(int count) { // 학생수를 지정하면 지정한 숫자만큼 학생을 확보한다.
		studentVOs = new StudentVO[count];
	}
	
	// 3. Getter & Setter를 만든다.
	
	// 4. 추가할 기능을 넣는다.
	// 학생을 추가하는 메서드
	public void addStudent(StudentVO vo) {
		if(index<studentVOs.length) studentVOs[index++] = vo;
	}
	public void addStudent(String stuNo, String name, int kor, int eng, int mat, int edps) {
		if(index<studentVOs.length) studentVOs[index++] = new StudentVO(stuNo, name, kor, eng, mat, edps);
	}
	// 학번으로 조회하기
	public StudentVO getStudentVO(String stuNo) {
		StudentVO vo = null;
		// for(StudentVO v : studentVOs) {
		ranking(); // 석차를 새로 구하고 
		for(int i=0;i<studentVOs.length;i++) {
			if(studentVOs[i]!=null && studentVOs[i].getStuNo().equals(stuNo)) {
				vo = studentVOs[i];
				break;
			}
		}
		return vo;
	}
	// 석차구하기
	private void ranking() {
		// 석차를 모두 1등으로 만든다.
		for(int i=0;i<index;i++) studentVOs[i].setRank(1);
		// 석차를 구한다.
		for(int i=0;i<index-1;i++) {
			for(int j=i+1;j<index;j++) {
				if(studentVOs[i].getTotal()>studentVOs[j].getTotal()) { // i의 점수가크면
					studentVOs[j].setRank(studentVOs[j].getRank()+1); // j의 석차가 증가
				} else if(studentVOs[i].getTotal()<studentVOs[j].getTotal()) { // j의 점수가크면
					studentVOs[i].setRank(studentVOs[i].getRank()+1); // i의 석차가 증가
				} 
			}
		}
	}
	// 5. 몇개를 오버라이딩한다.(toString, equals, hashCode....)
	@Override
	public String toString() {
		String result = "";
		ranking();// 석차를 새로 구하고 
		for(int i=0;i<index;i++) {
			result += studentVOs[i] + "\n";
		}
		return result;
	}

}
