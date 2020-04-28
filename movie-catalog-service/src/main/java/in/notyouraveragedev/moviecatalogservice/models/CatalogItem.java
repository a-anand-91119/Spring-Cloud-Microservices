package in.notyouraveragedev.moviecatalogservice.models;

public class CatalogItem {

	private String movieName;
	private String movieDescription;
	private int movieRating;

	public CatalogItem() {
		super();
	}

	public CatalogItem(String movieName, String movieDescription, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
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

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "CatalogItem [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieRating="
				+ movieRating + "]";
	}

}
