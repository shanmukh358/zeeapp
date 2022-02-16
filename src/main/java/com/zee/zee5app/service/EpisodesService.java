package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;

public interface EpisodesService {
   public String addEpisodes(Episodes episodes);
	
	public Optional<Episodes> getEpisodesById(String id) throws LocationNotFoundException, NameNotFoundException;
	public Optional<List<Episodes>> getAllEpisodesdetails() throws LocationNotFoundException, NameNotFoundException;
	public String deleteEpisodesById(String id) throws LocationNotFoundException;
	public String updateEpisodes(String id, Episodes episodes) throws NameNotFoundException, LocationNotFoundException;

	public Episodes[] getAllEpisodes() throws LocationNotFoundException, InvalidAmountException;
}
