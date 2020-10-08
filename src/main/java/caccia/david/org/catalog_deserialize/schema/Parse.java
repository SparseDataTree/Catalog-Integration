package caccia.david.org.catalog_deserialize.schema;

public interface Parse<T extends Object> {
    T parse(String input);
}
