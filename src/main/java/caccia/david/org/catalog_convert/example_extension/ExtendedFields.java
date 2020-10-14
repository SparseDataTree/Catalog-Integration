package caccia.david.org.catalog_convert.example_extension;

import caccia.david.org.catalog_convert.api.FieldSetter;
import caccia.david.org.catalog_convert.impl.FieldTypes;
import caccia.david.org.catalog_convert.impl.StringExtractor;

import java.util.Date;

public enum ExtendedFields implements FieldSetter<ExtendedProduct>
{
    LOCATION(144,163)
            {
                @Override
                public void setField(ExtendedProduct extendedProduct, String value)
                {
                    extendedProduct.setLocation((String)FieldTypes.Text.parse(getExtractor().extract(value)));
                }
            },
    START(165,174)
            {
                @Override
                public void setField(ExtendedProduct extendedProduct, String value)
                {
                    extendedProduct.setStart((Date)ExtendedFieldTypes.ProductDate.parse(getExtractor().extract(value)));
                }
            },
    END(176,185)
            {
                @Override
                public void setField(ExtendedProduct extendedProduct, String value)
                {
                    extendedProduct.setEnd((Date)ExtendedFieldTypes.ProductDate.parse(getExtractor().extract(value)));
                }
            };

    private final StringExtractor extractor;

    ExtendedFields(int first, int last)
    {
        this.extractor = new StringExtractor(first, last);
    }

    public StringExtractor getExtractor()
    {
        return extractor;
    }
}
