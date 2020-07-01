package pl.uam.movieSelector.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uam.movieSelector.constants.WebConstants.Mapping;
import pl.uam.movieSelector.constants.WebConstants.Views;
import pl.uam.movieSelector.data.impl.QuestionsData;
import pl.uam.movieSelector.spring.facade.MainPageFacade;

import javax.annotation.Resource;

import static pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.MainPage.QUESTIONS_LIST;
import static pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.MainPage.THE_BEST_MOVIES;
import static pl.uam.movieSelector.constants.WebConstants.Mapping.N_TOP_MOVIES;

/**
 * Created by MikBac on 21.05.2020
 */

@Controller
@RequestMapping(Mapping.ROOT)
public class MainPageController {

    @Resource
    private MainPageFacade mainPageFacade;

    @GetMapping
    public String get(final Model model) {
        populateCommonAttributes(model);

        return Views.MAIN_PAGE;
    }

    @PostMapping(N_TOP_MOVIES)
    public String getMovie(@ModelAttribute final QuestionsData questionsList, @PathVariable final int nTopMovies, final Model model) {
        populateCommonAttributes(model);
        model.addAttribute(THE_BEST_MOVIES, mainPageFacade.predictMovie(questionsList.getQuestions(), nTopMovies));

        return Views.MAIN_PAGE;
    }

    @PostMapping
    public String setLanguage(final Model model) {
        populateCommonAttributes(model);

        return Views.MAIN_PAGE;
    }

    private void populateCommonAttributes(final Model model) {
        model.addAttribute(QUESTIONS_LIST, new QuestionsData(mainPageFacade.getAllQueries()));
    }

}
