package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.data.BaseProduct;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SchemaParserManager
{
    StringSchemaParser schemaParser = new StringSchemaParser();
    private final List<BaseProduct> products = new LinkedList<>();

    public void manageParsing(Iterator<String> lineStream )
    {
        while (lineStream.hasNext())
        {
            String line = lineStream.next();
            BaseProduct product = new BaseProduct();
            schemaParser.configureEndpoint(product, line);
            if(product.isValid())
            {
                products.add(product);
            }
        }
    }

    public List<BaseProduct> getProducts()
    {
        return products;
    }

    public void clearProductList()
    {
        products.clear();
    }
}
