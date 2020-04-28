package in.notyouraveragedev.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.notyouraveragedev.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/rating")
public class RatingResource {

	@RequestMapping("{movieId}")
	public Rating getMovieRating(@PathVariable("movieId")String movieId) {
		return new Rating("AVG", 4);
	}
}
