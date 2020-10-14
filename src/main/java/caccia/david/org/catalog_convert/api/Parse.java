package caccia.david.org.catalog_convert.api;

public interface Parse<T extends Object> {
    T parse(String input);
}
