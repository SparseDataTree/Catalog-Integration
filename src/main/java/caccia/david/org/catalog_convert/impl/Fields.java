package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.api.FieldSetter;
import caccia.david.org.catalog_convert.data.BaseProduct;
import caccia.david.org.catalog_convert.data.Units;

public enum Fields implements FieldSetter<BaseProduct>
{
    ID(1,8)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    baseProduct.setId((Integer)FieldTypes.Number.parse(getExtractor().extract(value)));
                }
            },
    DESCRIPTION(10,68)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    baseProduct.setDescription((String)FieldTypes.Text.parse(getExtractor().extract(value)));
                }
            },
    REGULAR_PRICE(70,77)
            {
        @Override
        public void setField(BaseProduct baseProduct, String value)
        {
            String price = getExtractor().extract(value);
            if(price.equals(ZEROS_8))
            {
                return;
            }
            baseProduct.setDisplayPrice((String)FieldTypes.Currency.parse(price));
            Integer cents = (Integer)FieldTypes.Number.parse(price);
            baseProduct.setCalculatorPrice((1.0*cents)/100.0); // convert to dollars
        }
    },
    PROMO_PRICE(79,86)
            {
        @Override
        public void setField(BaseProduct baseProduct, String value)
        {
            String price = getExtractor().extract(value);
            if(price.equals(ZEROS_8))
            {
                return;
            }
            baseProduct.setDisplayPromoPrice((String)FieldTypes.Currency.parse(price));
            Integer cents = (Integer)FieldTypes.Number.parse(price);
            baseProduct.setCalculatorPromoPrice((1.0*cents)/100.0); // convert to dollars
        }
    },
    REGULAR_SPLIT(88,95)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    String price = getExtractor().extract(value);
                    if(price.equals(ZEROS_8))
                    {
                        return;
                    }
                    Integer cents = (Integer)FieldTypes.Number.parse(price);
                    Integer count = (Integer)FieldTypes.Number.parse(REGULAR_X.extractor.extract(value));
                    baseProduct.setDisplayPrice(String.format("%d for %s", count, FieldTypes.Currency.parse(price)));
                    double digits = Math.floor(100.0*cents/(1.0*count) + 0.5);
                    baseProduct.setCalculatorPrice(digits/10000.0); // round to the nearest 10,0000th.
                }
            },
    PROMO_SPLIT(97,104)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    String price = getExtractor().extract(value);
                    if(price.equals(ZEROS_8))
                    {
                        return;
                    }
                    Integer cents = (Integer)FieldTypes.Number.parse(price);
                    Integer count = (Integer)FieldTypes.Number.parse(PROMO_X.extractor.extract(value));
                    baseProduct.setDisplayPromoPrice(String.format("%d for %s", count, FieldTypes.Currency.parse(price)));
                    double digits = Math.floor(100.0*cents/(1.0*count) + 0.5);
                    baseProduct.setCalculatorPromoPrice(digits/10000.0); // round to the nearest 10,0000th.
                }
            },
    REGULAR_X(106,113)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    // noop for now
                }
            },
    PROMO_X(115,122)
            {
                @Override
                public void setField(BaseProduct baseProduct, String value)
                {
                    // noop for now
                }
            },
    FLAGS(124,132)
            {
        @Override
        public void setField(BaseProduct baseProduct, String value)
        {
            Boolean[] flags = (Boolean[]) FieldTypes.Flags.parse(getExtractor().extract(value));
            if(flags[2])
            {
                baseProduct.setUnit(Units.Pounds);
            }
            else
            {
                baseProduct.setUnit(Units.Each);
            }
            if(flags[4])
            {
                baseProduct.setTaxRate(7.775);
            }
            else
            {
                baseProduct.setTaxRate(0.0);
            }
        }
    },
    SIZE(134,142)
            {
        @Override
        public void setField(BaseProduct baseProduct, String value)
        {
            baseProduct.setSize((String) FieldTypes.Text.parse(getExtractor().extract(value)));
        }
    };

    static String ZEROS_8 = "00000000";
    private final StringExtractor extractor;

    Fields(int first, int last)
    {
        this.extractor = new StringExtractor(first, last);
    }

    public StringExtractor getExtractor()
    {
        return extractor;
    }
}
