package com.movieDB.models.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.MovieException;
import com.movieDB.exceptions.UserException;
import com.movieDB.models.Movie;
import com.mysql.jdbc.Statement;

public class MovieDatabaseDAO {
	private static MovieDatabaseDAO dataBaseMovieDAO = null;
	private static final String ADD_MOVIE = "Insert into movies values(null,?,?)";
	private List<Movie> allMovies = new ArrayList<Movie>();

	public int addMovie(Movie movie) throws MovieException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADD_MOVIE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getName());
			ps.setInt(2, movie.getYearOfCreation());
			ps.setString(3, movie.getPlot());

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			movie.setId(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new MovieException("Can`t add movie", e);
		}
		return movie.getId();

	}

	public Movie getMovieByName(String name) {
		return null;

	}

	public void removeMovie(int userId) throws UserException {

	}

	// public List<Movie> getAllMovie() throws SQLException {
	// Connection con = DBConnection.getInstance().getConnection();
	// PreparedStatement ps = con.prepareStatement("SELECT * FROM movies");
	// ResultSet rs = ps.executeQuery();
	// ArrayList<Movie> movies = new ArrayList<>();
	// //do magic here
	// while(rs.next()){
	// allMovies.add(new Movie());//da mi dobavq movie v kolekciqta
	// }
	// return movies;

	// }

	public static MovieDatabaseDAO getInstance() {

		synchronized (MovieDatabaseDAO.class) {

			if (dataBaseMovieDAO == null) {
				dataBaseMovieDAO = new MovieDatabaseDAO();
			}
		}

		return dataBaseMovieDAO;
	}

}
