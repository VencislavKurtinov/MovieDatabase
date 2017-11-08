package com.movieDB.models.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.MovieException;
import com.movieDB.interfaces.IntegrationDAO;
import com.movieDB.models.Movie;

public class OuterMovieDatabaseDAO implements IntegrationDAO {
	private static final String SELECT_FROM_MOVIES_WHERE_NAME = "SELECT name FROM movies WHERE name =?";
	private static OuterMovieDatabaseDAO outerMovieDatabaseDAO = null;

	public Movie searchMovie(String name) throws MalformedURLException, IOException, MovieException {
		if (isValidName(name)) {
			name = name.trim();
			String[] a = name.split(" ");
			name = String.join("+", a);

			InputStream is = new URL("http://www.omdbapi.com/?t=" + name + "&apikey=106d48e5").openStream();
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
			int year = Integer.parseInt(object.get("Year").getAsString().replace("-", ""));
			String director = object.get("Director").getAsString();
			String plot = object.get("Plot").getAsString();
			String actors = object.get("Actors").getAsString();
			String type = object.get("Type").getAsString();
			String country = object.get("Country").getAsString();
			String genre = object.get("Genre").getAsString();
			String runTime = object.get("Runtime").getAsString();
			String photo = object.get("Poster").getAsString();
			Movie movie = new Movie(name, plot, year, photo, country, runTime, genre, actors, type, director);

			return movie;
		} else {
			throw new MovieException("This movie isn`t present in database!");
		}
	}

	private boolean isValidName(String name) throws MovieException {
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_FROM_MOVIES_WHERE_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MovieException("Don`t calculate the rating", e);
		}

		return (name != null);

	}

	public static OuterMovieDatabaseDAO getOuterMovieDatabaseDAO() {

		synchronized (OuterMovieDatabaseDAO.class) {

			if (outerMovieDatabaseDAO == null) {
				outerMovieDatabaseDAO = new OuterMovieDatabaseDAO();
			}
		}

		return outerMovieDatabaseDAO;
	}
}
// private int getMyId(String name){
// Connection con = DBConnection.getInstance().getConnection();
// int id =0;
// PreparedStatement ps;
// try {
// ps = con.prepareStatement(SELECT_MOVIE_ID_WHERE_NAME);
// ps.setString(1, name);
// ResultSet rs = ps.executeQuery();
// rs.next();
// id = rs.getInt(1);
// } catch (SQLException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// return 0;
// }
// return id;
//
// }