package com.movieDB.models;

public class Movie {
	private int id;
	private String name;
	private String plot;
	private int yearOfCreation;
	private float rating;
	private String photo;

	private String country;
	private String runTime;
	private String genre;
	private String actors;
	private String type;
	private String director;

	public Movie(String name, String plot, int yearOfCreation, String photo, String country, String runTime,
			String genre, String actors, String type, String director) {

		this.name = name;
		this.plot = plot;
		this.yearOfCreation = yearOfCreation;
		this.photo = photo;
		this.country = country;
		this.runTime = runTime;
		this.genre = genre;
		this.actors = actors;
		this.type = type;
		this.director = director;
	}

	public Movie(String name, int yearOfCreation, String plot, String photo) {
		this.name = name;
		this.yearOfCreation = yearOfCreation;
		this.plot = plot;
		if (photo == null || photo.isEmpty()) {
			this.photo = "C:\\img\\nothing.jpg";
		} else {
			this.photo = photo;
		}

	}

	public Movie(int id, String name, int yearOfCreation, String plot, String photo) {
		this(name, yearOfCreation, plot, photo);
		this.id = id;

	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfCreation() {
		return yearOfCreation;
	}

	public void setYearOfCreation(int yearOfCreation) {
		this.yearOfCreation = yearOfCreation;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

}
