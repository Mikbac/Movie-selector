package pl.uam.movieselector.constants;

/**
 * Created by MikBac on 21.05.2020
 */

public interface WebConstants {

    interface Mapping {
        String ROOT = "/";
        String PREDICT = "/predict";
        String N_TOP_MOVIES = PREDICT + "/{nTopMovies}";
    }

    interface Views {
        String MAIN_PAGE = "mainPage";
    }

}
