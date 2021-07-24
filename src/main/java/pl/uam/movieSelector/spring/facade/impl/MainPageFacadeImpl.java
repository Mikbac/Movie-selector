package pl.uam.movieSelector.spring.facade.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.MovieData;
import pl.uam.movieSelector.data.impl.UserQuestionData;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.converter.Converter;
import pl.uam.movieSelector.spring.facade.MainPageFacade;
import pl.uam.movieSelector.spring.service.FuzzyLogicService;
import pl.uam.movieSelector.spring.service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MikBac on 22.05.2020
 */

@Service
public class MainPageFacadeImpl implements MainPageFacade {

    @Resource
    private QuestionService questionService;

    @Resource
    private Converter<UserQuestionData, QuestionModel> questionConverter;

    @Resource
    private FuzzyLogicService fuzzyLogicService;

    @Override
    public List<UserQuestionData> getAllQueries() {
        return questionService.getAllQueries().stream()
                .map(q -> questionConverter.convert(q))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieData> predictMovie(final List<UserQuestionData> userQuestions, final int nTopMovies) {
        return fuzzyLogicService.predictUserAnswers((ArrayList<UserQuestionData>) userQuestions, nTopMovies);
    }

}
