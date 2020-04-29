package in.notyouraveragedev.moviecatalogservice.models;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Movie {

	private String movieId;	

	private String movieName;

	private String movieDescription;

	private String movieBackdropPath;

	private String moviePosterPath;

	private String movieBudget;

	private String movieReleaseDate;

	private Collection<Genre> movieGenres = new ArrayList<>();

	public Movie() {
		super();
	}

	public Movie(String movieId, String movieName, String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	public String getMovieBackdropPath() {
		return movieBackdropPath;
	}

	@JsonSetter("backdrop_path")
	public void setMovieBackdropPath(String movieBackdropPath) {
		this.movieBackdropPath = movieBackdropPath;
	}

	public String getMoviePosterPath() {
		return moviePosterPath;
	}

	@JsonSetter("poster_path")
	public void setMoviePosterPath(String moviePosterPath) {
		this.moviePosterPath = moviePosterPath;
	}

	public String getMovieBudget() {
		return movieBudget;
	}

	@JsonSetter("budget")
	public void setMovieBudget(String movieBudget) {
		this.movieBudget = movieBudget;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	@JsonSetter("release_date")
	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public Collection<Genre> getMovieGeneres() {
		return movieGenres;
	}

	@JsonSetter("genres")
	public void setMovieGeneres(Collection<Genre> movieGeneres) {
		this.movieGenres = movieGeneres;
	}

	public String getMovieId() {
		return movieId;
	}

	@JsonSetter("id")
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	@JsonSetter("original_title")
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	@JsonSetter("overview")
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", movieBackdropPath=" + movieBackdropPath + ", moviePosterPath=" + moviePosterPath + ", movieBudget="
				+ movieBudget + ", movieReleaseDate=" + movieReleaseDate + ", movieGenres=" + movieGenres + "]";
	}

}
