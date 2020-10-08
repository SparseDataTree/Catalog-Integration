package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.api.Extractor;
import caccia.david.org.catalog_deserialize.api.ExtractorFactory;
import caccia.david.org.catalog_deserialize.schema.Columns;
import caccia.david.org.catalog_deserialize.schema.FieldTypes;

public class StringExtractorFactory implements ExtractorFactory<String> {

    @Override
    public Extractor<String> makeExtractor(String[] args) {
        Integer start = (Integer) Columns.Start.parse(args[0]);
        Integer end = (Integer) Columns.End.parse(args[1]);
        String name = (String) Columns.Name.parse(args[2]);
        FieldTypes type = (FieldTypes) Columns.Type.parse(args[3]);
        return new StringExtractor(type, name, start, end);
    }
}
