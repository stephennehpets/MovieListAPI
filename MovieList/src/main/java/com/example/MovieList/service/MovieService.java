package com.example.MovieList.service;

import java.util.List;

import com.example.MovieList.entity.Movie;

public interface MovieService {
	public List<Movie> retrieveMovies();
	  
	 public Movie getMovie(Long movieId);
	  
	 public void saveMovie(Movie movie);
	  
	 public void deleteMovie(Long movieId);
	  
	 public void updateMovie(Movie movie);
}
