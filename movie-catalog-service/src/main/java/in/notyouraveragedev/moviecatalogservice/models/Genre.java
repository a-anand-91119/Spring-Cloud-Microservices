package in.notyouraveragedev.moviecatalogservice.models;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Genre {

	private int genreId;
	
	private String genreName;

	public Genre() {
		super();
	}

	public int getGenreId() {
		return genreId;
	}

	@JsonSetter("id")
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}
	
	@JsonSetter("name")
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}

}
