package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.DataConnection;

@WebServlet("/register")
public class MyServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String mail = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String subject = req.getParameter("sub");
		String password = req.getParameter("pass");
		
		User u1 = new User(name, mail, phone, subject, password);
		int i = DataConnection.saveData(u1);
		PrintWriter pw = resp.getWriter();
		
		if(i !=0) {
			req.setAttribute("status","success");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("status","failed");
			pw.print("<h1> Data is not Save</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("registrationform.jsp");
			rd.include(req, resp);
		}
		
	}
}
