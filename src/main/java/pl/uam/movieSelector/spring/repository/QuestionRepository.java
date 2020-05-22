package pl.uam.movieSelector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.uam.movieSelector.model.QuestionModel;

import java.util.ArrayList;

public interface QuestionRepository extends CrudRepository<QuestionModel, String>, PagingAndSortingRepository<QuestionModel, String> {

    ArrayList<QuestionModel> findAll();

}
