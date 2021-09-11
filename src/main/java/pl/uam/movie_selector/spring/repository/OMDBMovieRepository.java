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

    /**
     * Get the list of all movies (with details from OMDB) (from database).
     *
     * @return list of all movies {@link OMDBMovieModel}.
     */
    ArrayList<OMDBMovieModel> findAll();

    /**
     * Get movie by id (from database).
     *
     * @param imdbID movie id.
     * @return movie {@link OMDBMovieModel}.
     */
    Optional<OMDBMovieModel> findByImdbID(String imdbID);

    /**
     * Get the quantity of movies (from database).
     *
     * @return quantity of movies.
     */
    long count();
}
