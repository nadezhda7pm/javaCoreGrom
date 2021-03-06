package lesson10.homeTask;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        System.out.println("validateOrder is running");
        if ((getShipFromCity().equals("Киев") || getShipFromCity().equals("Львов")) && (getBasePrice() >= 500) && (!getCustomerOwned().getName().equals("Тест"))){
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        System.out.println("calculatePrice is running");
        double totalPrice;
        if (getBasePrice() < 5000) {
            totalPrice = getBasePrice() + (getBasePrice() * 0.05);
            System.out.println("condition 1");
        } else{
            totalPrice = getBasePrice() + (getBasePrice() * 0.02);
            System.out.println("condition 2");}

        setTotalPrice(totalPrice);
    }
}
