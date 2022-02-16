package service;

import java.util.List;
import java.util.Optional;

import app.Exception.LocationNotFoundException;
import dto.Series;

public interface Seriesservice2 {
	public String addSeries(Series series);
	public String updateSeries(String id);
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException;
	public List<Series> getAllSeries();
	public String deleteSeriesById(String id) throws LocationNotFoundException;
	
}
