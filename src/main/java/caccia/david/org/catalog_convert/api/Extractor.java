package caccia.david.org.catalog_convert.api;

public interface Extractor<T> {
    String extract(T t);
}
