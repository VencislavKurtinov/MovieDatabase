package com.movieDB.models;

public class User {
	private long id;
	private String name;
	private String email;
	private String password;

	public User(long id, String name, String email, String pasword) {
		this(name, email, pasword);
		this.id = id;

	}

	public User(String name, String email, String pasword) {
		this(email, pasword);
		this.name = name;

	}
	public User(String email, String pasword) {
		this.email = email;
		this.password = pasword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {

		return name;

	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		if (name != null) {
			this.email = email;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
