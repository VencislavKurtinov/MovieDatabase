package com.movieDB.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieDB.exceptions.MovieException;
import com.movieDB.exceptions.RateException;
import com.movieDB.models.Movie;
import com.movieDB.models.User;
import com.movieDB.models.DAO.MovieDatabaseDAO;

/**
 * Servlet implementation class RateServlet
 */
@WebServlet("/Rate")
public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sesion = request.getSession();
			Object logged = sesion.getAttribute("logged");
			boolean isLogged = (logged != null && ((boolean) logged));
			if (sesion.isNew() || !isLogged) {
				request.setAttribute("error", "Please log in system!");
				request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			} else {
				String rateOfString = request.getParameter("rate");
				int rate = Integer.parseInt(rateOfString);

				if (rate > 0 && rate < 11) {
					User user = (User) sesion.getAttribute("user");
					Movie movie = (Movie) sesion.getAttribute("movie");
					MovieDatabaseDAO dao = null;

					try {
						dao = MovieDatabaseDAO.getInstance();
						dao.rateMovie(rate, user.getId(), movie.getId());
						request.getRequestDispatcher("MoviePage.jsp").forward(request, response);
					} catch (RateException | MovieException e) {
						request.setAttribute("error", "Somthing with your Rate went wrong. Please try later!");
						request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
						e.printStackTrace();
						return;
					}
				} else {
					request.setAttribute("error", "Please give correct number between 1 and 10!");
					request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
				}

			}
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			return;
		}

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession sesion = request.getSession();
			Object logged = sesion.getAttribute("logged");
			boolean isLogged = (logged != null && ((boolean) logged));
			if (sesion.isNew() || !isLogged) {
				request.setAttribute("error", "Please log in system!");
				request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			} else {
				User user = (User) sesion.getAttribute("user");
				Movie movie = (Movie) sesion.getAttribute("movie");
				MovieDatabaseDAO dao = null;

				try {
					dao = MovieDatabaseDAO.getInstance();
					dao.deleteRate(5, 5);
				} catch (RateException | MovieException e) {
					request.setAttribute("error", "Somthing with deleted to your rate went wrong. Please try later!");
					request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
					e.printStackTrace();
					return;
				}
			}
		} catch (Exception e) {
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}

	}
}
