package pl.uam.movie_selector.spring.service;

/**
 * Created by MikBac on 25.05.2020
 */

public interface OMDBMovieService {

    /**
     * Download movie details from the OMDB API.
     */
    void downloadOMDBMovies();

}
