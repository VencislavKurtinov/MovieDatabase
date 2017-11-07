package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;
import com.movieDB.models.DAO.UserDatabaseDAO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 95L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			User user = null;
			try {
				user = UserDatabaseDAO.getDataBaseUserDAO().getUserByEmailAndPassword(email, password);
			} catch (UserException e) {

				e.printStackTrace();
				request.setAttribute("error", "Don`t have a user with this email and password!");
				request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
				return;
			}
			sesion.setMaxInactiveInterval(120);
			sesion.setAttribute("user", user);
			sesion.setAttribute("logged", true);
			response.sendRedirect("Home.jsp");
			
			

		} else {
			request.setAttribute("error", "Invalid password or email!");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}
	}

}
