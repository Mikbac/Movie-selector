package pl.uam.movieSelector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.uam.movieSelector.model.OMDBMovieModel;

import java.util.ArrayList;
import java.util.Optional;

public interface OMDBMovieRepository extends CrudRepository<OMDBMovieModel, String>, PagingAndSortingRepository<OMDBMovieModel, String> {

    ArrayList<OMDBMovieModel> findAll();

    Optional<OMDBMovieModel> findByImdbID(String imdbID);
}
