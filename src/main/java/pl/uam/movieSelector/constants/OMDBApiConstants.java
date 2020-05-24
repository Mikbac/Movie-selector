package pl.uam.movieSelector.constants;

public interface OMDBApiConstants {

    interface ApiKey {
        String OMDB = "xxxxxxx";
    }

    interface ParametersOMDB {
        String ROOT = "http://www.omdbapi.com/?";
        String API_KEY = "apikey=" + ApiKey.OMDB;
        String MOVIE_ID = ROOT + API_KEY + "&i=";
        String MOVIE_TITLE = ROOT + API_KEY + "&t=";
    }

}
