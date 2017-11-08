package com.movieDB.interfaces;

import java.util.List;

import com.movieDB.exceptions.MovieException;
import com.movieDB.exceptions.RateException;
import com.movieDB.models.Movie;

public interface MovieDAO {
	List<Movie> getAllMovie();

	void rateMovie(int rate, int userId, int movieId) throws RateException, MovieException;

	void deleteRate(int userId, int movieId) throws RateException;

	float getMovieRating(int id) throws MovieException;
}
