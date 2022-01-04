package pl.uam.movie_selector.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static pl.uam.movie_selector.constants.EntityConstants.Model.PK;

/**
 * Created by MikBac on 22.05.2020
 */

@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PK)
    protected Long pk;

}