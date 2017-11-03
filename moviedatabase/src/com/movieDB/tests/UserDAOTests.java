package com.movieDB.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.movieDB.connection.DBConnection;
import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;
import com.movieDB.models.DAO.UserDatabaseDAO;

public class UserDAOTests {
	private static User user = new User("Shasho", "proba@abv.bg", "300godini");
	private static int userId;
	private static Connection con = null;

	@Test
	public void testConnection() {
		con = DBConnection.getInstance().getConnection();
		assertNotNull(con);
	}

	@Test
	public void testAddUser() throws UserException, SQLException {
		UserDatabaseDAO dao = new UserDatabaseDAO();

		int userId = dao.addUser(user);
		user.setId(userId);

		assertNotNull(dao.getUserByEmailAndPassword(user.getEmail(), user.getPassword()));

		dao.removeUser(user.getId());

		// }
		//
		// @Test
		// public void testGetUserByEmailAndPassword() throws SQLException,
		// UserException {
		// UserDatabaseDAO dao = new UserDatabaseDAO();
		// assertNotNull(dao.getUserByEmailAndPassword(user.getEmail(),
		// user.getPassword()));
		//
		// }
		//
		// @Test
		// public void testRemoveUser() throws SQLException, UserException {
		// UserDatabaseDAO dao = new UserDatabaseDAO();
		// dao.removeUser(user.getId());
		//
		// }

	}
}
