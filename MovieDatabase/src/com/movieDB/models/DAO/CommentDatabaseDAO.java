package com.movieDB.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.CommentException;
import com.movieDB.models.Comment;

public class CommentDatabaseDAO {
	private static CommentDatabaseDAO commentDataBaseDAO = null;
	private static final String ADD_COMMENT = "INSERT INTO comments value(null,?,?,?,?);";

	public int addComment(Comment comment) throws CommentException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADD_COMMENT, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, comment.getMovieId());
			ps.setInt(2, comment.getUserId());
			ps.setString(3, comment.getDescription());
			ps.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			comment.setComentId(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CommentException("Can`t add comments", e);
		}
		return comment.getComentId();

	}

	public LinkedList<Comment> getMovieComments(int movieId) throws CommentException {

		Connection con = DBConnection.getInstance().getConnection();
		LinkedList<Comment> allMovieComments = new LinkedList<>();
		try {
			Statement statment = con.createStatement();
			ResultSet rs = statment.executeQuery("SELECT * FROM comments WHERE movie_id=" + movieId);

			while (rs.next()) {
				int commentId = rs.getInt("id_comment");
				String description = rs.getString("description");
				int userId = rs.getInt("user_id");
				Date date = rs.getDate("date");

				allMovieComments.add(new Comment(description, movieId, userId, date, commentId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CommentException("Comments on this movie can not reload!", e);

		}

		return allMovieComments;

	}

	public static CommentDatabaseDAO getDataBaseUserDAO() {

		synchronized (CommentDatabaseDAO.class) {

			if (commentDataBaseDAO == null) {
				commentDataBaseDAO = new CommentDatabaseDAO();
			}
		}

		return commentDataBaseDAO;
	}

}
