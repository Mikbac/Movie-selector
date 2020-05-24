package pl.uam.movieSelector.spring.repository.impl;

import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Repository;
import pl.uam.movieSelector.exception.InvalidFclFileException;
import pl.uam.movieSelector.spring.repository.FuzzyLogicRepository;

import static pl.uam.movieSelector.constants.FuzzyLogicConstants.Files.fclFile;

@Repository
public class FuzzyLogicRepositoryImpl implements FuzzyLogicRepository {

    @Override
    public FIS getFIS() {
        return loadFclFile();
    }

    private FIS loadFclFile() {
        FIS fis = FIS.load(fclFile, true);
        if (fis == null) {
            throw new InvalidFclFileException(fclFile);
        }
        return fis;
    }

}
