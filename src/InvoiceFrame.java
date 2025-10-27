import javax.swing.*;

import java.awt.*;

public class InvoiceFrame extends JFrame {
    //Stage things
    private JTextField invoiceTitleField, customerDetails;

    private JTextArea invoiceDetails;

    private JButton newInvoiceBtn, addItemBtn, removeItemBtn, showInvoiceBtn;

    private Invoice invoice;
    public InvoiceFrame() {
        super("Invoice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5,5));

        JPanel headerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        add(headerPanel, BorderLayout.NORTH);
        headerPanel.setBorder(BorderFactory.createTitledBorder("Invoice"));
        headerPanel.add(invoiceTitleField = new JTextField());
        headerPanel.add(customerDetails = new JTextField());

        JPanel contentPanel = new JPanel(new GridLayout(1, 1));
        add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        contentPanel.add(invoiceDetails = new JTextArea());
        invoiceDetails.setEditable(false);
        invoiceDetails.setLineWrap(true);
        contentPanel.add(new JScrollPane(invoiceDetails));

        JPanel controlPanel = new JPanel(new GridLayout(1, 4, 25,0));
        add(controlPanel, BorderLayout.SOUTH);
        controlPanel.setBorder(BorderFactory.createTitledBorder("Invoice Control"));
        controlPanel.add(newInvoiceBtn = new JButton("New Invoice"));
        controlPanel.add(showInvoiceBtn = new JButton("Show Invoice"));
        controlPanel.add(addItemBtn = new JButton("Add Item"));
        controlPanel.add(removeItemBtn = new JButton("Remove Item"));

        //Actions
        invoice = new Invoice("", "", "");
        newInvoiceBtn.addActionListener(e -> {
            invoice.clearLineItems();
            invoiceDetails.setText("");
            customerDetails.setText("");
            invoiceTitleField.setText("");
        });

        showInvoiceBtn.addActionListener(e -> {
            invoiceDetails.setText(invoice.buildInvoiceDetails());
            invoiceDetails.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        });

        addItemBtn.addActionListener(e -> {
            String inputName = JOptionPane.showInputDialog("Enter Item Name: ");
            String inputQuantityString = JOptionPane.showInputDialog("Enter Item Quantity: ");
            int  inputQuantity = Integer.parseInt(inputQuantityString);
            String inputPriceString = JOptionPane.showInputDialog("Enter Price per Unit: ");
            double inputPrice = Double.parseDouble(inputPriceString);

            invoice.addLineItem(new LineItem(new Item(inputName, inputPrice), inputQuantity));
        });

        removeItemBtn.addActionListener(e -> {
            invoice.getLineItemList().removeLast();
        });
    }
}
