package com.movieDB.models;

import java.util.Date;

public class Comment {
	private String description;
	private int movieId;
	private int userId;
	private Date date;
	private int commentId;

	public Comment(String description, int movieId, int userId, Date date, int comentId) {
		this(description, movieId, userId, date);
		this.commentId = comentId;

	}

	public Comment(String description, int movieId, int userId, Date date) {
		this.description = description;
		this.movieId = movieId;
		this.userId = userId;
		this.date = date;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getComentId() {
		return commentId;
	}

	public void setComentId(int comentId) {
		this.commentId = comentId;
	}

}
