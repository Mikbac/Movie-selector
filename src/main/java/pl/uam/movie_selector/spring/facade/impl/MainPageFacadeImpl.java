package pl.uam.movie_selector.spring.facade.impl;

import org.springframework.stereotype.Service;
import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;
import pl.uam.movie_selector.model.QuestionModel;
import pl.uam.movie_selector.spring.converter.Converter;
import pl.uam.movie_selector.spring.facade.MainPageFacade;
import pl.uam.movie_selector.spring.service.FuzzyLogicService;
import pl.uam.movie_selector.spring.service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public ArrayList<UserQuestionData> getAllQueries() {
        return questionService.getAllQueries().stream()
                .map(q -> questionConverter.convert(q))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<MovieData> predictMovie(final ArrayList<UserQuestionData> userAnswers, final int topMoviesQuantity) {
        return fuzzyLogicService.predictUserAnswers(userAnswers, topMoviesQuantity);
    }

}
