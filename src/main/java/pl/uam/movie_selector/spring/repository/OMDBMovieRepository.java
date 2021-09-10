package pl.uam.movie_selector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.uam.movie_selector.model.OMDBMovieModel;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBMovieRepository extends CrudRepository<OMDBMovieModel, String>, PagingAndSortingRepository<OMDBMovieModel, String> {

    ArrayList<OMDBMovieModel> findAll();

    Optional<OMDBMovieModel> findByImdbID(String imdbID);

    long count();
}
