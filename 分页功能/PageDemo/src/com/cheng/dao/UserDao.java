package com.cheng.dao;

import java.sql.SQLException;

import com.cheng.Bean.User;

public interface UserDao {
	////�z���Ñ������ܴa�Ƿ�ƥ��
	public boolean selectPasswordByName(User user) ;
	//��������
	public Boolean insert(User user) throws SQLException ;
	// �����û����Ʒ��ض���
	public User selectUserByName(String name) throws SQLException ;
}
