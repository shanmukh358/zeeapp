package service;

import java.util.List;
import java.util.Optional;

import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import dto.Movie;

public interface Movieservice2 {
	public String addMovie(Movie movie);
	public String updateMovie(String id);
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException;
	public List<Movie> getAllMovie();
	public String deleteMovieById(String id) throws LocationNotFoundException;
	
}
