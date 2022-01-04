package pl.uam.movie_selector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.uam.movie_selector.data.Data;

import java.util.ArrayList;

/**
 * Created by MikBac on 24.05.2020
 */

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsData implements Data {

    private ArrayList<UserQuestionData> questions;

}
