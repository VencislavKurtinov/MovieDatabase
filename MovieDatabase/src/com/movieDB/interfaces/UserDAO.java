package com.movieDB.interfaces;

import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;

public interface UserDAO {
	int addUser(User user) throws UserException;

	User getUserByEmailAndPassword(String email, String password) throws UserException;

	void removeUser(int userId) throws UserException;
}