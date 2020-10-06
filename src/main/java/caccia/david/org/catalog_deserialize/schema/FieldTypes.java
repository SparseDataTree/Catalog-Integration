package caccia.david.org.catalog_deserialize.schema;

public enum FieldTypes implements Parse
{
    Number
            {
                @Override
                public Object parse(String input) {
                    return Integer.parseInt(input);
                }
            },
    String
            {
                @Override
                public Object parse(java.lang.String input) {
                    return input.trim();
                }
            },
    Currency
            {
                @Override
                public Object parse(java.lang.String input) {
                    Integer number = Integer.parseInt(input);
                    return 1.0*number/100.0;
                }
            },
    Flags
            {
                @Override
                public Object parse(java.lang.String input) {
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
