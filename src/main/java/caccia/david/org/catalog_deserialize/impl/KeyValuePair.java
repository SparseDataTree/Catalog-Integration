package caccia.david.org.catalog_deserialize.impl;

public class KeyValuePair {
    private final String key;
    private final Object value;

    public KeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
