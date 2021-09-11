package pl.uam.movie_selector.spring.repository;

import pl.uam.movie_selector.model.OMDBMovieModel;

import java.util.Optional;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBRepository {

    /**
     * Get movie by title (from OMDB API).
     *
     * @param title movie title.
     * @return movie {@link OMDBMovieModel}.
     */
    Optional<OMDBMovieModel> getMovieByTitle(final String title);

    /**
     * Get movie by id (from OMDB API).
     *
     * @param id movie id.
     * @return movie {@link OMDBMovieModel}.
     */
    Optional<OMDBMovieModel> getMovieById(final String id);

}
