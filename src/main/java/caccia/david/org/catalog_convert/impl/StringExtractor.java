package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.api.Extractor;

public class StringExtractor implements Extractor<String>
{
    private final int start;
    private final int end;

    public StringExtractor(int start, int end) {
        // convert from 1-based indexing to 0-based indexing
        this.start = start - 1;
        this.end = end - 1; // we could simplify the arithmetic, but this is more readable
    }

    @Override
    public String extract(String s) {
        return s.substring(start, end + 1); // end inclusive
    }
}
