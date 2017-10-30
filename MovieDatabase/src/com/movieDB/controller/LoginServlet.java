package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieDB.DAO.UserDataBaseDAO;
import com.movieDB.exceptions.UserException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 95L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			UserDataBaseDAO.getDataBaseUserDAO().getUserByEmailAndPassword(email, password);
		} catch (UserException e) {

			e.printStackTrace();
			response.sendRedirect("Login.html");
			return;
		}
		response.sendRedirect("Main.html");
		sesion.setMaxInactiveInterval(120);
		sesion.setAttribute("logged", true);

	}

}
