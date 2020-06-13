package pl.uam.movieSelector.spring.repository.impl;

import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import pl.uam.movieSelector.exception.InvalidFclFileException;
import pl.uam.movieSelector.spring.repository.FuzzyLogicRepository;

/**
 * Created by MikBac on 21.05.2020
 */

@Repository
public class FuzzyLogicRepositoryImpl implements FuzzyLogicRepository {

    @Value("${fuzzy.logic.controller.path}")
    private String fuzzyLogicController;

    @Override
    public FIS getFIS() {
        return loadFclFile();
    }

    private FIS loadFclFile() {

        FIS fis = FIS.load(fuzzyLogicController, true);
        try {
            if (fis == null) {
                throw new InvalidFclFileException(fuzzyLogicController);
            }
            return fis;
        } catch (InvalidFclFileException e) {
            return null;
        }

    }

}
