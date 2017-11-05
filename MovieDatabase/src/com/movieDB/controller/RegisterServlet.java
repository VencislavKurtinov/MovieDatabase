package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;
import com.movieDB.models.DAO.UserDatabaseDAO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -4907448809468716980L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email != null && !email.isEmpty() && password != null && !password.isEmpty() && email != null
				&& !email.isEmpty()) {

			User user = new User(name, email, password);

			try {
				UserDatabaseDAO.getDataBaseUserDAO().addUser(user);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				sesion.setMaxInactiveInterval(120);
				sesion.setAttribute("logged", true);
			} catch (UserException e) {
				response.sendRedirect("Home.jsp");
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Home.jsp");
		}
	}

	@Override
	public void destroy() {
		DBConnection.getInstance().closeConnection();
	}

}
