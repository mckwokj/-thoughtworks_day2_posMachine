package posmachine;

import java.util.ArrayList;
import java.util.List;

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

        return allData;
    }

    private Receipt calculateReceipt (List<ItemInfo> itemWithDetail) {
        return null;
    }

    private Receipt renderReceipt (Receipt receipt) { return null; }

    private int calculateTotalPrice(List<ReceiptItem> receiptItems) {
        return 0;
    }

    private List<ReceiptItem> receiptItems(List<ItemInfo> itemWithDetail) {
        return null;
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
    }
}
