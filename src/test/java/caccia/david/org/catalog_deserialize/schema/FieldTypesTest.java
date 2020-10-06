package caccia.david.org.catalog_deserialize.schema;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.*;

public class FieldTypesTest {

    // Has to be a better way, but for now, need to add this arg to JVM args "-Dtestng.dtd.http=true"
    @Test
    public void testParseString()
    {
        String input = " Hello ";
        String output = (String)FieldTypes.String.parse(input);
        assertThat(output).isEqualTo("Hello");
    }

    @Test
    public void testParseNumber()
    {
        String numberIn = "00123";
        Integer numberOut = (Integer)FieldTypes.Number.parse(numberIn);
        assertThat(numberOut).isEqualTo(123);
    }

    @Test
    public void testParseCurrency()
    {
        String numberIn = "00123";
        Double numberOut = (Double)FieldTypes.Currency.parse(numberIn);
        assertThat(numberOut).isEqualTo(1.23);
    }

    @Test
    public void testParseNegativeCurrency()
    {
        String numberIn = "-00123";
        Double numberOut = (Double)FieldTypes.Currency.parse(numberIn);
        assertThat(numberOut).isEqualTo(-1.23);
    }

    @Test
    public void testParseFlags()
    {
        String flagsIn = "YYYNNY";
        Boolean[] flags = (Boolean[])FieldTypes.Flags.parse(flagsIn);
        assertThat(flags.length).isEqualTo(6);
        assertThat(flags[0]).isTrue();
        assertThat(flags[4]).isFalse();
    }


}