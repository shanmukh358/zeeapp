package com.zee.zee5app.service;


import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.Seriesrepo;

import lombok.Data;


@Data

public class Seriesservice {
	private Seriesrepo repository3=Seriesrepo.getInstance();
	 //service is consuming the Repository
	 private Seriesservice() {
		// TODO Auto-generated constructor stub
	 }
	 //if we want to create that singleton object then we have to create it inside same class.
	 //and we have share reference with others.
	 //to do the same we have to declare a method.
	 
	  private static Seriesservice service3=null;
	 //this would be static only one copy.
	  public static Seriesservice getInstance() {
		  //Because of static it becomes object independent.
		  if(service3==null)
		   service3=new Seriesservice();
		  return service3;
	  }
	  public String  updateSeries(String sid) {
		  //we need to consume repository
		  return this.repository3.updateSeries(sid);
	  }
	  public String  deleteSeries(String sid) {
		  //we need to consume repository
		  return this.repository3.deleteSeries(sid);
	  }
	  public String addSeries(Series series) {
		  //we need to consume repository
		  return this.repository3.addSeries(series);
	  }
	  public Series getSeriesById(String sid) {
		  return repository3.getSeriesById(sid);
	  }

	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return this.repository3.getAllSeries();
	}
}
