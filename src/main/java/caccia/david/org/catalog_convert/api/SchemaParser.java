package caccia.david.org.catalog_convert.api;

import caccia.david.org.catalog_convert.data.ValidBase;

public interface SchemaParser<V extends ValidBase> {

    void configureEndpoint(V endpoint,String input);

}
