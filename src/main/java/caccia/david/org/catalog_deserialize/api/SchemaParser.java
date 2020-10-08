package caccia.david.org.catalog_deserialize.api;

import java.util.List;

public interface SchemaParser<T,V> {

//    List<Extractor<T>> extractorList;

    V makeEndpoint(T input);





}
