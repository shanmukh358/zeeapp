package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.Seriesrepo2;
import com.zee.zee5app.repository.impl.Seriesrepoimpl;
import com.zee.zee5app.service.Seriesservice2;


@Service
public class Seriesserviceimpl implements Seriesservice2 {
    private Seriesserviceimpl() throws IOException {
    	
    }
	private static Seriesservice2 service;
	
	public static Seriesservice2 getInstance() throws IOException {
		if (service==null) {
			service = new Seriesserviceimpl();
		}
		return service;
	}
	Seriesrepo2 seriesRepository=Seriesrepoimpl.getInstance();
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public String updateSeries(String id,Series series) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.updateSeries(id,series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Optional<ArrayList<Series>> getAllSeries() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String deleteSeriesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeriesById(id);
	}
	
	

}
