package pl.uam.movieSelector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieSelector.constants.EntityConstants;
import pl.uam.movieSelector.constants.EntityConstants.Question;
import pl.uam.movieSelector.model.enums.AnswerEnum;

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
    @Column(name = Question.USER_ANSWER)
    private AnswerEnum userAnswerEnum;

}
