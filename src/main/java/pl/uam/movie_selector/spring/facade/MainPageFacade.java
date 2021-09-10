package pl.uam.movie_selector.spring.facade;

import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface MainPageFacade {

    ArrayList<UserQuestionData> getAllQueries();

    ArrayList<MovieData> predictMovie(ArrayList<UserQuestionData> questions, int topMoviesQuantity);

}
