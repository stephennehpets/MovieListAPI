package com.example.MovieList.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.MovieList.entity.Movie;
import com.example.MovieList.repository.MovieRepository;
import com.example.MovieList.service.MovieService;
@Service
@Repository
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	 
	public void setMovieRepository(MovieRepository movieRepository) {
		 this.movieRepository = movieRepository;
		}

	@Override
	public List<Movie> retrieveMovies() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

	@Override
	public Movie getMovie(Long movieId) {
		Optional<Movie> optMovie = movieRepository.findById(movieId);
		 return optMovie.get();
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
		
	}

	@Override
	public void deleteMovie(Long movieId) {
		movieRepository.deleteById(movieId);
		
	}

	@Override
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
		
	}

}
