package pl.uam.movieSelector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieSelector.constants.EntityConstants;
import pl.uam.movieSelector.constants.EntityConstants.Question;
import pl.uam.movieSelector.model.enums.BaseVariableEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Question.TABLE)
public class QuestionModel extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = EntityConstants.Question.PK)
    private Long pk;

    @Column(name = Question.DESCRIPTION)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = Question.BASE_MOVIE_VARIABLE)
    private BaseVariableEnum baseVariable;

    @Column(name = Question.VARIABLE_NAME)
    private String variableName;

    @Column(name = Question.START_VARIABLE)
    private Double startVariable;

    @Column(name = Question.END_VARIABLE)
    private Double endVariable;

    @Column(name = Question.GOOD_VALUE_RANGE)
    private Double goodValueRange;

}
