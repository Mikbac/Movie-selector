package pl.uam.movie_selector.spring.converter;

import pl.uam.movie_selector.data.Data;
import pl.uam.movie_selector.model.Model;

/**
 * Created by MikBac on 22.05.2020
 */

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);
}
