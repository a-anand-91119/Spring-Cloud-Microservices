package in.notyouraveragedev.movieinfoservice.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity(name = "movie_info")
public class Movie {

	@Id
	@Column(name = "mi_id")
	private String movieId;

	@Column(name = "mi_movie_name")
	private String movieName;

	@Column(name = "mi_movie_description", length=2000)
	private String movieDescription;

	@Column(name = "mi_backdrop_path ")
	private String movieBackdropPath;

	@Column(name = "mi_poster_path ")
	private String moviePosterPath;

	@Column(name = "mi_budget ")
	private String movieBudget;

	@Column(name = "mi_release_date ")
	private String movieReleaseDate;

	@ManyToMany(cascade = CascadeType.ALL)
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
