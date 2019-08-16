package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {
	private List<Movie> movieList;
	private long numberOfFavorites;

	public Favorites() {
		super();

	}

	public Favorites(List<Movie> movieList, long numberOfFavorites) {
		super();
		this.movieList = movieList;
		this.numberOfFavorites = numberOfFavorites;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public double getNumberOfFavorites() {
		return numberOfFavorites;
	}

	public void setNumberOfFavorites(long numberOfFavorites) {
		this.numberOfFavorites = numberOfFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(numberOfFavorites);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (Double.doubleToLongBits(numberOfFavorites) != Double.doubleToLongBits(other.numberOfFavorites))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [movieList=" + movieList + ", total=" + numberOfFavorites + "]";
	}

}
