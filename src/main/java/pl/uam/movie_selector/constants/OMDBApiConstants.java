package pl.uam.movie_selector.constants;

/**
 * Created by MikBac on 21.05.2020
 */

public interface OMDBApiConstants {

    interface ParametersOMDB {
        String PARAMS_PREFIX = "/?";
        String AND = "&";
        String EQUAL = "=";

        interface Name {
            String API_KEY = "apikey" + EQUAL;
            String MOVIE_ID = "i" + EQUAL;
            String MOVIE_TITLE = "t" + EQUAL;
        }
    }

}
