package caccia.david.org.catalog_convert.example_extension;

import caccia.david.org.catalog_convert.data.BaseProduct;
import caccia.david.org.catalog_convert.impl.StringSchemaParser;
import org.testng.annotations.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.testng.Assert.*;

public class ExtendedSchemaParserTest
{
    static final String VALID_LINE = "80000001 Kimchi-flavored white rice                                  00000567 00000000 00000000 00000000 00000000 00000000 NNNNNNNNN      18oz usa-wa-sea-*         2020-10-11 2020-10-18";

    @Test
    public void testConfigureEndpoint()
    {
        ExtendedSchemaParser parser = new ExtendedSchemaParser();
        ExtendedProduct extendedProduct = new ExtendedProduct();
        parser.configureEndpoint(extendedProduct, VALID_LINE);
        assertSoftly(softly ->
        {
            // confirm that base product fields are still properly set.
            softly.assertThat(extendedProduct.isValid()).withFailMessage("validate").isTrue();
            softly.assertThat(extendedProduct.getId()).withFailMessage("ID").isEqualTo(80000001);
            softly.assertThat(extendedProduct.getDescription()).withFailMessage("Description").isEqualTo("Kimchi-flavored white rice");
            softly.assertThat(extendedProduct.getDisplayPrice()).withFailMessage("Display price").isEqualTo("$5.67");
            softly.assertThat(extendedProduct.getCalculatorPrice()).withFailMessage("Calculator price").isEqualTo(5.67);
            softly.assertThat(extendedProduct.getTaxRate()).withFailMessage("Tax rate").isEqualTo("0.000%");
            softly.assertThat(extendedProduct.getTaxFactor()).withFailMessage("Tax factor").isEqualTo(1.0);
            softly.assertThat(extendedProduct.getSize()).withFailMessage("Size").isEqualTo("18oz");
            // everything else in base product is null
            softly.assertThat(extendedProduct.getDisplayPromoPrice()).isNull();
            softly.assertThat(extendedProduct.getCalculatorPromoPrice()).isNull();
            // confirm that extended fields are properly set
            softly.assertThat(extendedProduct.getLocation()).withFailMessage("Location").isEqualTo("usa-wa-sea-*");
            softly.assertThat(extendedProduct.getStart().toString()).withFailMessage("Start").contains("Sun Oct 11 00:00:00");
            softly.assertThat(extendedProduct.getEnd().toString()).withFailMessage("End").contains("Sun Oct 18 00:00:00");
        });
    }
}