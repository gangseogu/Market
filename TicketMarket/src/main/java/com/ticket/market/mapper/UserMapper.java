package com.ticket.market.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ticket.market.vo.UserVo;

@Mapper
public interface UserMapper {
	
	public int CheckSignUp(Map<String, Object> map);
	
	public int signUpUser(UserVo uvo);
	
	public String findId(Map<String, Object> map);
	
	public int changePw(Map<String, Object> map);
	
	public UserVo getUserById(String user_id);
	
	public List<UserVo> findAllUsers();
	
	public int changeNn(Map<String, Object> map);
	
	public int changeToAdmin(String user_id);
	
	public int changeDelflag(String user_id);
	
	public int deleteUser(String user_id);

}
