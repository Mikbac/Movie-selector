package pl.uam.movieSelector.constants;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBApiConstants {

    interface ParametersOMDB {
        String ROOT = "http://www.omdbapi.com/?";
        String API_KEY = "apikey=";
        String MOVIE_ID = "&i=";
        String MOVIE_TITLE = "&t=";
    }

}
