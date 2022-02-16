package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Series;



public interface Seriesservice2 {
	public String addSeries(Series series);
	
	public Optional<Series> getSeriesById(String id) throws LocationNotFoundException, NameNotFoundException;
	public Optional<List<Series>> getAllSeriesdetails() throws LocationNotFoundException, NameNotFoundException;
	public String deleteSeriesById(String id) throws LocationNotFoundException;
	public String updateSeries(String id, Series series) throws NameNotFoundException, LocationNotFoundException;

	public Series[] getAllSeries() throws LocationNotFoundException, InvalidAmountException;
	
}
