package service;

import dto.Movie;
import lombok.Data;
import repository.Movierepo;

@Data

public class Movieservice {
	private Movierepo repository2=Movierepo.getInstance();
	 //service is consuming the Repository
	 private Movieservice() {
		// TODO Auto-generated constructor stub
	 }
	 //if we want to create that singleton object then we have to create it inside same class.
	 //and we have share reference with others.
	 //to do the same we have to declare a method.
	 
	  private static Movieservice service2=null;
	 //this would be static only one copy.
	  public static Movieservice getInstance() {
		  //Because of static it becomes object independent.
		  if(service2==null)
		   service2=new Movieservice();
		  return service2;
	  }
	  public String updateMovie(String mid) {
		  return this.repository2.updateMovie(mid);
	  }
	  public String deleteMovie(String mid) {
		  return this.repository2.deleteMovie(mid);
	  }
	  public String addMovie(Movie movie) {
		  //we need to consume repository
		  return this.repository2.addMovie(movie);
	  }
	  public Movie getMovieById(String mid) {
		  return repository2.getMovieById(mid);
	  }

	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return this.repository2.getAllMovies();
	}

}
