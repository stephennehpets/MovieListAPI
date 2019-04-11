package com.example.MovieList;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.MovieList.controller.MovieRestController;
import com.example.MovieList.entity.Movie;
import com.example.MovieList.service.MovieService;
@AutoConfigureWebTestClient
@EnableAutoConfiguration
@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieService.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ControllerTests {
	@Autowired
    MovieService MovieService;
    @Test
    public void getMovieTest() throws Exception {

    	Movie movie = new Movie((long)1, "it", "horror", "2018", "r");
        MovieService.saveMovie(movie);
        
        Movie found = MovieService.getMovie((long)1);        

        assert(found.getName().contentEquals(movie.getName()));
    }
    
    public void addMovieTest() throws Exception {

    	List<Movie> before = MovieService.retrieveMovies();
    	Movie movie = new Movie((long)1, "it", "horror", "2018", "r");
        MovieService.saveMovie(movie);
        
        List<Movie> after = MovieService.retrieveMovies();       

        assert(after.size() - before.size() == 1);
    }
    
    public void deleteMovieTest() throws Exception {

    	Movie movie = new Movie((long)1, "it", "horror", "2018", "r");
        MovieService.saveMovie(movie);
        List<Movie> before = MovieService.retrieveMovies();
        
        MovieService.deleteMovie((long)1);
        List<Movie> after = MovieService.retrieveMovies();       

        assert(before.size() - after.size() == 1);
    }
    
    public void updateMovieTest() throws Exception {

    	Movie movie = new Movie((long)1, "it", "horror", "2018", "r");
        MovieService.saveMovie(movie);
        
        movie.setGenre("comedy");
        
        MovieService.updateMovie(movie);       
        
        Movie updated = MovieService.getMovie((long)1);
        assert(updated.getGenre().contentEquals("comedy"));
    }
}