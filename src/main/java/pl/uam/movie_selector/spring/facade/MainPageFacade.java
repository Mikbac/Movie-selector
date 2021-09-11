package pl.uam.movie_selector.spring.facade;

import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface MainPageFacade {

    /**
     * Get the list of all queries.
     *
     * @return list of all queries for user {@link UserQuestionData}.
     */
    ArrayList<UserQuestionData> getAllQueries();

    /**
     * Get the list of predicted movies.
     *
     * @param userAnswers       list of user responses.
     * @param topMoviesQuantity quantity of returned movies.
     * @return list of {@link MovieData}.
     */
    ArrayList<MovieData> predictMovie(ArrayList<UserQuestionData> userAnswers, int topMoviesQuantity);

}
