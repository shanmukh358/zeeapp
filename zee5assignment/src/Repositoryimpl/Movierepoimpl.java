package Repositoryimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import dto.Movie;
import dto.Subscription;
import repository.Movierepo2;
import repository.Subrepo2;

public class Movierepoimpl implements Movierepo2 {
	private TreeSet<Movie> set = new TreeSet<>();
    private Movierepoimpl() {
    	
    }
    private static Movierepo2 repository;
    public static Movierepo2 getInstance() {
    	if(repository==null) {
    		repository=new Movierepoimpl();
    	}
    	return repository;
    }
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(movie);
		System.out.println(this.set.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateMovie(String id)  {
		// TODO Auto-generated method stub
		for (Movie register1 : set) {
			if(register1.getMid().equals(id)) {
				register1.setMlanguage(id);
			}
		}
		return "updated";
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		for (Movie movie : set) {
			if(movie.getMid().equals(id)) {
				return Optional.of(movie);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
       List<Movie> arrlist=new ArrayList<>(set);
       Collections.sort(arrlist);
       return arrlist;
	}

	@Override
	public String deleteMovie(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
      Optional<Movie> optional = this.getMovieById(id);
		
		if(optional.isPresent()) {
			// removal
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else
				return "fail";
		}
		return "fail";
	}
  

}
