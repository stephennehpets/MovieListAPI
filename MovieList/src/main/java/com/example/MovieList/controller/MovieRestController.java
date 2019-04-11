package com.example.MovieList.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MovieList.service.MovieService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.example.MovieList.entity.Movie;
import com.example.MovieList.impl.MovieServiceImpl;

//@SpringBootApplication(scanBasePackages = {"com.example.MovieList.service"})
@RestController
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.MovieList.service"})

public class MovieRestController {
//	@RequestMapping("/test")
//	String test() {
//		return "sup";
//	}
	 @Autowired
	 private MovieService movieService;
	 public void setMovieService(MovieService movieService) {
	  this.movieService = movieService;
	 }
	 
	 @GetMapping("/api/timeOfDay")
	 public LocalDateTime getCurrentTime(){
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();
		 return now;
	 }
	 
	 @GetMapping("/api/movies/list")
	 public List<Movie> getMovies() {
	  List<Movie> movies = movieService.retrieveMovies();
	  return movies;
	 }
	  
	 @GetMapping("/api/movies/{movieId}")
	 public Movie getMovie(@PathVariable(name="movieId")Long movieId) {
	  return movieService.getMovie(movieId);
	 }
	  
	 @PostMapping("/api/movies")
	 public void saveMovie(Movie movie){
		 movieService.saveMovie(movie);
	  System.out.println("Movie Saved Successfully");
	 }
	  
	 @DeleteMapping("/api/movies/{movieId}")
	 public void deleteMovie(@PathVariable(name="movieId")Long movieId){
		 movieService.deleteMovie(movieId);
	  System.out.println("Movie Deleted Successfully");
	 }
	  
	 @PutMapping("/api/movies/{movieId}")
	 public void updateMovie(@RequestBody Movie movie,
	   @PathVariable(name="movieId")Long movieId){
		 Movie emp = movieService.getMovie(movieId);
	  if(emp != null){
		  movieService.updateMovie(movie);
	  }
	   
	 }
}
