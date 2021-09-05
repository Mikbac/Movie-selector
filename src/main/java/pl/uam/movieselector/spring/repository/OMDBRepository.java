package pl.uam.movieselector.spring.repository;

import pl.uam.movieselector.model.OMDBMovieModel;

import java.util.Optional;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBRepository {

    Optional<OMDBMovieModel> getMovieByTitle(final String title);

    Optional<OMDBMovieModel> getMovieById(final String id);

}
