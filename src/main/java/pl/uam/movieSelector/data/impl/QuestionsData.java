package pl.uam.movieSelector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieSelector.data.Data;

import java.util.ArrayList;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsData implements Data {

    private ArrayList<UserQuestionData> questions;

}
