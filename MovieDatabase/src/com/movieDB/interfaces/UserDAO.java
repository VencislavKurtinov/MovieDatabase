package com.movieDB.interfaces;

import com.movieDB.exceptions.UserException;
import com.movieDB.models.User;

public interface UserDAO {
	void addUser(User user) throws UserException;

	User getUserByEmailAndPassword(String email, String password) throws UserException;

	void removeUser(long userId) throws UserException;
}