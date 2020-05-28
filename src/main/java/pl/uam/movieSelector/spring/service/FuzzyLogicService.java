package pl.uam.movieSelector.spring.service;

import pl.uam.movieSelector.data.impl.UserQuestionData;

import java.util.ArrayList;

public interface FuzzyLogicService {

    ArrayList<String> predictUserAnswers(ArrayList<UserQuestionData> userQuestions);

}
