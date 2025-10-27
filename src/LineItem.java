public class LineItem {
    //Declare fields
    private Item item;
    private int quantity;

    //Reusable object
    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //Declare getters
    public double getLineItemTotal() {
        return item.getItemPrice() * quantity;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
}
