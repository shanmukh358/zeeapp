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
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.Seriesrepo;

import com.zee.zee5app.service.Seriesservice2;


@Service
public class Seriesserviceimpl implements Seriesservice2 {
	@Autowired
	private Seriesrepo seriesRepository;
    public Seriesserviceimpl() throws IOException {
    	
    }
//	private static Seriesservice2 service;
//	
//	public static Seriesservice2 getInstance() throws IOException {
//		if (service==null) {
//			service = new Seriesserviceimpl();
//		}
//		return service;
//	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		 Series series2=seriesRepository.save(series);
			
			System.out.println(series2);
			if(series2!=null) {
				return "success";
			}
			return "fail";
	}

	@Override
	public String updateSeries(String id,Series series) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}
	@Override
	public Series[] getAllSeries() throws LocationNotFoundException, InvalidAmountException{
		// TODO Auto-generated method stub
		List<Series> list=seriesRepository.findAll();
		Series[] array=new Series[list.size()];
		return list.toArray(array);
	}
	@Override
	public Optional<List<Series>> getAllSeriesdetails() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}

	@Override
	public String deleteSeriesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional=this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}else {
				seriesRepository.deleteById(id);
			}
			return "success";
		} catch (IdNotFoundException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LocationNotFoundException(e.getMessage());
	}
	
	}
}


