package in.notyouraveragedev.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.notyouraveragedev.movieinfoservice.models.Movie;
import in.notyouraveragedev.movieinfoservice.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/get/{movieId}")
	public Movie getMovieInformation(@PathVariable("movieId") String movieId) {
		return movieService.getMovie(movieId);
	}
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return getMovie(movieId);
	}

	private Movie getMovie(String movieId) {
		switch (movieId) {
		case "MOV_1":
			return new Movie(movieId, "Movie 1", "Movie Description 1");
		case "MOV_2":
			return new Movie(movieId, "Movie 2", "Movie Description 2");
		case "MOV_3":
			return new Movie(movieId, "Movie 3", "Movie Description 3");
		case "MOV_4":
			return new Movie(movieId, "Movie 4", "Movie Description 4");
		case "MOV_5":
			return new Movie(movieId, "Movie 5", "Movie Description 5s");
		default:
			return new Movie();
		}
	}
}
