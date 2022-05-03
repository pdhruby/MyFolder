package kr.human.json.vo;

import java.util.List;

import lombok.Data;

@Data
public class ItemVo {
	private String id;
	private String name;
	//private History[] history;
	private List<History> history;
	@Data
	public static class  History{
		private String date;
		private String item;
	}
}
