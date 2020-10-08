package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.api.Extractor;
import caccia.david.org.catalog_deserialize.api.SchemaParser;
import caccia.david.org.catalog_deserialize.data.BaseProduct;

import java.util.LinkedList;
import java.util.List;

public class StringSchemaParser implements SchemaParser<String, BaseProduct> {

    List<Extractor<String>> extractorList;

    @Override
    public BaseProduct makeEndpoint(String input) {
        List<KeyValuePair> keyValuePairs = new LinkedList<>();
        for (Extractor<String> extractor: extractorList)
        {
            keyValuePairs.add( extractor.extract(input));
        }
        BaseProduct baseProduct = new BaseProduct();
        for(KeyValuePair keyValuePair: keyValuePairs) // todo this does not appear to be exactly right... see specs on weight and tax, deriving from flags
        {
            FieldNames.valueOf(keyValuePair.getKey()).setField(baseProduct, keyValuePair.getValue());
        }

        return baseProduct;
    }
}
