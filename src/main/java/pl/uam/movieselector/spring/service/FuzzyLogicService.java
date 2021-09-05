package pl.uam.movieselector.spring.service;

import pl.uam.movieselector.data.impl.MovieData;
import pl.uam.movieselector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 21.05.2020
 */

public interface FuzzyLogicService {

    ArrayList<MovieData> predictUserAnswers(ArrayList<UserQuestionData> userQuestions, long topMoviesQuantity);

}
