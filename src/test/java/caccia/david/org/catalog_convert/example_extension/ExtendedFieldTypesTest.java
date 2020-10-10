package caccia.david.org.catalog_convert.example_extension;

import org.testng.annotations.Test;
import java.util.Date;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExtendedFieldTypesTest
{

    @Test
    public void testParseDate()
    {
        String datetext = "2020-10-11";
        Date parsedDate = (Date) ExtendedFieldTypes.ProductDate.parse(datetext);
        assertThat(parsedDate.toString()).contains("Sun Oct 11 00:00:00");
    }
}