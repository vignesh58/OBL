package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {
	public void addFavorites(long userId, long movieId);
	
	public Favorites getAllFavorites(long userId) throws FavoritesEmptyException;

	public void removeFavorites(long userId, long movieId);

}
