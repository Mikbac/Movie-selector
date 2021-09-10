package pl.uam.movie_selector.spring.repository.impl;

import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Repository;
import pl.uam.movie_selector.exception.InvalidFclFileException;
import pl.uam.movie_selector.spring.property.FuzzyLogicProperties;
import pl.uam.movie_selector.spring.repository.FuzzyLogicRepository;

import javax.annotation.Resource;

/**
 * Created by MikBac on 21.05.2020
 */

@Repository
public class FuzzyLogicRepositoryImpl implements FuzzyLogicRepository {

    @Resource
    private FuzzyLogicProperties fuzzyLogicProperties;

    @Override
    public FIS getFIS() {
        return loadFclFile();
    }

    private FIS loadFclFile() {

        final var fis = FIS.load(getFuzzyLogicControllerPath(), true);
        try {
            if (fis == null) {
                throw new InvalidFclFileException(getFuzzyLogicControllerPath());
            }
            return fis;
        } catch (InvalidFclFileException e) {
            return null;
        }

    }

    private String getFuzzyLogicControllerPath() {
        return fuzzyLogicProperties.getPath();
    }

}
