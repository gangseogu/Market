package com.ticket.market.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticket.market.mapper.UserMapper;
import com.ticket.market.vo.UserVo;

@Service
public class UserService implements UserMapper {
	@Autowired
	private UserMapper mapper;
	
	private final PasswordEncoder encoder = new BCryptPasswordEncoder();

	//로그인
	@Override
	public UserVo login(Map<String, Object> map) {
		return mapper.login(map);
	}

	//회원가입 여부 확인
	@Override
	public int CheckSignUp(Map<String, Object> map) {
		return mapper.CheckSignUp(map);
	}

	//회원가입
	@Override
	public int signUpUser(UserVo uvo) {
		if(!uvo.getUser_id().equals("")) {
			//비밀번호 암호화
			uvo.setUser_pw(encoder.encode(uvo.getUser_pw()));
		}
		return mapper.signUpUser(uvo);
	}

	//아이디 찾기
	@Override
	public String findId(Map<String, Object> map) {
		return mapper.findId(map);
	}

	//비밀번호 변경
	@Override
	public int changePw(Map<String, Object> map) {
		String user_pw = (String) map.get("user_pw");
		//비밀번호 암호화
		String encodedPw = encoder.encode(user_pw);
		map.put("user_pw", encodedPw);
		return mapper.changePw(map);
	}

	//아이디로 유저정보 검색
	@Override
	public UserVo getUserById(String user_id) {
		return mapper.getUserById(user_id);
	}

	//일반회원 리스트
	@Override
	public List<UserVo> findAllUsers() {
		return mapper.findAllUsers();
	}

	//닉네임 변경
	@Override
	public int changeNn(Map<String, Object> map) {
		return mapper.changeNn(map);
	}

	//권한 변경(일반회원 -> 관리자)
	@Override
	public int changeToAdmin(String user_id) {
		return mapper.changeToAdmin(user_id);
	}

	//회원 탈퇴
	@Override
	public int changeDelflag(String user_id) {
		return mapper.changeDelflag(user_id);
	}

	//회원 삭제
	@Override
	public int deleteUser(String user_id) {
		return mapper.deleteUser(user_id);
	}
	
	//비밀번호 암호화
	public PasswordEncoder passwordEncoder() {
		return this.encoder;
	}

}
