package com.movieDB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.UserException;
import com.movieDB.interfaces.UserDAO;
import com.movieDB.models.User;
import com.mysql.jdbc.Statement;

public class UserDataBaseDAO implements UserDAO {
	private static UserDataBaseDAO dataBaseUserDAO = null;
	private static final String DELETE_FROM_USERS_WHERE_ID = "DELETE FROM users WHERE id = ? ";
	private static final String SELECT_FROM_USERS_WHERE_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ? ";
	private static final String ADD_USER_QUERY = "Insert into users values(?,?,null,?)";

	@Override
	public void addUser(User user) throws UserException {
		if (user != null) {
			Connection con = DBConnection.getInstance().getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(ADD_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.executeUpdate();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				user.setId(rs.getLong(1));

			} catch (SQLException e) {
				e.printStackTrace();
				throw new UserException("Can`t add a User", e);
			}
		}

	}

	@Override
	public void removeUser(long userId) throws UserException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_FROM_USERS_WHERE_ID);
			ps.setLong(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("Can`t delete a User with id: " + userId, e);
		}

	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) throws UserException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_FROM_USERS_WHERE_EMAIL_AND_PASSWORD);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			
			result.next();
			String name = result.getString(1);
			email = result.getString(2);
			long id = result.getLong(3);
			password = result.getString(4);
			return new User(id, name, email, password);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("Can`t find a User with  this email and password: ", e);
		}

	}

	public static UserDAO getDataBaseUserDAO() {

		synchronized (UserDataBaseDAO.class) {

			if (dataBaseUserDAO == null) {
				dataBaseUserDAO = new UserDataBaseDAO();
			}
		}

		return dataBaseUserDAO;
	}

}
