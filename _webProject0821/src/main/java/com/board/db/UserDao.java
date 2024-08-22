package com.board.db;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class UserDao {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public UserDao() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public void insertUser(UserDto dto) {
		session.insert("UserMapper.insertUser", dto);
		
	}
	
	public void updateUser(UserDto dto) {
		session.update("UserMapper.updateUser", dto);
		
	}
	
	public void delete(UserDto dto) {
		session.delete("UserMapper.deleteUser", dto);
		
	}
	
	public int isUser(UserDto userDto) {
		return session.selectOne("UserMapper.isUser", userDto);
		
	}
	
	public UserDto findUser(UserDto userDto) {
		return session.selectOne("UserMapper.findUser", userDto);
	}
	
	

}
