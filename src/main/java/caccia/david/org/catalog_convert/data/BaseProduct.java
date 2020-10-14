package caccia.david.org.catalog_convert.data;

public class BaseProduct extends ValidBase{

    // todo consider which should be final, private, etc.
    private int id;
    private String description;
    private String displayPrice;
    private Double calculatorPrice; // 4 decimal places
    private String displayPromoPrice;
    private Double calculatorPromoPrice; // 4 decimal places
    private Units unit;
    private String size;
    private String taxRate;
    private Double taxFactor;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = String.format("%.3f%%",taxRate);
        this.taxFactor = 1.0 + taxRate/100.0;
    }

    public Double getTaxFactor()
    {
        return taxFactor;
    }
}
