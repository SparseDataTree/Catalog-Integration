package caccia.david.org.catalog_deserialize.impl;

import caccia.david.org.catalog_deserialize.impl.FieldTypes;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FieldTypesTest {

    // Has to be a better way, but for now, need to add this arg to JVM args "-Dtestng.dtd.http=true"
    @Test
    public void testParseString()
    {
        String input = " Hello ";
        String output = (String) FieldTypes.Text.parse(input);
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
        String numberIn = "000000123";
        String numberOut = (String)FieldTypes.Currency.parse(numberIn);
        assertThat(numberOut).isEqualTo("$1.23");
    }

    @Test
    public void testParseNegativeCurrency()
    {
        String numberIn = "-00000123";
        String numberOut = (String)FieldTypes.Currency.parse(numberIn);
        assertThat(numberOut).isEqualTo("-$1.23");
    }

    @Test
    public void testParseFlags()
    {
        String flagsIn = "YYYNNYNNN";
        Boolean[] flags = (Boolean[])FieldTypes.Flags.parse(flagsIn);
        assertThat(flags.length).isEqualTo(9);
        assertThat(flags[0]).isTrue();
        assertThat(flags[4]).isFalse();
    }


}