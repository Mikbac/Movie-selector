package pl.uam.movieSelector.spring.service.impl.fisVariableStrategy;

import net.sourceforge.jFuzzyLogic.FIS;
import pl.uam.movieSelector.model.MovieModel;
import pl.uam.movieSelector.model.QuestionModel;

/**
 * Created by MikBac on 30.06.2020
 */

public interface FisVariableStrategy {

    void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie);

}
