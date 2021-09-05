package pl.uam.movieselector.spring.service.impl.fisVariableStrategy.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
import pl.uam.movieselector.exception.InvalidMovieException;
import pl.uam.movieselector.model.MovieModel;
import pl.uam.movieselector.model.QuestionModel;
import pl.uam.movieselector.spring.repository.OMDBMovieRepository;
import pl.uam.movieselector.spring.service.impl.fisVariableStrategy.FisVariableStrategy;

import javax.annotation.Resource;

/**
 * Created by MikBac on 30.06.2020
 */

@Log4j2
@Service
public class QuantityCountriesStrategy implements FisVariableStrategy {

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie) {
        try {
            final int movieQuantityCountries = omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getCountry().split(",").length;
            fis.setVariable(question.getVariableName(), movieQuantityCountries);
            log.info("Movie: {},  Quantity countries variable: {}", movie.getName(), movieQuantityCountries);
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), 0);
            log.info("Movie: {},  Quantity countries variable: {}", movie.getName(), 0);
        }
    }

}
