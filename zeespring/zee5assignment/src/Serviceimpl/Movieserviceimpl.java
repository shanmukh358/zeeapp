package Serviceimpl;

import java.util.List;
import java.util.Optional;



import Repositoryimpl.Movierepoimpl;
import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import dto.Movie;
import repository.Movierepo2;
import service.Movieservice2;

public class Movieserviceimpl implements Movieservice2 {
   private Movieserviceimpl() {
    	
    }
	private static  Movieservice2 service;
	public  static Movieservice2 getInstance() {
		if(service==null) {
			service = new Movieserviceimpl();
		}
		return service;
		
	}
	Movierepo2 movieRepository  =  Movierepoimpl.getInstance();
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.addMovie(movie);
	}

	@Override
	public String updateMovie(String id)  {
		// TODO Auto-generated method stub
		return movieRepository.updateMovie(id);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovie();
	}

	@Override
	public String deleteMovieById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}
	

}
