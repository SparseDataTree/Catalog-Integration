package caccia.david.org.catalog_deserialize.data;

public class BaseProduct {

    // todo consider which should be final, private, etc.
    int id;
    String description;
    String displayPrice;
    Double calculatorPrice; // 4 decimal places
    String displayPromoPrice;
    Double calculatorPromoPrice;
    Units unit;
    Double size;
    Double taxRate;
}
