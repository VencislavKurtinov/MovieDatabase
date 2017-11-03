package com.movieDB.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieDB.exceptions.MovieException;
import com.movieDB.models.Movie;
import com.movieDB.models.DAO.MovieDatabaseDAO;

@WebServlet("/addMovie")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Movie movie = new Movie(name, 1999, "Something subscribe");
		
		try {
			MovieDatabaseDAO.getInstance().addMovie(movie);
			response.getWriter().append("It`s ready  = " + movie.getId());
		} catch (MovieException e) {
			// TODO Auto-generated catch block
			System.out.println("ne stava");
			e.printStackTrace();
		
		}
	
	}

}
