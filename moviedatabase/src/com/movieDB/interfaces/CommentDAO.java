package com.movieDB.interfaces;

import java.util.LinkedList;

import com.movieDB.exceptions.CommentException;
import com.movieDB.models.Comment;

public interface CommentDAO {
	int addComment(Comment comment) throws CommentException;

	LinkedList<Comment> getMovieComments(int movieId) throws CommentException;
}
