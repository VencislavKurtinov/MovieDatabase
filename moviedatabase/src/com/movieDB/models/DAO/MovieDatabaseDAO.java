package com.movieDB.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.MovieException;
import com.movieDB.exceptions.RateException;
import com.movieDB.interfaces.MovieDAO;
import com.movieDB.models.Movie;

public class MovieDatabaseDAO implements MovieDAO {
	private static MovieDatabaseDAO dataBaseMovieDAO = null;
	// private static final String ADD_MOVIE = "Insert into movies
	// values(null,?,?)";
	private static final String GET_RATING = "SELECT AVG(rating) as 'rating',Movies_id_video FROM movies_has_rates_from_users GROUP BY Movies_id_video;";
	private List<Movie> allMovies;

	public MovieDatabaseDAO() throws MovieException {
		try {
			Connection con = DBConnection.getInstance().getConnection();
			Statement statment = con.createStatement();
			ResultSet rs = statment.executeQuery("SELECT * FROM movies");
			this.allMovies = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("movie_id");
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String plot = rs.getString("plot");
				String photo = rs.getString("photo");
				this.allMovies.add(new Movie(id, name, year, plot, photo));
			}
		} catch (SQLException e) {

			throw new MovieException("Don`t reload movies collection", e);
		}
	}

	public List<Movie> getAllMovie() {
		List<Movie> result = new ArrayList<>();
		result.addAll(this.allMovies);
		return result;
	}

	public void rateMovie(int rate, int userId, int movieId) throws RateException, MovieException {
		Connection con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM movies_has_rates_from_users WHERE Movies_id_video =" + movieId
					+ " AND Users_user_id=" + userId + ";");
			if (rs.next()) {

				MovieDatabaseDAO.getInstance().deleteAndSetRate(rate, userId, movieId);

			} else {
				st.executeUpdate(
						"INSERT INTO movies_has_rates_from_users value(" + movieId + "," + userId + "," + rate + ")");
			}
		} catch (SQLException e) {
			throw new RateException("Something went wrong with - select from database! ", e);

		}

	}

	private void deleteAndSetRate(int rate, int userId, int movieId) throws RateException {
		Connection con = DBConnection.getInstance().getConnection();

		try {
			Statement st = con.createStatement();

			con.setAutoCommit(false);
			st.executeUpdate("DELETE FROM movies_has_rates_from_users  WHERE Movies_id_video =" + movieId
					+ " AND Users_user_id=" + userId + ";");

			st.executeUpdate(
					"INSERT INTO movies_has_rates_from_users value(" + movieId + "," + userId + "," + rate + ")");
			con.commit();

		} catch (SQLException e) {
			throw new RateException("Transaction for rate is invalid!");

		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println("Autocommit do not turn on!");
				e.printStackTrace();
			}
		}
	}

	public void deleteRate(int userId, int movieId) throws RateException {
		Connection con = DBConnection.getInstance().getConnection();

		try {
			Statement st = con.createStatement();
			st.executeUpdate("DELETE FROM movies_has_rates_from_users  WHERE Movies_id_video =" + movieId
					+ " AND Users_user_id=" + userId + ";");
		} catch (SQLException e) {
			throw new RateException("The rate was not deleted!");

		}

	}

	public float getMovieRating(int id) throws MovieException {
		Connection con = DBConnection.getInstance().getConnection();
		float rating = 0;
		try {
			PreparedStatement ps = con.prepareStatement(GET_RATING);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rating = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MovieException("Don`t calculate the rating", e);
		}
		return rating;

	}

	public static MovieDatabaseDAO getInstance() throws MovieException {

		synchronized (MovieDatabaseDAO.class) {

			if (dataBaseMovieDAO == null) {
				dataBaseMovieDAO = new MovieDatabaseDAO();
			}
		}

		return dataBaseMovieDAO;
	}
	// public int addMovie(Movie movie) throws MovieException {
	// Connection con = DBConnection.getInstance().getConnection();
	// try {
	// PreparedStatement ps = con.prepareStatement(ADD_MOVIE,
	// Statement.RETURN_GENERATED_KEYS);
	// ps.setString(1, movie.getName());
	// ps.setInt(2, movie.getYearOfCreation());
	// ps.setString(3, movie.getPlot());
	//
	// ResultSet rs = ps.getGeneratedKeys();
	// rs.next();
	// movie.setId(rs.getInt(1));
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// throw new MovieException("Can`t add movie", e);
	// }
	// return movie.getId();
	//
	// }
}
