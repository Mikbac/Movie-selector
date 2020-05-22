package pl.uam.movieSelector.data.impl;

import lombok.Builder;
import pl.uam.movieSelector.data.Data;
import pl.uam.movieSelector.model.enums.AnswerEnum;

@Builder
@lombok.Data
public class QuestionData implements Data {

    private Long pk;
    private String question;
    private AnswerEnum userAnswerEnum;

}
