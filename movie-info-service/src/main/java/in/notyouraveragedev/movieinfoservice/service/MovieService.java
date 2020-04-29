package in.notyouraveragedev.movieinfoservice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import in.notyouraveragedev.movieinfoservice.models.Movie;
import in.notyouraveragedev.movieinfoservice.repository.MovieRepository;
import in.notyouraveragedev.movieinfoservice.util.Constants;
import in.notyouraveragedev.movieinfoservice.util.Utilities;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${tmdb.api.key}")
	private String apiKey;

	public Movie getMovie(String movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		
		if (movie.isPresent()) {
			System.out.println(movie.get());
			return movie.get();
		}
		/*
		 * Make an API call to TMDB get the details. If the movie exists, then store it
		 * in local database and return it. Otherwise return an empty Movie Object.
		 */
		Map<String, String> parameters = new HashMap<>();
		parameters.put("movieId", movieId);
		parameters.put("apiKey", apiKey);

		Movie fetchedMovie = restTemplate.getForObject(Constants.fetchMovieByIdUrl, Movie.class, parameters);

		if (fetchedMovie == null) {
			System.out.println("NOTING FROM API");
			return new Movie();
		}

		Utilities.storeImagesLocally(fetchedMovie);
		movieRepository.save(fetchedMovie);
		System.out.println(fetchedMovie);
		return fetchedMovie;
	}
	
	public Movie fallbackForTMDB(String movieId) {
		return new Movie();
	}

}
