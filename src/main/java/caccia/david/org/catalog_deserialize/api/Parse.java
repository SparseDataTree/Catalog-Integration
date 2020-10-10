package caccia.david.org.catalog_deserialize.api;

public interface Parse<T extends Object> {
    T parse(String input);
}
