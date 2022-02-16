package com.zee.zee5app.repository;


import com.zee.zee5app.dto.Movie;

import lombok.Data;
@Data
public class Movierepo {
	private Movie[] movies=new Movie[10];
	   private static int count=-1;
	   private Movierepo() {
		// TODO Auto-generated constructor stub
	  }
	   public Movie[] getAllMovies() {
		   return movies;
	   }
	   
	   //delete movie
	   public String deleteMovie(String mid) {
		   Movie temp[]=new Movie[movies.length-1];
		   int index=0;
		   for(Movie movie:movies) {
				 if(movie.getMid().equals(mid)) {
					 break;
				 }
				 index++;
			 }
		   int rem=movies.length-(index+1);
		   System.arraycopy(movies,0, temp, 0,index);
		   System.arraycopy(movies,index+1, temp, index,rem);
		   movies=temp;
		   return "Deleted";
	   
	  }
	   //update movie
	   public String updateMovie(String mid) {
		   for(Movie movie:movies) {
				 if(movie.getMid().equals(mid)) {
					 movie.setMcat("Horror");
				 }
				 
			 }
		   return "Updated";
	   }
	   
	   //movie details based on id
	 public Movie getMovieById(String mid) {
		 //we need to traverse the array
		 for(Movie movie:movies) {
			 if(movie.getMid().equals(mid)) {
				 return movie;
			 }
			 
		 }
		return null;
	 }
	   //add a new movie
	   public String addMovie(Movie movie) {
		   
		   if(count==movies.length-1) {
			   //array is full so we should go for dynamically increasing size of array.
			   Movie temp[]=new Movie[movies.length*2];
			   System.arraycopy(movies,0, temp, 0,movies.length);
			   movies=temp;
			   movies[++count]=movie;
			   return "success";
		   }
		   movies[++count]=movie;
		   return "success";
		   
		}
	   
	   
	  private static Movierepo repository2=null;
	   //this would be static only one copy.
	    public static Movierepo getInstance() {
	  	  //Because of static it becomes object independent.
	  	  if(repository2==null)
	  	   repository2=new Movierepo();
	  	  return repository2;
	    }  
}
