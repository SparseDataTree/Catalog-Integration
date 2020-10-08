package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.api.Extractor;
import caccia.david.org.catalog_deserialize.schema.FieldTypes;

public class StringExtractor implements Extractor<String>
{
    private final FieldTypes fieldTypes;
    private final String name;
    private final int start;
    private final int end;

    public StringExtractor(FieldTypes fieldType, String name, int start, int end) {
        this.fieldTypes = fieldType;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public KeyValuePair extract(String s) {
        return new KeyValuePair(name, fieldTypes.parse(s.substring(start, end + 1)));
    }
}
