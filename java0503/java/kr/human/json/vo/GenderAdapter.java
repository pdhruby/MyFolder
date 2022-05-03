package kr.human.json.vo;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GenderAdapter extends XmlAdapter<String, Boolean> {
	
	@Override // String을 Boolean타입으로 바꿔서 리턴
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("남자");
	}

	@Override // Boolean타입을 String으로 바꿔서 리턴
	public String marshal(Boolean v) throws Exception {
		return v ? "남자" : "여자";
	}
}
