package pl.uam.movieSelector.spring.converter;

import pl.uam.movieSelector.data.Data;
import pl.uam.movieSelector.model.Model;

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);
}
