package com.cheng.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cheng.Bean.User;
import com.cheng.dao.UserDao;
import com.cheng.utils.C3p0Utils;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectUserByName(String name) throws SQLException {
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from user where name=?";
		// ���÷���
		User user = (User) runner.query(sql, new BeanHandler(User.class), new Object[] { name });
		return user;
	}

	@Override
	public Boolean insert(User user) throws SQLException {
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "insert into user (name,password) values (?,?)";
		// ���÷���
		int num = runner.update(sql, new Object[] { user.getName(), user.getPassword() });
		if (num > 0)
			return true;
		return false;
	}

	@Override
	public boolean selectPasswordByName(User user) {
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from user where name=? and password=?";
		// ���÷���
		User user_ = null;
		try {
			user_ = (User) runner.query(sql, new BeanHandler(User.class),user.getName(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user_!=null) {
			return true;
		}
		return false;
	}

}
