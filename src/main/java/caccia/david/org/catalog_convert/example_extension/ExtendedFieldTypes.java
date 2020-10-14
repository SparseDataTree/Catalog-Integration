package caccia.david.org.catalog_convert.example_extension;

import caccia.david.org.catalog_convert.api.Parse;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum ExtendedFieldTypes implements Parse
{
    ProductDate
            {
                @Override
                public Object parse(String input)
                {
                    Date date;
                    try
                    {
                        date = new SimpleDateFormat(DATE_FORMAT).parse(input);
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                    return date;
                }
            };

    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
