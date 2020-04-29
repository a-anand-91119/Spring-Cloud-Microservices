package in.notyouraveragedev.movieinfoservice.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import in.notyouraveragedev.movieinfoservice.models.Movie;

public class Utilities {

	public static Movie parseMovieFromJson(String response) {
		if (response == null || response.isEmpty())
			return null;

		Movie movie = new Movie();
		return movie;
	}

	private static void fetchAndWriteImage(String sourceUrl, String targetFileName) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			URL imageUrl = new URL(sourceUrl);
			inputStream = imageUrl.openStream();
			outputStream = new FileOutputStream(targetFileName);
			byte[] byteArray = new byte[2048];
			int length;
			while ((length = inputStream.read(byteArray)) != -1) {
				outputStream.write(byteArray, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				inputStream.close();

			if (outputStream != null)
				outputStream.close();
		}

	}

	public static void storeImagesLocally(Movie fetchedMovie) {
		try {
			fetchAndWriteImage(Constants.tmdbImageUrlPrefix + fetchedMovie.getMovieBackdropPath(),
					Constants.backdropImagePathPrefix + fetchedMovie.getMovieBackdropPath());

			fetchAndWriteImage(Constants.tmdbImageUrlPrefix + fetchedMovie.getMoviePosterPath(),
					Constants.posterImagePathPrefix + fetchedMovie.getMoviePosterPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
