package com.example.MovieList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Genre")
    private String genre;

    @Column(name="YearReleased")
    private String yearReleased;

    @Column(name="Rating")
    private String rating;
    
    public Movie() {
    	
    }
    
    public Movie(Long id, String name, String genre, String YearReleased, String rating) {
    	this.id = id;
    	this.name = name;
    	this.genre = genre;
    	this.yearReleased = YearReleased;
    	this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}