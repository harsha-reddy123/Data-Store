package com.cmr.amazon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmr.amazon.dao.AdminUsersDAO;
import com.cmr.amazon.entity.AdminUsers;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. read the uname, pwd coming in req
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2. create object of Adminusers entity set these values
		AdminUsers au = new AdminUsers();
		au.setUsername(username);
		au.setPassword(password);		
		
		//3. create object of AdminUsersDAO -> call his logincCheck(entity)
		AdminUsersDAO audao = new AdminUsersDAO();
		au = audao.checkLogin(au);
		
		//4. read the AdminUsers obj supplied with id, name
		String name = au.getName();
		RequestDispatcher rd = request.getRequestDispatcher("adminLogin.html");
		
		//5. check if name is available -> take to home pages else show wrong uname msg
		if(name.equalsIgnoreCase("invaliduser")) {
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<center><h3 style='color:red;'>wrong username/password</h3></center>");
		}
		else {
			//set username, name to be used at server side in session
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("name", name);
			
			response.sendRedirect("adminHome.jsp");
		}
	}

}
