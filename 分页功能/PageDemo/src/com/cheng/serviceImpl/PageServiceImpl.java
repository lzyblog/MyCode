package com.cheng.serviceImpl;

import java.util.List;

import com.cheng.Bean.Page;
import com.cheng.Bean.User;
import com.cheng.dao.PageDao;
import com.cheng.daoImpl.PageDaoImpl;
import com.cheng.service.PageService;

public class PageServiceImpl implements PageService {

	@Override
	public Page findUserByPage(int pageIndex) {
		PageDao pageDao = new PageDaoImpl() ;
		// 1��total�ܼ�¼��
		int total = 0;
		List<User> dataList = null;
		total = pageDao.getCount();
		// 2��һҳ��ʾ���ٸ�����
		int pageSize = 3;
		// 3��������ҳ��
		int pageCount = total % pageSize == 0 ? (total / pageSize) : (total / pageSize) + 1;
		System.out.println("pageCount="+pageCount);
		// ��ǰҳ�Ŀ�ʼ����������������start��Ϊ ����ǰҳ��-1��*ÿҳ��������
		dataList = pageDao.selectUserByPage((pageIndex - 1) * pageSize, pageSize);
		// ��װ����
		Page page = new Page();
		page.setTotal(total);
		page.setPageCount(pageCount);
		page.setPageIndex(pageIndex);
		page.setDataList(dataList);
		page.setPageSize(pageSize);
		 
		return page;
	}

}
