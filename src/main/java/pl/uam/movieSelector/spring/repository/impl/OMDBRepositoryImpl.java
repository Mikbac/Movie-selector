package pl.uam.movieSelector.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.uam.movieSelector.exception.InvalidApiAddressException;
import pl.uam.movieSelector.model.OMDBMovieModel;
import pl.uam.movieSelector.spring.repository.OMDBRepository;

import java.util.Optional;

import static pl.uam.movieSelector.constants.OMDBApiConstants.ParametersOMDB.MOVIE_ID;
import static pl.uam.movieSelector.constants.OMDBApiConstants.ParametersOMDB.MOVIE_TITLE;

/**
 * Created by MikBac on 21.05.2020
 */

@Log4j2
@Repository
public class OMDBRepositoryImpl implements OMDBRepository {

    @Override
    public Optional<OMDBMovieModel> getMovieByTitle(final String title) {
        log.info("Get movie: {} from IMDB by title", () -> title);
        return getMovie(MOVIE_TITLE + title);
    }

    @Override
    public Optional<OMDBMovieModel> getMovieById(final String id) {
        log.info("Get movie: {} from IMDB by id", () -> id);
        return getMovie(MOVIE_ID + id);
    }

    private Optional<OMDBMovieModel> getMovie(final String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            OMDBMovieModel omdbMovieModel = restTemplate.getForObject(url, OMDBMovieModel.class);
            return Optional.ofNullable(omdbMovieModel);
        } catch (HttpClientErrorException e) {
            log.error("Invalid API address for url: {}", () -> url);
            throw new InvalidApiAddressException(url);
        }
    }

}
