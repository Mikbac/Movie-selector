package pl.uam.movieSelector.spring.facade.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.UserQuestionData;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.converter.Converter;
import pl.uam.movieSelector.spring.facade.MainPageFacade;
import pl.uam.movieSelector.spring.service.FuzzyLogicService;
import pl.uam.movieSelector.spring.service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        return (ArrayList<UserQuestionData>) questionService.getAllQueries().stream()
                .map(q -> questionConverter.convert(q))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<String> predictMovie(final ArrayList<UserQuestionData> userQuestions) {
        return fuzzyLogicService.predictUserAnswers(userQuestions);
    }

}
