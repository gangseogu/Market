package com.ticket.market.vo;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("UserVo")
public class UserVo {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_mail;
	private String user_birth;
	private String user_tel;
	private String user_auth;
	private String user_delflag;
	private String user_joindate;
	private String user_age;
	private String user_key;
	private String user_kakao;
	private String user_naver;
	private String user_nickname;

}
