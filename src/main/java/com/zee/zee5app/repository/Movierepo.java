package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Movie;

public interface Movierepo extends JpaRepository<Movie, Long> {
    
	Optional<Movie> findByMname(String mname);
	Optional<Movie> findByMnameAndMdor(String mname,String mdor);
	Optional<List<Movie>> findByMcast(String mcast);
	boolean existsByMname(String mname);
}
