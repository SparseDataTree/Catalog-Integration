package caccia.david.org.catalog_deserialize.api;

import java.util.LinkedList;
import java.util.List;

public class ExtractorBuilder<T> {

    private final ExtractorFactory<T> ef;
    List<Extractor<T>> extractors = new LinkedList<>();

    public ExtractorBuilder(ExtractorFactory<T> ef) {
        this.ef = ef;
    }

    public void addRow(String[] args)
    {
        extractors.add(ef.makeExtractor(args));
    }

    List<Extractor<T>> getExtractors()
    {
        return extractors;
    }
}
