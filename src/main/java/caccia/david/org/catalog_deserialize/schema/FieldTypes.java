package caccia.david.org.catalog_deserialize.schema;

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
                public String parse(java.lang.String input) {
                    Integer number = Integer.parseInt(input);
                    Double dc = 1.0*number/100.0;
                    boolean negative = dc < 0;
                    if(negative)
                    {
                        dc = -1*dc;
                    }
                    String price = String.format("%d",dc);
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
