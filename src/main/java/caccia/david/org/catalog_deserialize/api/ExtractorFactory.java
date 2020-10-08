package caccia.david.org.catalog_deserialize.api;

public interface ExtractorFactory<T> {

    Extractor<T> makeExtractor(String[] args);
}
