package pl.uam.movie_selector.spring.converter.impl;

import org.springframework.stereotype.Service;
import pl.uam.movie_selector.data.impl.UserQuestionData;
import pl.uam.movie_selector.model.QuestionModel;
import pl.uam.movie_selector.spring.converter.Converter;

/**
 * Created by MikBac on 22.05.2020
 */

@Service
public class QuestionConverter implements Converter<UserQuestionData, QuestionModel> {

    @Override
    public UserQuestionData convert(final QuestionModel model) {
        return UserQuestionData.builder()
                .pk(model.getPk())
                .description(model.getDescription())
                .build();
    }

    @Override
    public QuestionModel inverseConvert(final UserQuestionData data) {
        return QuestionModel.builder()
                .description(data.getDescription())
                .build();
    }
}
