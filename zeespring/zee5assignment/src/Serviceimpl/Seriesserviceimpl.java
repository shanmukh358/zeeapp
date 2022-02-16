package Serviceimpl;

import java.util.List;
import java.util.Optional;

import Repositoryimpl.Seriesrepoimpl;
import app.Exception.LocationNotFoundException;
import dto.Series;
import repository.Seriesrepo2;
import service.Seriesservice2;

public class Seriesserviceimpl implements Seriesservice2 {
    private Seriesserviceimpl() {
    	
    }
	private static Seriesservice2 service;
	
	public static Seriesservice2 getInstance() {
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
	public String updateSeries(String id) {
		// TODO Auto-generated method stub
		return seriesRepository.updateSeries(id);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public List<Series> getAllSeries() {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String deleteSeriesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeriesById(id);
	}
	
	

}
