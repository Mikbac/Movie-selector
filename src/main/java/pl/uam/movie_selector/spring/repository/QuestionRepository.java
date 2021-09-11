package pl.uam.movie_selector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.uam.movie_selector.model.QuestionModel;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface QuestionRepository extends CrudRepository<QuestionModel, String>, PagingAndSortingRepository<QuestionModel, String> {

    /**
     * Get the list of all questions.
     *
     * @return list of all questions {@link QuestionModel}.
     */
    ArrayList<QuestionModel> findAll();

}
