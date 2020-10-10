package caccia.david.org.catalog_deserialize.api;

public interface Extractor<T> {
    String extract(T t);
}
