package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.api.FieldSetter;
import caccia.david.org.catalog_convert.api.SchemaParser;
import caccia.david.org.catalog_convert.data.BaseProduct;

public class StringSchemaParser implements SchemaParser<BaseProduct> {

    @Override
    public void configureEndpoint(BaseProduct baseProduct, String line) {

        try {
            for (FieldSetter<BaseProduct> field : Fields.values()) {
                field.setField(baseProduct, line);
            }
        }
        catch (Exception e)
        {
            // todo log that an unparsable line was encountered.
            baseProduct.setValid(false);
        }
    }
}
