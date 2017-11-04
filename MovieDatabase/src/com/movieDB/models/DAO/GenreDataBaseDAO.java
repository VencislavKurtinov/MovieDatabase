package com.movie.DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.movie.DBconection.DBConnection;
import com.movie.exceptions.UserException;
import com.movie.interfaces.GenreDAO;
import com.movie.interfaces.UserDAO;
import com.movieDB.models.Genres;

public class GenreDataBaseDAO implements GenreDAO{
	private static GenreDAO dataBaseGenreDAO = null;
	private static final String DISPLAY_GENRES = "SELECT type_genre FROM Genres ORDER BY type_genre";
	
	
		
	@Override
	public void getAllGenres() {
//		public List<Genres> getAllGenres() {

		
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DISPLAY_GENRES);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				String genre = result.getString(1);
				System.out.println(genre);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Genres getGenres(String genreName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	public static GenreDAO getDataBaseGenreDAO() {

		synchronized (UserDataBaseDAO.class) {

			if (dataBaseGenreDAO == null) {
				dataBaseGenreDAO = new GenreDataBaseDAO();
			}
		}

		return dataBaseGenreDAO;
	}
	
	
	
	
	
	
	
	
	
	
	

}
