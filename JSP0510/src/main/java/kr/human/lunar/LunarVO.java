package kr.human.lunar;

import lombok.Data;

@Data
public class LunarVO {
	private String solar; // 양력
	private String lunar; // 음력
	private String ganji; // 간지
	
	// 날짜를 분리하는 메서드를 추가해 보자!!!
	
	// 양력을 분리해보자
	// 2022-05-01 (일)
	
	// 년도 얻기
	public String getSolarYear() {
		return solar.split("-")[0];
	}
	// 월 얻기
	public String getSolarMonth() {
		return solar.split("-")[1];
	}
	// 일 얻기
	public String getSolarDay() {
		return solar.split("-")[2].split(" ")[0];
	}
	// 요일을 문자로 얻기
	public String getSolarWeek() {
		return solar.split("-")[2].split(" ")[1].charAt(1)+"";
	}
	// 요일을 정수로 얻기
	public int getIntSolarWeek() {
		return "일월화수목금토".indexOf(getSolarWeek());
	}
	
	// 음력을 분리해보자
	// 2021-11-29
	// 년도 얻기
	public String getLunarYear() {
		return lunar.split("-")[0];
	}
	// 월 얻기
	public String getLunarMonth() {
		return lunar.split("-")[1];
	}
	// 일 얻기
	public String getLunarDay() {
		return lunar.split("-")[2];
	}
	
	// 간지도 분리해보자
	
	// 윤달있는 경우(윤달은 월건이 존재하지 않는다.)
	// 경자(庚子)년 을해(乙亥)일
	
	// 윤달이 없는경우
	// 신축(辛丑)년 경자(庚子)월 갑인(甲寅)일)
	// 세차         월건         일진
	
	// 년도
	public String getGanjiYearKo() { // 한글로
		return ganji.split(" ")[0].substring(0, 2);
	}
	public String getGanjiYearCn() { // 한자로
		return ganji.split(" ")[0].substring(3, 5);
	}
	// 월
	public String getGanjiMonthKo() { // 한글로
		if(ganji.split(" ").length==3)
			return ganji.split(" ")[1].substring(0, 2);
		else
			return ""; // 윤달은 월건이 없다.
	}
	public String getGanjiMonthCn() { // 한자로
		if(ganji.split(" ").length==3)
			return ganji.split(" ")[1].substring(3, 5);
		else
			return ""; // 윤달은 월건이 없다.
	}
	// 일진
	public String getGanjiDayKo() { // 한글로
		if(ganji.split(" ").length==3)
			return ganji.split(" ")[2].substring(0, 2);
		else
			return ganji.split(" ")[1].substring(0, 2); // 윤달은 월건이 없다.
	}
	public String getGanjiDayCn() { // 한자로
		if(ganji.split(" ").length==3)
			return ganji.split(" ")[2].substring(3, 5);
		else
			return ganji.split(" ")[1].substring(3, 5); // 윤달은 월건이 없다.
	}
	
}
