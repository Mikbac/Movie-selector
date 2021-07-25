package pl.uam.movieSelector.spring.service;

import pl.uam.movieSelector.data.impl.MovieData;
import pl.uam.movieSelector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 21.05.2020
 */

public interface FuzzyLogicService {

    ArrayList<MovieData> predictUserAnswers(ArrayList<UserQuestionData> userQuestions, long topMoviesQuantity);

}
