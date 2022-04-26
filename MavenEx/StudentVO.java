package kr.human.MavenEx;

// 1학생의 성적을 저장하기 위한 클래스
public class StudentVO {
	// 학번, 이름, 국어, 영어, 수학, 전산, 석차
	private String stuNo, name;
	private int kor, eng, mat, edps, rank=1;

	// 생성자
	public StudentVO(String stuNo, String name, int kor, int eng, int mat, int edps) {
		this.stuNo = stuNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edps = edps;
	}

	// Getter & Setter
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEdps() {
		return edps;
	}

	public void setEdps(int edps) {
		this.edps = edps;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getStuNo() {
		return stuNo;
	}

	public String getName() {
		return name;
	}
	
	// 추가할 기능
	// 총점
	public int getTotal() {
		return kor + eng + mat + edps;
	}
	// 평균
	public double getAvg() {
		return getTotal()/4.0;
	}

	// toString
	@Override
	public String toString() {
		return String.format("%8s %-6s %5d %5d %5d %5d %5d %7.2f %5d",
				             stuNo, name, kor, eng, mat, edps, getTotal(), getAvg(), rank);
	}
	
	
}
