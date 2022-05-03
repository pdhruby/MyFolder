package kr.human.json.vo;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","age","gender","date"})
public class PersonVO {
	@XmlElement
	private String name;
	@XmlElement
	private int age;
	@XmlJavaTypeAdapter(GenderAdapter.class) // 저장/읽기 할때 사용될 클래스 지정..모양 변경!!
	private Boolean gender; // 기본자료형은 안되고 객체 타입만 가능하다. boolean(x) -> Boolean(o)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
}
