package pl.uam.movieSelector.model;

import pl.uam.movieSelector.constants.EntityConstants;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by MikBac on 22.05.2020
 */

@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstants.Model.PK)
    protected Long pk;

}