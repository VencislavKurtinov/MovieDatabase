package com.movieDB.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movieDB.exceptions.MovieException;
import com.movieDB.models.Movie;
import com.movieDB.models.DAO.MovieDatabaseDAO;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 234561L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String query = request.getParameter("query");
			// ServletContext aplication =
			// getServletConfig().getServletContext();
			MovieDatabaseDAO dao = MovieDatabaseDAO.getInstance();
			response.setContentType("text/json");
			List<Movie> movies = dao.getAllMovie();

			if (query != null) {
				movies.removeIf((a) -> !a.getName().startsWith(query));
			}
			Gson gson = new GsonBuilder().create();
			response.getWriter().println(gson.toJson(movies));

			// synchronized (aplication) {
			// if (aplication.getAttribute("movies") == null) {
			// ArrayList<Movie> movies = (ArrayList<Movie>)
			// MovieDatabaseDAO.getInstance().getAllMovie();
			// aplication.setAttribute("movies", movies);
			// }
			// }
//			 request.getRequestDispatcher("Home.jsp").forward(request,
//			 response);
			//Opitam li da forword-na mi precakva json-a!!!!!!!!!!!!!!
		} catch (MovieException e) {
			System.out.println("Don`t have any movies!");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
