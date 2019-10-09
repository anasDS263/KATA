import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Item item1 = new Item("Livres",2,new BigDecimal(12.49),Type.BOOK,false);
        Item item2 = new Item("CD musical",1,new BigDecimal(14.99),Type.OTHER,false);
        Item item3 = new Item("Barres de chocolat",3,new BigDecimal(0.85),Type.NECESSITY,false);
        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        calcul(items);
    }

    public static void calcul(List<Item> items){

        BigDecimal totalTTC = new BigDecimal(0);
        BigDecimal taxes = new BigDecimal(0);

        for(Item item : items){
            item.setPriceTTC(
                    item.round(item.getPriceHT().add(item.round(item.getPriceHT().multiply(item.getCoefficient(item.getType())))) )
            );

            item.setGlobalPriceTTC(item.getPriceTTC().multiply(new BigDecimal(item.getAmount())));
            totalTTC = totalTTC.add(item.getGlobalPriceTTC());
            taxes = taxes.add(item.getPriceTTC().subtract(item.getPriceHT()));

            System.out.println("* " + item.getAmount() + " " + item.getLabel() + " à " + item.getPriceHT().setScale(2, RoundingMode.CEILING) + " : " + item.getGlobalPriceTTC().setScale(2, RoundingMode.CEILING) + " Euro");
        }

        System.out.println("Montants des taxes : "+taxes.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total : "+totalTTC.setScale(2, RoundingMode.HALF_UP));
    }
}
