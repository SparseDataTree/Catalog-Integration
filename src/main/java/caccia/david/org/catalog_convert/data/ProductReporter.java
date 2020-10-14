package caccia.david.org.catalog_convert.data;

import caccia.david.org.catalog_convert.api.Report;

public class ProductReporter implements Report<BaseProduct>
{
    String format = "%s%s%s%s%s%s%s%s%s";
    @Override
    public void report(BaseProduct product)
    {
        System.out.println(String.format(format,
                pass(Integer.toString(product.getId()),8),
                pass(product.getDescription(), 30),
                pass(product.getDisplayPrice(),14),
                pass(String.format("%.4f",product.getCalculatorPrice()),12),
                pass(product.getDisplayPromoPrice(),12), // optional
                pass( product.getCalculatorPromoPrice() == null ? null : String.format("%.4f",product.getCalculatorPromoPrice()), 12), // optional
                pass(product.getTaxRate(),6),
                pass(product.getSize(), 10),
                pass(product.getUnit().name(), 6)
        ));
    }

    private String pass(String obj, int size)
    {
        if(obj == null || obj.trim().length() == 0)
        {
            obj = "null";
        }
        String pad = " ";
        for(int i = 0; i < size - obj.length(); i++)
        {
            pad += " ";
        }
        return " " + obj + pad;
    }
}
