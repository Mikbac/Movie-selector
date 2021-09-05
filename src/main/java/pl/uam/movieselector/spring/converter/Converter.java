package pl.uam.movieselector.spring.converter;

import pl.uam.movieselector.data.Data;
import pl.uam.movieselector.model.Model;

/**
 * Created by MikBac on 22.05.2020
 */

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);
}
