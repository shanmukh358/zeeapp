package repository;

import java.util.List;
import java.util.Optional;

import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import dto.Movie;
import dto.Subscription;

public interface Movierepo2 {
	public String addMovie(Movie movie);
	public String updateMovie(String id)  ;
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException;
	public List<Movie> getAllMovie();
	public String deleteMovie(String id) throws LocationNotFoundException;
	
}
