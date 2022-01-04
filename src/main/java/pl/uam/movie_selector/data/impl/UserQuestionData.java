package pl.uam.movie_selector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.uam.movie_selector.data.Data;
import pl.uam.movie_selector.data.enums.AnswerEnum;

/**
 * Created by MikBac on 22.05.2020
 */

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuestionData implements Data {

    private Long pk;
    private String description;
    private AnswerEnum userAnswer;
    private Double realUserAnswerValue;

}
