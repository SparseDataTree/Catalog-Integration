package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.api.FieldSetter;
import caccia.david.org.catalog_convert.api.SchemaParser;
import caccia.david.org.catalog_convert.data.BaseProduct;

import java.util.logging.Logger;

public class StringSchemaParser implements SchemaParser<BaseProduct> {
    Logger logger = Logger.getLogger(StringSchemaParser.class.getName());

    @Override
    public void configureEndpoint(BaseProduct baseProduct, String line) {

        try {
            for (FieldSetter<BaseProduct> field : Fields.values()) {
                field.setField(baseProduct, line);
            }
        }
        catch (Exception e)
        {
            logger.info("Unparsable input: " + e.getMessage());
            baseProduct.setValid(false);
        }
    }
}
