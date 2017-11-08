package com.movieDB.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;

import com.movieDB.exceptions.MovieException;
import com.movieDB.models.Movie;

public interface IntegrationDAO {
	Movie searchMovie(String name) throws MalformedURLException, IOException, MovieException;
}
