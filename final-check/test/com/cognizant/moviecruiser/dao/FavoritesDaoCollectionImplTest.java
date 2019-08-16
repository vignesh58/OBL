package com.cognizant.moviecruiser.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class FavoritesDaoCollectionImplTest {

	@Test
	public void testAddFavorites() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavorites(1, 1);
		favoritesDao.addFavorites(1, 2);
		favoritesDao.addFavorites(2, 2);

		try {
			assertEquals(2f, favoritesDao.getAllFavorites(1L).getNumberOfFavorites(), 0);
		} catch (FavoritesEmptyException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRemoveFavorites() throws FavoritesEmptyException {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.removeFavorites(1, 1);
		try {
			assertEquals(1f, favoriteDao.getAllFavorites(1L).getNumberOfFavorites(), 0);
		} catch (FavoritesEmptyException e) {
			e.printStackTrace();
		}

	}

}
