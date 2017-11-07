package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movieDB.exceptions.MovieException;
import com.movieDB.models.Movie;
import com.movieDB.models.DAO.OuterMovieDatabaseDAO;

@WebServlet("/Load")
public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		OuterMovieDatabaseDAO dao = OuterMovieDatabaseDAO.getOuterMovieDatabaseDAO();
		Movie movie = null;

		try {
			movie = dao.searchMovie(name);

		} catch (MovieException e) {

			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			e.printStackTrace();
		}
		movie.setId(Integer.parseInt(id));
		sesion.setAttribute("movie", movie);
		request.getRequestDispatcher("MoviePage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
