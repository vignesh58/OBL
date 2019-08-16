package com.cognizant.moviecruiser.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	@Test
	public void testGetMoviesListAdmin() {
		MoviesDaoCollectionImpl moviesDao = new MoviesDaoCollectionImpl();
		List<Movie> moviesList = moviesDao.getMoviesListAdmin();
		assertEquals(5, moviesList.size());

	}

	@Test
	public void testGetMoviesListCustomer() {
		MoviesDaoCollectionImpl moviesDao = new MoviesDaoCollectionImpl();

		List<Movie> moviesList = moviesDao.getMoviesListCustomer();

		assertEquals(3, moviesList.size());

	} 

	@Test
	public void testGetModifyMovies() {
		Movie movie = new Movie(1l, "Avatar", 190000000f, true, DateUtil.convertToDate("15/03/2017"), "Science Fiction",
				true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(movie);
		Movie updatedPrice = moviesDao.getMovies(movie.getId());
		assertEquals(190000000.00f, updatedPrice.getBoxOffice(), 0);

	}

	@Test
	public void testGetMenuItem() {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		long menuId = 4l;
		assertEquals(menuId, moviesDao.getMovies(4).getId());

	}

}
