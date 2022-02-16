package repository;

import dto.Movie;
import dto.Series;
import lombok.Data;
@Data
public class Seriesrepo {
	private Series[] seriess=new Series[10];
	   private static int count=-1;
	   private Seriesrepo() {
		// TODO Auto-generated constructor stub
	  }
	   public Series[] getAllSeries() {
		   return seriess;
	   }
	   
	   //delete Series
	   public String deleteSeries(String sid) {
		   Series temp[]=new Series[seriess.length-1];
		   int index=0;
		   for(Series series:seriess) {
				 if(series.getSid().equals(sid)) {
					 break;
				 }
				 index++;
			 }
		   int rem=seriess.length-(index+1);
		   System.arraycopy(seriess,0, temp, 0,index);
		   System.arraycopy(seriess,index+1, temp, index,rem);
		   seriess=temp;
		   return "Deleted";
	   
	  }
	   //update Series
	   public String updateSeries(String sid) {
		   for(Series series:seriess) {
				 if(series.getSid().equals(sid)) {
					 series.setScat("Thriller");
				 }
				 
			 }
		   return "Updated";
	   }
	   
	   //series details based on id
	 public Series getSeriesById(String mid) {
		 //we need to traverse the array
		 for(Series series:seriess) {
			 if(series.getSid().equals(mid)) {
				 return series;
			 }
			 
		 }
		return null;
	 }
	   //add a new series
	   public String addSeries(Series series) {
		   
		   if(count==seriess.length-1) {
			   //array is full so we should go for dynamically increasing size of array.
			   Series temp[]=new Series[seriess.length*2];
			   System.arraycopy(seriess,0, temp, 0,seriess.length);
			   seriess=temp;
			   seriess[++count]=series;
			   return "success";
		   }
		   seriess[++count]=series;
		   return "success";
		   
		}
	   
	   
	  private static Seriesrepo repository3=null;
	   //this would be static only one copy.
	    public static Seriesrepo getInstance() {
	  	  //Because of static it becomes object independent.
	  	  if(repository3==null)
	  	   repository3=new Seriesrepo();
	  	  return repository3;
	    }  
}
