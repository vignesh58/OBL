package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavorites(long userId, long movieId) {
		MoviesDao movieDao = new MoviesDaoCollectionImpl();
		Movie movie = movieDao.getMovies(movieId);

		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(movie);
		} else {
			Favorites newFavorite = new Favorites();
			ArrayList<Movie> movieList = new ArrayList<Movie>();
			movieList.add(movie);
			newFavorite.setMovieList(movieList);
			userFavorites.put(userId, newFavorite);
		}
	}

	@Override
	public Favorites getAllFavorites(long userId) throws FavoritesEmptyException {
		Favorites favorite = userFavorites.get(userId);

		if (favorite == null || favorite.getMovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<Movie> favoritesList = favorite.getMovieList();

		favorite.setNumberOfFavorites(favoritesList.size());
		return favorite;
	}

	@Override
	public void removeFavorites(long userId, long movieId) {
		Favorites favorite = userFavorites.get(userId);
		List<Movie> favoritesList = null;

		if (favorite != null) {
			favoritesList = favorite.getMovieList();

			for (int i = 0; i < favoritesList.size(); i++) {
				if (favoritesList.get(i).getId() == movieId) {
					favoritesList.remove(i);
				}
			}
		}
	}

}
