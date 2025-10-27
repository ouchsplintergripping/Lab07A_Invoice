import java.util.List;
import java.util.ArrayList;

public class Invoice {
    //Declare fields
    private String invoiceTitle;
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItemList = new ArrayList<>();

    //Reusable object
    public Invoice(String invoiceTitle, String customerName, String customerAddress) {
        this.invoiceTitle = invoiceTitle;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    //Control invoice
    public void addLineItem(LineItem lineItem) {
        lineItemList.add(lineItem);
    }
    public void clearLineItems() {
        lineItemList.clear();
    }
    public String buildCustomerDetails() {
        return customerName + "\n" + customerAddress;
    }
    public String buildInvoiceDetails() {
        String invoiceDetails = "";
        invoiceDetails += String.format("%-32s %-12s %-8s %-24s%n", "Item", "Price", "QTY", "Line Total");
        invoiceDetails += "\n------------------------------------------------------------------\n";
        for (LineItem lineItem : lineItemList) {
            invoiceDetails += String.format("%-32s %-12.2f %-8d %-24.2f%n",
                    lineItem.getItem().getItemName(),
                    lineItem.getItem().getItemPrice(),
                    lineItem.getQuantity(),
                    lineItem.getLineItemTotal());
        }
        invoiceDetails += "------------------------------------------------------------------\n";
        invoiceDetails += String.format("%-32s %-12s %-8s %-24.2f%n", "", "", "Subtotal: ", getInvoiceSubtotal());
        return invoiceDetails;
    }

    //Declare getters
    public String getInvoiceTitle() {
        return invoiceTitle;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public List<LineItem> getLineItemList() {
        return lineItemList;
    }
    public double getInvoiceSubtotal() {
        double invoiceSubtotal = 0.00;
        for (LineItem lineItem : lineItemList) {
            invoiceSubtotal += lineItem.getLineItemTotal();
        }
        return invoiceSubtotal;
    }

    //Declare setters
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
