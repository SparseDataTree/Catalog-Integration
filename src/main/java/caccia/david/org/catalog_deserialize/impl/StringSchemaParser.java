package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.api.SchemaParser;
import caccia.david.org.catalog_deserialize.data.BaseProduct;

public class StringSchemaParser implements SchemaParser<String, BaseProduct> {

    @Override
    public void configureEndpoint(BaseProduct baseProduct, String line) {

        try {
            for (Fields field : Fields.values()) {
                field.setField(baseProduct, line);
            }
        }
        catch (Exception e)
        {
            // todo log that an unparsable line was encountered.  But otherwise ignore, as this is allowed
        }
    }
}
