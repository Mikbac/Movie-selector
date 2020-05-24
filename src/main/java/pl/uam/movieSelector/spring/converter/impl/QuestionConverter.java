package pl.uam.movieSelector.spring.converter.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.UserQuestionData;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.converter.Converter;

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
