import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {

    private String label;
    private int amount;
    private BigDecimal priceTTC;
    private BigDecimal taxe;
    private BigDecimal priceHT;
    private BigDecimal globalPriceTTC;
    private Type type;
    private boolean imported;

    public Item() {
    }

    public Item(String label, int amount, BigDecimal priceHT, Type type, boolean imported) {
        this.label = label;
        this.amount = amount;
        this.priceHT = priceHT;
        this.type = type;
        this.imported = imported;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(BigDecimal priceTTC) {
        this.priceTTC = priceTTC;
    }

    public BigDecimal getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(BigDecimal priceHT) {
        this.priceHT = priceHT;
    }

    public BigDecimal getTaxe() {
        return taxe;
    }

    public void setTaxe(BigDecimal taxe) {
        this.taxe = taxe;
    }

    public BigDecimal getGlobalPriceTTC() {
        return globalPriceTTC;
    }

    public void setGlobalPriceTTC(BigDecimal globalPriceTTC) {
        this.globalPriceTTC = globalPriceTTC;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public BigDecimal round(BigDecimal price){
        BigDecimal result =  new BigDecimal(Math.ceil(price.doubleValue() * 20) / 20);
        result.setScale(2, RoundingMode.HALF_UP);
        return result;
    }

    public BigDecimal getCoefficient(Type type){
        switch(type){
            case NECESSITY:
                return new BigDecimal(0.0);
            case BOOK:
                return new BigDecimal(0.1);
            case OTHER:
                return new BigDecimal(0.2);
        }
        return new BigDecimal(0.2);
    }
}
