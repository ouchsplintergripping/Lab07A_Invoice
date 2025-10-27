public class Item {
    //Declare fields
    private String itemName;
    private double itemPrice;

    //Reusable object
    public Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    //Declare getters
    public double getItemPrice() {
        return itemPrice;
    }
    public String getItemName() {
        return itemName;
    }
}
