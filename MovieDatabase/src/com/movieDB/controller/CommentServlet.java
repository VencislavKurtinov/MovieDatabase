package com.movieDB.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieDB.exceptions.CommentException;
import com.movieDB.models.Comment;
import com.movieDB.models.Movie;
import com.movieDB.models.User;
import com.movieDB.models.DAO.CommentDatabaseDAO;

@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Movie movie = (Movie) session.getAttribute("movie");
		LinkedList<Comment> comments = new LinkedList<>();
		try {
			comments.addAll(CommentDatabaseDAO.getDataBaseUserDAO().getMovieComments(movie.getId()));
		} catch (CommentException e) {
			request.setAttribute("error", "Somthing with reloading of comments went wrong. Please try later!");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
			e.printStackTrace();
			return;

		}
		session.setAttribute("comments", comments);
		request.getRequestDispatcher("Comment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
