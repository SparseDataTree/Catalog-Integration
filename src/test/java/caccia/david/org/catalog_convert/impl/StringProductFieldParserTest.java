package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.data.BaseProduct;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;


public class StringProductFieldParserTest
{
    static final String VALID_LINE_1 = "80000001 Kimchi-flavored white rice                                  00000567 00000000 00000000 00000000 00000000 00000000 NNNNNNNNN      18oz";
    static final String VALID_LINE_2 = "14963801 Generic Soda 12-pack                                        00000000 00000549 00001300 00000000 00000002 00000000 NNNNYNNNN   12x12oz";
    static final String VALID_LINE_3 = "40123401 Marlboro Cigarettes                                         00001000 00000549 00000000 00000000 00000000 00000000 YNNNNNNNN          ";
    static final String VALID_LINE_4 = "50133333 Fuji Apples (Organic)                                       00000349 00000000 00000000 00000000 00000000 00000000 NNYNNNNNN        lb";
    String invalidLine = "# comment line";

    @DataProvider
    public static Object[][] validLines()
    {
        return new Object[][]
                {
                        {
                            VALID_LINE_1
                        },
                        {
                            VALID_LINE_2
                        },
                        {
                            VALID_LINE_3
                        },
                        {
                            VALID_LINE_4
                        }
                };

    }

    @Test(dataProvider = "validLines")
    public void testValid(String line)
    {
        StringProductFieldParser parser = new StringProductFieldParser();
        BaseProduct baseProduct = new BaseProduct();
        parser.configureEndpoint(baseProduct, line);
        assertThat(baseProduct.isValid()).isTrue();
        // todo consider more asserts
    }


    @Test
    public void testConfigureEndpoint()
    {
        StringProductFieldParser parser = new StringProductFieldParser();
        BaseProduct baseProduct = new BaseProduct();
        parser.configureEndpoint(baseProduct, VALID_LINE_1);
        assertSoftly(softly ->
        {
           softly.assertThat(baseProduct.isValid()).isTrue();
           softly.assertThat(baseProduct.getId()).isEqualTo(80000001);
           softly.assertThat(baseProduct.getDescription()).isEqualTo("Kimchi-flavored white rice");
           softly.assertThat(baseProduct.getDisplayPrice()).isEqualTo("$5.67");
           softly.assertThat(baseProduct.getCalculatorPrice()).isEqualTo(5.67);
           softly.assertThat(baseProduct.getTaxRate()).isEqualTo("0.000%");
           softly.assertThat(baseProduct.getTaxFactor()).isEqualTo(1.0);
            softly.assertThat(baseProduct.getSize()).isEqualTo("18oz");
           // everything else is null
            softly.assertThat(baseProduct.getDisplayPromoPrice()).isNull();
            softly.assertThat(baseProduct.getCalculatorPromoPrice()).isNull();
        });
    }

    @Test
    public void testConfigureEndpointInvalid()
    {
        StringProductFieldParser parser = new StringProductFieldParser();
        BaseProduct baseProduct = new BaseProduct();
        parser.configureEndpoint(baseProduct, invalidLine);
        assertThat(baseProduct.isValid()).isFalse();
    }
}