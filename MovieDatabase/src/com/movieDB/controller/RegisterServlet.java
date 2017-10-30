package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movieDB.DAO.UserDataBaseDAO;
import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -4907448809468716980L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// validaciq
		User user = new User(name, email, password);

		try {
			UserDataBaseDAO.getDataBaseUserDAO().addUser(user);
			response.getWriter().append("It`s ready you regsitred with id = " + user.getId());
		} catch (UserException e) {
			response.getWriter().append("Sometimes wrong with this!" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		DBConnection.getInstance().closeConnection();
	}

}
