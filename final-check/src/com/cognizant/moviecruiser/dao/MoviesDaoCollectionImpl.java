package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movie> moviesList;

	public MoviesDaoCollectionImpl() {
		super();
		if (moviesList == null) {
			moviesList = new ArrayList<Movie>();

			moviesList.add(new Movie(1l, "Avatar", 2787965087.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			moviesList.add(new Movie(2l, "The Avengers", 1518812988.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			moviesList.add(new Movie(3l, "Titanic", 2187463944f, true, DateUtil.convertToDate("21/08/2018"), "Romance",
					false));
			moviesList.add(new Movie(4l, "Jurassic World", 1671713208f, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			moviesList.add(new Movie(5l, "Avengers End Game", 2750760348f, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));

		}

	}

	@Override
	public List<Movie> getMoviesListAdmin() {
		return moviesList;
	}

	@Override
	public List<Movie> getMoviesListCustomer() {
		List<Movie> list = new ArrayList<Movie>();

		for (Movie movie : moviesList) {
			if (movie.getDateOfLaunch().before(new Date()) && movie.isActive()) {
				list.add(movie);
			}
		}
		return list; 
	}

	@Override
	public void modifyMovies(Movie movie) {
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == movie.getId()) {
				moviesList.set(i, movie);
			}
		}

	}

	@Override
	public Movie getMovies(long movieId) {
		Movie temp = null;
		for (Movie movie : moviesList) {
			if (movie.getId() == movieId) {
				temp = movie;
			}
		}
		return temp;
	}

}
