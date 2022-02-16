package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.Movierepo2;
import com.zee.zee5app.repository.impl.Movierepoimpl;
import com.zee.zee5app.service.Movieservice2;

@Service



public class Movieserviceimpl implements Movieservice2 {
   private Movieserviceimpl() throws IOException{
    	
    }
	private static  Movieservice2 service;
	public  static Movieservice2 getInstance() throws IOException {
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
	public String updateMovie(String id,Movie movie) throws LocationNotFoundException, NameNotFoundException  {
		// TODO Auto-generated method stub
		return movieRepository.updateMovie(id,movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Optional<ArrayList<Movie>> getAllMovie() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovie();
	}

	@Override
	public String deleteMovieById(String id) throws LocationNotFoundException, IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}
	

}
