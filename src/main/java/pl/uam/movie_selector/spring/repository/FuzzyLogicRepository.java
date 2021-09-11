package pl.uam.movie_selector.spring.repository;

import net.sourceforge.jFuzzyLogic.FIS;

/**
 * Created by MikBac on 21.05.2020
 */

public interface FuzzyLogicRepository {

    /**
     * Get fuzzy logic controller.
     *
     * @return fuzzy logic controller {@link FIS}.
     */
    FIS getFIS();

}
