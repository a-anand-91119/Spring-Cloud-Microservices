package in.notyouraveragedev.moviecatalogservice.models;

public class Movie {

	private String movieId;
	private String movieName;
	private String movieDescription;

	public Movie() {
		super();
	}

	public Movie(String movieId, String movieName, String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "MovieResource [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription="
				+ movieDescription + "]";
	}

}
