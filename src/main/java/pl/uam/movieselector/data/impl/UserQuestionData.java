package pl.uam.movieselector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieselector.data.Data;
import pl.uam.movieselector.data.enums.AnswerEnum;

/**
 * Created by MikBac on 22.05.2020
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserQuestionData implements Data {

    private Long pk;
    private String description;
    private AnswerEnum userAnswer;
    private Double realUserAnswerValue;

}
