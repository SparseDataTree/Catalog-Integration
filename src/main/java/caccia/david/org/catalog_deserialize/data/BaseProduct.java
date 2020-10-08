package caccia.david.org.catalog_deserialize.data;

public class BaseProduct {

    // todo consider which should be final, private, etc.
    private int id;
    private String description;
    private String displayPrice;
    private Double calculatorPrice; // 4 decimal places
    private String displayPromoPrice;
    private Double calculatorPromoPrice; // 4 decimal places
    private Units unit;
    private Double size;
    private Double taxRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public Double getCalculatorPrice() {
        return calculatorPrice;
    }

    public void setCalculatorPrice(Double calculatorPrice) {
        this.calculatorPrice = calculatorPrice;
    }

    public String getDisplayPromoPrice() {
        return displayPromoPrice;
    }

    public void setDisplayPromoPrice(String displayPromoPrice) {
        this.displayPromoPrice = displayPromoPrice;
    }

    public Double getCalculatorPromoPrice() {
        return calculatorPromoPrice;
    }

    public void setCalculatorPromoPrice(Double calculatorPromoPrice) {
        this.calculatorPromoPrice = calculatorPromoPrice;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}
