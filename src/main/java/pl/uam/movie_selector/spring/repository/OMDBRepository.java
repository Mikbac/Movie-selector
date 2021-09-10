package pl.uam.movie_selector.spring.repository;

import pl.uam.movie_selector.model.OMDBMovieModel;

import java.util.Optional;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBRepository {

    Optional<OMDBMovieModel> getMovieByTitle(final String title);

    Optional<OMDBMovieModel> getMovieById(final String id);

}
