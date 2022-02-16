package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Movierepo;
import com.zee.zee5app.service.Movieservice2;

@Service
public class Movieserviceimpl implements Movieservice2 {
	@Autowired
	private Movierepo movieRepository;
   
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
	 movieRepository.findByMname(movie.getMname());
     Movie movie2=movieRepository.save(movie);
		
		System.out.println(movie2);
		if(movie2!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateMovie(Long id,Movie movie) throws LocationNotFoundException, NameNotFoundException  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(Long id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}
	@Override
	public Optional<Movie> getMovieByName(String mname) {
		// TODO Auto-generated method stub

		return null;
	}
	@Override
	public Movie[] getAllMovies() throws LocationNotFoundException, InvalidAmountException{
		// TODO Auto-generated method stub
		List<Movie> list=movieRepository.findAll();
		Movie[] array=new Movie[list.size()];
		return list.toArray(array);
	}
	@Override
	public Optional<List<Movie>> getAllMoviedetails() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String deleteMovieById(Long id) throws LocationNotFoundException, IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Movie> optional=this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}else {
				movieRepository.deleteById(id);
			}
			return "success";
		} catch (IdNotFoundException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LocationNotFoundException(e.getMessage());
		}
	}
	

}
