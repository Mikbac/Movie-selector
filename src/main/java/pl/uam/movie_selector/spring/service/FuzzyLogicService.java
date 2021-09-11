package pl.uam.movie_selector.spring.service;

import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 21.05.2020
 */

public interface FuzzyLogicService {

    /**
     * Get the list of predicted movies.
     *
     * @param userAnswers       list of user responses.
     * @param topMoviesQuantity quantity of returned movies.
     * @return list of {@link MovieData}.
     */
    ArrayList<MovieData> predictUserAnswers(ArrayList<UserQuestionData> userAnswers, long topMoviesQuantity);

}
