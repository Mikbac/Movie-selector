package pl.uam.movieSelector.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uam.movieSelector.constants.WebConstants.Mapping;
import pl.uam.movieSelector.constants.WebConstants.Views;
import pl.uam.movieSelector.spring.facade.MainPageFacade;

import javax.annotation.Resource;

import static pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.MainPage.QUESTIONS;

@Controller
@RequestMapping(Mapping.ROOT)
public class MainPageController {

    @Resource
    private MainPageFacade mainPageFacade;

    @GetMapping
    public String get(final Model model) {

        model.addAttribute(QUESTIONS, mainPageFacade.getAllQueries());

        return Views.MAIN_PAGE;
    }

}
