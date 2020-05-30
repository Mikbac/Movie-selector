package pl.uam.movieSelector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieSelector.data.Data;
import pl.uam.movieSelector.data.enums.AnswerEnum;

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
