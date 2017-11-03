package com.movieDB.models;

import java.time.LocalDate;

public class Movie {
	private int id;
	private String name;
	private String plot;
	private int yearOfCreation;
	private float rating;

	public Movie(String name, int yearOfCreation, String plot) {
		this.name = name;
	
		this.yearOfCreation = yearOfCreation;

	}

	public Movie(String name, int yearOfCreation, String plot, int id) {
		this(name, yearOfCreation, plot);
		this.id = id;
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
