package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.data.BaseProduct;
import caccia.david.org.catalog_convert.data.ProductReporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class SchemaParserApplication
{
    SchemaParserManager parserManager = new SchemaParserManager();

    private void convert(String filePath)
    {
        parserManager.clearProductList();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            parserManager.manageParsing(stream.iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        report(parserManager.getProducts());
    }

    private void report(List<BaseProduct> products)
    {
        System.out.println("");
        System.out.println("Report on product list:");
        System.out.println(String.format("   Number of product objects: %d",products.size()));
        if(products.size() > 0)
        {
            System.out.println("   IDs        Description                  Display-$       Calc-$        Promo-$       Promo-calc-$   Tax     Size       Unit");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        }
        ProductReporter reporter = new ProductReporter();
        for(BaseProduct product: products)
        {
            reporter.report(product);
        }
        System.out.println("");
    }

    public static void main(String args[])
    {
        if(args == null || args.length < 1)
        {
            printHelp();
            return;
        }
        String file = args[0];
        SchemaParserApplication app = new SchemaParserApplication();
        app.convert(file);
    }

    private static void printHelp()
    {
        System.out.println("Help for schema parser application:");
        System.out.println("   Arguments:");
        System.out.println("     file name");
        System.out.println("");
        System.out.println("Example usage:");
        System.out.println("scpar  <mylinestoparse.txt>: convert lines in mylinestoparse.txt to extended product java objects");
        System.out.println("");
        System.out.println("Output:  Number of valid objects converted; plus a list of their ids");
    }
}
