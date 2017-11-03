package com.movieDB.models.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.movieDB.models.Movie;

public class OuterMovieDatabaseDAO {
	private static OuterMovieDatabaseDAO outerMovieDatabaseDAO = null;

	public JsonObject searchMovie(Movie movie) throws MalformedURLException, IOException {

		InputStream is = new URL("http://www.omdbapi.com/?t=" + movie + "&apikey=BanMePlz").openStream();
		byte[] movieBytes = new byte[is.available()];
		int counter = 0;
		int reader = 0;

		do {
			reader = is.read();
			if (reader != -1)
				movieBytes[counter++] = (byte) reader;
		} while (reader != -1);

		String json = new String(movieBytes, "UTF-8");
		Gson gson = new Gson();

		JsonObject object = gson.fromJson(json, JsonObject.class);
		
		return object;
	}

	public static OuterMovieDatabaseDAO getDataBaseMovieDAO() {

		synchronized (OuterMovieDatabaseDAO.class) {

			if (outerMovieDatabaseDAO == null) {
				outerMovieDatabaseDAO = new OuterMovieDatabaseDAO();
			}
		}

		return outerMovieDatabaseDAO;
	}
}