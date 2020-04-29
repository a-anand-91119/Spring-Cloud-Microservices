package in.notyouraveragedev.movieinfoservice.repository;

import org.springframework.data.repository.CrudRepository;

import in.notyouraveragedev.movieinfoservice.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, String>{

}
