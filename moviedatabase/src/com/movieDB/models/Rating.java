package com.movieDB.models;

public class Rating {
	private int user_id;
	private int movie_id;
	private int rate;

	Rating(int user, int movie, int rate) {
		this.movie_id = movie;
		this.user_id = user;
		this.rate = rate;
	}
}
