
package com.example.MovieList;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.MovieList.entity.Movie;
import com.example.MovieList.impl.MovieServiceImpl;
import com.example.MovieList.repository.MovieRepository;
import com.example.MovieList.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieService.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@EnableAutoConfiguration
@ComponentScan
public class MovieListApplicationTests {
	@Autowired
	private MovieService ms;
    @Autowired
	private WebTestClient webClient;
    
    @Test
    public void testGetMovieList() {
    	
    	this.webClient.get().uri("/api/movies/list").exchange().expectStatus().isOk();
    }
    
    @Test
    public void testGetTimeOfDay() {
    	
    	this.webClient.get().uri("/api/timeOfDay").exchange().expectStatus().isOk();
    }
    
    @Test
    public void testGet() {
    	
    	Movie movie = new Movie((long)0, "it", "horror", "2018", "r");
    	ms.saveMovie(movie);
    	
    	this.webClient.get().uri("/api/movies/1").exchange().expectStatus().isOk();
    }
    
    @Test
    public void testPost() {
    	
    	this.webClient.post().uri("/api/movies").exchange().expectStatus().isOk();
    }
    
    @Test
    public void testDelete() {
    	
    	this.webClient.delete().uri("/api/movies/1").exchange().expectStatus().isOk();
    }

}

