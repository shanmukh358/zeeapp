package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;



public interface Movieservice2 {
	public String addMovie(Movie movie);
	public String updateMovie(Long id,Movie movie) throws LocationNotFoundException, NameNotFoundException;
	public Optional<Movie> getMovieById(Long id) throws LocationNotFoundException, NameNotFoundException;
	public Optional<List<Movie>> getAllMoviedetails() throws LocationNotFoundException, NameNotFoundException;
	public String deleteMovieById(Long id) throws LocationNotFoundException, IdNotFoundException;
	public Movie[] getAllMovies() throws LocationNotFoundException, InvalidAmountException;
	public Optional<Movie> getMovieByName(String mname);
	
}
