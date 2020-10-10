package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.api.Extractor;

public class StringExtractor implements Extractor<String>
{
    private final int start;
    private final int end;

    public StringExtractor(int start, int end) {
        this.start = start - 1;
        this.end = end - 1; // we could simplify the arithmetic, but this is more readable
    }

    @Override
    public String extract(String s) {
        return s.substring(start, end + 1);
    }
}
