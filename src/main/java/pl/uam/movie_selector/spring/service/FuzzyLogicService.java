package pl.uam.movie_selector.spring.service;

import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 21.05.2020
 */

public interface FuzzyLogicService {

    ArrayList<MovieData> predictUserAnswers(ArrayList<UserQuestionData> userQuestions, long topMoviesQuantity);

}
