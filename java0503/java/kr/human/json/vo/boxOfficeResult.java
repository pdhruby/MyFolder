package kr.human.json.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="weather")
@XmlAccessorType(XmlAccessType.FIELD)
public class boxOfficeResult {
	@XmlElement(name="boxOfficeResult")
	private String boxOfficeResult;
	@XmlElement(name="boxofficeType")
	private String boxofficeType;
	@XmlElement(name="showRange")
	private String showRange;
	@XmlElement(name="yearWeekTime")
	private String yearWeekTime;
	@XmlElement(name="WeeklyBoxOfficeList")
	private String WeeklyBoxOfficeList;
	List<weeklyBoxOffice> week;
	
	
	public static class weeklyBoxOffice{
		@XmlElement(name="movieNm")
		private String movieNm;
		@XmlElement(name="openDt")
		private String openDt;
	}
	
	
}
