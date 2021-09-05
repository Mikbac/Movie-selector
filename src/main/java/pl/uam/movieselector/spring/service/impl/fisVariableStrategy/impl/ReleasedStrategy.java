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
public class ReleasedStrategy implements FisVariableStrategy {

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie) {
        String date = omdbMovieRepository.findByImdbID(movie.getId())
                .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                .getReleased();
        final int movieRelease = Integer.parseInt(date.substring(date.length() - 4));
        fis.setVariable(question.getVariableName(), movieRelease);
        log.info("Movie: {},  Release variable: {}", movie.getName(), movieRelease);
    }

}
