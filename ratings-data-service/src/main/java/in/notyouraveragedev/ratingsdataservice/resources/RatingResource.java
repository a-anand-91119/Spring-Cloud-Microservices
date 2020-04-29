package in.notyouraveragedev.ratingsdataservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.notyouraveragedev.ratingsdataservice.models.Rating;
import in.notyouraveragedev.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingResource {

	@RequestMapping("{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		return new Rating("AVG", 4);
	}

	@RequestMapping("user/{userId}")
	public UserRating getMovieRatingForUser(@PathVariable("userId") String userId) {
		return new UserRating(userId,
				Arrays.asList(new Rating("500", 5), new Rating("5", 4), new Rating("3", 3)));
	}
}
