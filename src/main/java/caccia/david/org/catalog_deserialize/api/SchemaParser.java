package caccia.david.org.catalog_deserialize.api;

public interface SchemaParser<T,V> {

    void configureEndpoint(V endpoint,T input);

}
