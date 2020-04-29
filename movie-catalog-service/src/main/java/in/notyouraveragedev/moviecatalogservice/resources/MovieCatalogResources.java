package in.notyouraveragedev.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.notyouraveragedev.moviecatalogservice.models.CatalogItem;
import in.notyouraveragedev.moviecatalogservice.models.Movie;
import in.notyouraveragedev.moviecatalogservice.models.UserRating;
import in.notyouraveragedev.moviecatalogservice.services.MovieInfoFetchAndDefaultFallbackService;
import in.notyouraveragedev.moviecatalogservice.services.UserRatingFetchAndFallbackService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

	@Autowired
	private UserRatingFetchAndFallbackService userRatingFetchAndFallbackService;

	@Autowired
	private MovieInfoFetchAndDefaultFallbackService movieInfoFetchAndDefaultFallbackService;

	@Autowired
	private DiscoveryClient dicoveryClient;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		// to make a reqeust to another service use RestTemplate
		// better approach would be to use WebClient
		List<ServiceInstance> services = dicoveryClient.getInstances("movie-info-service");
		services.stream().forEach(service -> System.out.println(service.getInstanceId()));

		// get list of all the rated movies from rating service
		UserRating ratings = userRatingFetchAndFallbackService.getUserRatingInformation(userId);

		// get the movie details from movie info service
		return ratings.getRatings().stream().map(rating -> {
			Movie movie = movieInfoFetchAndDefaultFallbackService.getMovieInformation(rating);
			System.out.println(movie);
			return new CatalogItem(movie.getMovieName(), movie.getMovieDescription(), rating.getRating());
		}).collect(Collectors.toList());
		// display them togethter
	}

}
