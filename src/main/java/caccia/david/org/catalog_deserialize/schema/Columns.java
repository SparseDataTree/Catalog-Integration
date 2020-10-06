package caccia.david.org.catalog_deserialize.schema;

import javax.xml.stream.events.EndDocument;

public enum Columns implements GetType
{
    Start
            {
                @Override
                public Class getType() {
                    return Integer.class;
                }
            },
    End
            {
                @Override
                public Class getType() {
                    return Integer.class;
                }
            },
    Name
            {
                @Override
                public Class getType() {
                    return String.class;
                }
            },
    Type
            {
                @Override
                public Class getType() {
                    return FieldTypes.class;
                }
            };
}
