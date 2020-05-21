package pl.uam.movieSelector.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uam.movieSelector.constants.WebConstants.Mapping;
import pl.uam.movieSelector.constants.WebConstants.Views;
import pl.uam.movieSelector.spring.repository.OMDBRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping(Mapping.ROOT)
public class MainPageController {


    @GetMapping
    public String get(final Model model) {
        return Views.MAIN_PAGE;
    }

}
