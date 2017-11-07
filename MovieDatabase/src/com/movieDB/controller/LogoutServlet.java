package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 51L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getSession().invalidate();
			response.sendRedirect("Home.jsp");
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}
	}

}
