package in.notyouraveragedev.movieinfoservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity(name="movie_genres")
public class Genre {

	@Id
	@Column(name="g_id")
	private int genreId;
	
	@Column(name="g_name")
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
