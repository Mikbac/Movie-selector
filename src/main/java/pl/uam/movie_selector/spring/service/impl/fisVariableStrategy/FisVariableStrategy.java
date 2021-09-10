package pl.uam.movie_selector.spring.service.impl.fisVariableStrategy;

import net.sourceforge.jFuzzyLogic.FIS;
import pl.uam.movie_selector.model.MovieModel;
import pl.uam.movie_selector.model.QuestionModel;

/**
 * Created by MikBac on 30.06.2020
 */

public interface FisVariableStrategy {

    void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie);

}
