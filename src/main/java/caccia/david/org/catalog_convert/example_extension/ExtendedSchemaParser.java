package caccia.david.org.catalog_convert.example_extension;

import caccia.david.org.catalog_convert.api.FieldSetter;
import caccia.david.org.catalog_convert.api.SchemaParser;
import caccia.david.org.catalog_convert.impl.StringSchemaParser;

public class ExtendedSchemaParser implements SchemaParser<ExtendedProduct>
{
    StringSchemaParser parent = new StringSchemaParser();
    @Override
    public void configureEndpoint(ExtendedProduct extendedProduct, String line)
    {
        parent.configureEndpoint(extendedProduct, line);
        if(extendedProduct.isValid()) {
            try {
                for (FieldSetter<ExtendedProduct> field : ExtendedFields.values()) {
                    field.setField(extendedProduct, line);
                }
            } catch (Exception e) {
                // todo log that an unparsable line was encountered.
                extendedProduct.setValid(false);
            }
        }
    }


}
