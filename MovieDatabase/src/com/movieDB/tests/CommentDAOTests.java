package com.movieDB.tests;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Calendar;

import org.junit.Test;

import com.movieDB.exceptions.CommentException;
import com.movieDB.exceptions.UserException;
import com.movieDB.models.Comment;
import com.movieDB.models.DAO.CommentDatabaseDAO;

public class CommentDAOTests {
	private static Comment comment = new Comment("tuka nqkyv film ne go znam", 8, 8,new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

	@Test
	public void testAddComment() throws UserException, SQLException, CommentException {
		CommentDatabaseDAO dao = new CommentDatabaseDAO();

		int commentId = dao.addComment(comment);
		comment.setComentId(commentId);
		boolean a = (commentId != 0);
		assertTrue(a);
	}
}