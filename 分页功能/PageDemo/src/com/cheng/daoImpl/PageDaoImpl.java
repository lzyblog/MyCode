package com.cheng.daoImpl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cheng.Bean.User;
import com.cheng.dao.PageDao;
import com.cheng.utils.C3p0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class PageDaoImpl implements PageDao {

	@Override
	public int getCount() {
		int pageCount = 0;
		// // ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from user";
		// ���÷���
				List<User> list = null;
				try {
					list = (List<User>) runner.query(sql,
					        new BeanListHandler<User>(User.class));
			pageCount = list.size() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageCount;
	}


	public List<User> selectUserByPage(int begin, int pageSize) {
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from user limit ?, ?";
		// ���÷���
		List<User> list = null;
		try {
			list = (List<User>) runner.query(sql,
			        new BeanListHandler<User>(User.class),new Object[]{begin, pageSize});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
}}
