package pl.uam.movieselector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieselector.data.Data;

import java.util.List;

/**
 * Created by MikBac on 24.05.2020
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsData implements Data {

    private List<UserQuestionData> questions;

}
