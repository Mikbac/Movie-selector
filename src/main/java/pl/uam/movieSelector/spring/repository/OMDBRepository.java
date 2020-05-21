package pl.uam.movieSelector.spring.repository;

import pl.uam.movieSelector.model.OMDBMovieModel;

import java.util.Optional;

public interface OMDBRepository {

    Optional<OMDBMovieModel> getMovieByTitle(final String title);

    Optional<OMDBMovieModel> getMovieById(final String id);

}
