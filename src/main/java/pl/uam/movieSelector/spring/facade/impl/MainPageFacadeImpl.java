package pl.uam.movieSelector.spring.facade.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.QuestionData;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.converter.Converter;
import pl.uam.movieSelector.spring.facade.MainPageFacade;
import pl.uam.movieSelector.spring.service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class MainPageFacadeImpl implements MainPageFacade {

    @Resource
    private QuestionService questionService;

    @Resource
    private Converter<QuestionData, QuestionModel> questionConverter;

    @Override
    public ArrayList<QuestionData> getAllQueries() {

        return (ArrayList<QuestionData>) questionService.getAllQueries().stream()
                .map(q -> questionConverter.convert(q))
                .collect(Collectors.toList());

    }

    @Override
    public String predictMovie(final ArrayList<QuestionData> questions) {
        //TODO logika fuzzy logic
        return null;
    }

}
