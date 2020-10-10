package caccia.david.org.catalog_convert.impl;

import caccia.david.org.catalog_convert.api.Parse;

public enum FieldTypes implements Parse
{
    Number
            {
                @Override
                public Integer parse(String input) {
                    return Integer.parseInt(input);
                }
            },
    Text
            {
                @Override
                public String parse(java.lang.String input) {
                    return input.trim();
                }
            },
    Currency
            {
                @Override
                public String parse(String input) {
                    Integer number = Integer.parseInt(input);
                    Double dc = 1.0*number/100.0;
                    boolean negative = dc < 0;
                    String price;
                    if(negative)
                    {
                        dc = -1*dc;
                        price = String.format("-$%.2f",dc);
                    }
                    else
                    {
                        price = String.format("$%.2f",dc);
                    }
                    return price;
                }
            },
    Flags
            {
                @Override
                public Boolean[] parse(java.lang.String input) {
                    Boolean[] flags = new Boolean[input.length()];
                    int ix = 0;
                    for(char flag: input.toCharArray())
                    {
                        flags[ix++] = flag == "Y".charAt(0);
                    }
                    return flags;
                }
            };

}
