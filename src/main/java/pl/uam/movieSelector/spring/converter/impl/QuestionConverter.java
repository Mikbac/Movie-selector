package pl.uam.movieSelector.spring.converter.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.QuestionData;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.converter.Converter;

@Service
public class QuestionConverter implements Converter<QuestionData, QuestionModel> {

    @Override
    public QuestionData convert(final QuestionModel model) {
        return QuestionData.builder()
                .question(model.getQuestion())
                .userAnswerEnum(model.getUserAnswerEnum())
                .build();
    }

    @Override
    public QuestionModel inverseConvert(final QuestionData data) {
        return QuestionModel.builder()
                .question(data.getQuestion())
                .userAnswerEnum(data.getUserAnswerEnum())
                .build();
    }
}
