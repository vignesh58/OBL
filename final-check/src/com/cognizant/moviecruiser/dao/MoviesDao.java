package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface MoviesDao {
	public List<Movie> getMoviesListAdmin();

	public List<Movie> getMoviesListCustomer();

	public void modifyMovies(Movie movie);

	public Movie getMovies(long movieId);

}
