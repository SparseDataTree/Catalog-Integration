package caccia.david.org.catalog_deserialize.schema;


public enum Columns implements Parse
{
    Start(Integer.class)
            {
                @Override
                public Integer parse(String token) {
                    return (Integer) FieldTypes.Number.parse(token);
                }
            },
    End(Integer.class)
            {
                @Override
                public Integer parse(String token) {
                    return (Integer) FieldTypes.Number.parse(token);
                }
            },
    Name(String.class)
            {
                @Override
                public String parse(String token) {
                    return (String) FieldTypes.Text.parse(token);
                }
            },
    Type(FieldTypes.class)
            {
                @Override
                public FieldTypes parse(String token) {
                    return FieldTypes.valueOf(token);
                }
            };

    private final Class columnClass;

    Columns(Class enumsClass)
    {
        columnClass = enumsClass;
    }

    Class getColumnClass()
    {
        return columnClass;
    }



}
