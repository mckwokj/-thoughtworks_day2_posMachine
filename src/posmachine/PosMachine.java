package posmachine;

import java.util.*;

import item.ItemInfo;
import receipt.Receipt;
import receipt.ReceiptItem;

public class PosMachine {
    private String printReceipt (List<String> barcodes) { return null; }

    private List<ItemInfo> getItemInfos (List<String> barcodes) {
        List<ItemInfo> allData = new ArrayList<>();
        allData.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        allData.add(new ItemInfo("Sprite", "ITEM000001", 3));
        allData.add(new ItemInfo("Apple", "ITEM000002", 5));
        allData.add(new ItemInfo("Litchi", "ITEM000003", 15));
        allData.add(new ItemInfo("Battery", "ITEM000004", 2));
        allData.add(new ItemInfo("Instant Noodles", "ITEM000005", 4));

        List<ItemInfo> itemInfos = new ArrayList<>();
        itemInfos.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        itemInfos.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        itemInfos.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        itemInfos.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        itemInfos.add(new ItemInfo("Coca-Cola", "ITEM000000", 3));
        itemInfos.add(new ItemInfo("Sprite", "ITEM000001", 3));
        itemInfos.add(new ItemInfo("Sprite", "ITEM000001", 3));
        itemInfos.add(new ItemInfo("Battery", "ITEM000004", 2));

        return itemInfos;
    }

    private Receipt calculateReceipt (List<ItemInfo> itemWithDetail) {

        Map<String, ReceiptItem> receiptItems = calculateReceiptItems(itemWithDetail);
        int totalPrice = calculateTotalPrice(receiptItems);
        return new Receipt(receiptItems, totalPrice);
    }

    private Receipt renderReceipt (Receipt receipt) {

    }

    private int calculateTotalPrice(Map<String, ReceiptItem> receiptItems) {
        int totalPrice = 0;

        for (String receiptItemName: receiptItems.keySet()) {
            totalPrice += receiptItems.get(receiptItemName) .getSubTotal();
        }

        return totalPrice;
    }

    private Map<String, ReceiptItem> calculateReceiptItems(List<ItemInfo> itemWithDetail) {
        Map<String, ReceiptItem> receiptItems = new HashMap<>();

        for (ItemInfo item: itemWithDetail) {
            if (!receiptItems.containsKey(item.getName())) {
                receiptItems.put(item.getName(), new ReceiptItem(item.getName(), 1, item.getPrice(), item.getPrice()));
            } else {
                int oldQuantity = receiptItems.get(item.getName()).getQuantity();
                int oldSubTotal = receiptItems.get(item.getName()).getSubTotal();
                receiptItems.remove(item.getName());
                receiptItems.put(item.getName(), new ReceiptItem(item.getName(), oldQuantity+1, item.getPrice(), oldSubTotal+item.getPrice()));
            }
        }

        return receiptItems;
    }

    public static void main(String[] args) {
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000004");

        PosMachine m1 = new PosMachine();

        List<ItemInfo> allData = m1.getItemInfos(barcodes);

        Receipt receipt = m1.calculateReceipt(allData);

        m1.renderReceipt(receipt);
    }
}
