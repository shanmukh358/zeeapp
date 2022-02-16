package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;



public interface Movieservice2 {
	public String addMovie(Movie movie);
	public String updateMovie(String id,Movie movie) throws LocationNotFoundException, NameNotFoundException;
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException, NameNotFoundException;
	public Optional<ArrayList<Movie>> getAllMovie() throws LocationNotFoundException, NameNotFoundException;
	public String deleteMovieById(String id) throws LocationNotFoundException, IdNotFoundException;
	
}
