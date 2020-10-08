package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.data.BaseProduct;
import caccia.david.org.catalog_deserialize.data.Units;

public enum FieldNames implements FieldSetter<BaseProduct> {

    ID("Product ID")
            {
                @Override
                public void setField(BaseProduct baseProduct, Object value) {
                    baseProduct.setId((Integer)value);
                }
            },
    DESCRIPTION("Product Description")
            {
                @Override
                public void setField(BaseProduct baseProduct, Object value) {
                    baseProduct.setDescription((String)value);
                }
            },
    REGULAR_DISPLAY_PRICE("Regular Display Price") { // todo combine display and calc enums  into one, that sets both fields.
        @Override
        public void setField(BaseProduct baseProduct, Object value) { // todo consider if we want to do the conversion here
            baseProduct.setDisplayPrice((String)value);
        }
    },
    REGULAR_CALCULATOR_PRICE("Regular Calculator Price") {
        @Override
        public void setField(BaseProduct baseProduct, Object value) {
            baseProduct.setCalculatorPrice((Double)value);
        }
    },
    PROMO_DISPLAY_PRICE("Promotional Display Price") { // todo combine display and calc enums  into one, that sets both fields.
        @Override
        public void setField(BaseProduct baseProduct, Object value) {
            baseProduct.setDisplayPromoPrice((String)value);
        }
    },
    PROMO_CALCULATOR_PRICE("Promotional Calculator Price") {
        @Override
        public void setField(BaseProduct baseProduct, Object value) {
            baseProduct.setCalculatorPromoPrice((Double)value);
        }
    },
    FLAGS("Unit, Tax") {
        @Override
        public void setField(BaseProduct baseProduct, Object value) {
            Boolean[] flags = (Boolean[]) value;
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
                baseProduct.setTaxRate(0.07775);
            }
            else
            {
                baseProduct.setTaxRate(0.0);
            }

        }
    },
    SIZE("Product size") {
        @Override
        public void setField(BaseProduct baseProduct, Object value) {
            baseProduct.setSize((Double)value);
        }
    };


    private final String name;

    FieldNames(String name) {
        this.name = name;
    }
}
