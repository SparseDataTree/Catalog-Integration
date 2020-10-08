package caccia.david.org.catalog_deserialize.api;

import caccia.david.org.catalog_deserialize.impl.KeyValuePair;

public interface Extractor<T> {
    KeyValuePair extract(T t);
}
