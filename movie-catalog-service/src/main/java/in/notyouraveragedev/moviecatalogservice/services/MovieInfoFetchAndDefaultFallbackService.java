package in.notyouraveragedev.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import in.notyouraveragedev.moviecatalogservice.models.Movie;
import in.notyouraveragedev.moviecatalogservice.models.Rating;

@Service
public class MovieInfoFetchAndDefaultFallbackService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "defaultMovieFallback")
	public Movie getMovieInformation(Rating rating) {
		System.out.println("[**@**] inside getMovieInformation");
		return restTemplate.getForObject("http://movie-info-service/movies/get/" + rating.getMovieId(), Movie.class);
	}

	@SuppressWarnings("unused")
	private Movie defaultMovieFallback(Rating rating) {
		System.out.println("[**@**] inside defaultMovieFallback");
		return new Movie("", "", "");
	}
}
