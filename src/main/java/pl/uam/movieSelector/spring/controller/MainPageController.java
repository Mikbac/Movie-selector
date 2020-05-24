package pl.uam.movieSelector.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uam.movieSelector.constants.WebConstants.Mapping;
import pl.uam.movieSelector.constants.WebConstants.Views;
import pl.uam.movieSelector.data.impl.QuestionsData;
import pl.uam.movieSelector.spring.facade.MainPageFacade;

import javax.annotation.Resource;

import static pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.MainPage.QUESTIONS_LIST;
import static pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.MainPage.THE_BEST_MOVIE;

@Controller
@RequestMapping(Mapping.ROOT)
public class MainPageController {

    @Resource
    private MainPageFacade mainPageFacade;

    @GetMapping
    public String get(final Model model) {
        model.addAttribute(QUESTIONS_LIST, new QuestionsData(mainPageFacade.getAllQueries()));

        return Views.MAIN_PAGE;
    }

    @PostMapping("/predict")
    public String getMovie(@ModelAttribute final QuestionsData questionsList, final Model model) {
        model.addAttribute(QUESTIONS_LIST, questionsList);
        model.addAttribute(THE_BEST_MOVIE, mainPageFacade.predictMovie(questionsList.getQuestions()));

        return Views.MAIN_PAGE;
    }

}
