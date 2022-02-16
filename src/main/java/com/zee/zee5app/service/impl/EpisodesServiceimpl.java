package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.service.EpisodesService;
@Service
public class EpisodesServiceimpl implements EpisodesService {
    @Autowired
    private EpisodesRepository episodesRepository;
	@Override
	public String addEpisodes(Episodes episodes) {
		// TODO Auto-generated method stub
		Episodes episodes2=episodesRepository.save(episodes);
		
		System.out.println(episodes2);
		if(episodes2!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Episodes> getEpisodesById(String id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episodes> episodes=this.episodesRepository.findById(id);
		if(episodes.isEmpty()) {
			throw new LocationNotFoundException("Id not found");
		}
		return episodes;
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodesdetails() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodesRepository.findAll());
	}

	@Override
	public String deleteEpisodesById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Episodes> optional=this.getEpisodesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}else {
				episodesRepository.deleteById(id);
			}
			return "success";
		} catch (IdNotFoundException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LocationNotFoundException(e.getMessage());
	}
	}

	@Override
	public String updateEpisodes(String id, Episodes episodes) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Episodes[] getAllEpisodes() throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		List<Episodes> list=episodesRepository.findAll();
		Episodes[] array=new Episodes[list.size()];
		return list.toArray(array);
	}

}
