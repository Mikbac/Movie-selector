package pl.uam.movie_selector.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.uam.movie_selector.exception.InvalidApiAddressException;
import pl.uam.movie_selector.model.OMDBMovieModel;
import pl.uam.movie_selector.spring.property.OmdbProperties;
import pl.uam.movie_selector.spring.repository.OMDBRepository;

import javax.annotation.Resource;
import java.util.Optional;

import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.AND;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.API_KEY;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.MOVIE_ID;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.MOVIE_TITLE;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.PARAMS_PREFIX;

/**
 * Created by MikBac on 21.05.2020
 */

@Log4j2
@Repository
public class OMDBRepositoryImpl implements OMDBRepository {

    @Resource
    private OmdbProperties omdbProperties;

    @Override
    public Optional<OMDBMovieModel> getMovieByTitle(final String title) {
        log.info("Get movie: {} from IMDB by title", () -> title);
        return getMovie(getOMDBApiUrl() + PARAMS_PREFIX + API_KEY + getOMDBApiKey() + AND + MOVIE_TITLE + title);
    }

    @Override
    public Optional<OMDBMovieModel> getMovieById(final String id) {
        log.info("Get movie: {} from IMDB by id", () -> id);
        return getMovie(getOMDBApiUrl() + PARAMS_PREFIX + API_KEY + getOMDBApiKey() + AND + MOVIE_ID + id);
    }

    private Optional<OMDBMovieModel> getMovie(final String url) {
        try {
            final var restTemplate = new RestTemplate();
            OMDBMovieModel omdbMovieModel = restTemplate.getForObject(url, OMDBMovieModel.class);
            return Optional.ofNullable(omdbMovieModel);
        } catch (HttpClientErrorException e) {
            log.error("Invalid API address for url: {}", () -> url);
            throw new InvalidApiAddressException(url);
        }
    }

    private String getOMDBApiUrl() {
        return omdbProperties.getUrl();
    }

    private String getOMDBApiKey() {
        return omdbProperties.getKey();
    }

}
