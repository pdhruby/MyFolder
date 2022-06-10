package kr.human.member.vo;

import java.util.Date;
import lombok.Data;

@Data
public class MemberVO {
	private int idx;
	private String userid;
	private String password;
	private String name;
	private Date   birth;
	private String gender;
	private String email;
	private String phone;
	private String postCode;
	private String addr1;
	private String addr2;
	private int use;
	private int lev;
}
