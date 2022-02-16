package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.Movierepo;
import com.zee.zee5app.service.Movieservice2;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	Movieservice2 movieService;
	
	@Autowired
	Movierepo moviesRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@Valid @RequestBody Movie movieRequest){

		if(moviesRepository.existsByMname(movieRequest.getMname())) {
			return ResponseEntity.badRequest()
					 .body(new MessageResponse("Error: Movie with name: "+movieRequest.getMname()+" exists!"));
		}
		
		Movie movies = new Movie(movieRequest.getMname(),
				movieRequest.getMcat(),
				movieRequest.getMdor(),
				movieRequest.getMcast(),
				movieRequest.getMlength(),
				movieRequest.getMlanguage(),
				movieRequest.getMtrailer());
		
		moviesRepository.save(movies);
		return ResponseEntity.status(201).body(new MessageResponse("Movie added successfully"));
	}

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/getMovie/{mname}")
	public ResponseEntity<?> getMovie(@PathVariable("mname") String mname) {

		if (moviesRepository.existsByMname(mname)) {
			Optional<Movie> movie1 = moviesRepository.findByMname(mname);
			return ResponseEntity.ok(movie1);
		}
		return ResponseEntity.badRequest()
				 .body(new MessageResponse("Error: Movie with name: "+mname+" does not exists!"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllMovies() throws LocationNotFoundException, NameNotFoundException {
		Optional<List<Movie>> optional = movieService.getAllMoviedetails();
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}
	 
}
