package Repositoryimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import app.Exception.LocationNotFoundException;
import dto.Movie;
import dto.Series;
import dto.Subscription;
import repository.Movierepo2;
import repository.Seriesrepo2;

public class Seriesrepoimpl implements Seriesrepo2 {
	private Set<Series> hset = new LinkedHashSet<>();
   private Seriesrepoimpl() {
    }
    private static Seriesrepo2 repository;
    public static Seriesrepo2 getInstance() {
    	if(repository==null) {
    		repository=new Seriesrepoimpl();
    	}
    	return repository;
    }
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		boolean result = this.hset.add(series);
		System.out.println(this.hset.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateSeries(String id) {
		// TODO Auto-generated method stub
		for (Series register1 : hset) {
			if(register1.getSid().equals(id)) {
				register1.setSlanguage("Hindi");
			}
		}
		return "updated";
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException{
		// TODO Auto-generated method stub
		for (Series series : hset) {
			if(series.getSid().equals(id)) {
				return Optional.of(series);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Series> getAllSeries() {
		// TODO Auto-generated method stub
       List<Series> arrlist=new ArrayList(hset);
		Collections.sort(arrlist);
		return arrlist;
	}

	@Override
	public String deleteSeriesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
     Optional<Series> optional = this.getSeriesById(id);
		
		if(optional.isPresent()) {
			// removal
			
			boolean result = hset.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else
				return "fail";
		}
		return "fail";
	}
  

}
