package com.cheng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheng.Bean.User;
import com.cheng.service.UserService;
import com.cheng.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class validateServlet
 */
@WebServlet("/validateServlet")
public class validateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		UserService us = new UserServiceImpl();
		User user = us.findUserByName(name);
		if (user != null) {
			// ��ʾ�Ѿ���������û�
			response.getWriter().print("<font color='red'>�û����Ѿ�����</font> ");
		} else {
			// ��ʾ���û������ڣ�����ע��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font> ");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
