package pl.uam.movie_selector.spring.repository.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.uam.movie_selector.exception.InvalidApiAddressException;
import pl.uam.movie_selector.model.OMDBMovieModel;
import pl.uam.movie_selector.spring.property.OmdbProperties;
import pl.uam.movie_selector.spring.repository.OMDBRepository;

import javax.annotation.Resource;
import java.util.Optional;

import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.API_KEY;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.MOVIE_ID;
import static pl.uam.movie_selector.constants.OMDBApiConstants.ParametersOMDB.Name.MOVIE_TITLE;

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
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add(API_KEY, getOMDBApiKey());
        queryParams.add(MOVIE_TITLE, title);
        return getMovie(getApiUrl(queryParams));
    }

    @Override
    public Optional<OMDBMovieModel> getMovieById(final String id) {
        log.info("Get movie: {} from IMDB by id", () -> id);
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add(API_KEY, getOMDBApiKey());
        queryParams.add(MOVIE_ID, id);
        return getMovie(getApiUrl(queryParams));
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

    private String getApiUrl(final MultiValueMap<String, String> queryParams) {
        return UriComponentsBuilder
                .fromUriString(getOMDBApiUrl())
                .queryParams(queryParams)
                .build()
                .toUriString();
    }

    private String getOMDBApiUrl() {
        return omdbProperties.getUrl();
    }

    private String getOMDBApiKey() {
        return omdbProperties.getKey();
    }

}
