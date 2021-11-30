package receipt;

import java.util.List;

public class Receipt {
    private List<ReceiptItem> itemDetail;
    private int totalPrice;

    public Receipt(List<ReceiptItem> itemDetail, int totalPrice) {
        this.itemDetail = itemDetail;
        this.totalPrice = totalPrice;
    }

    public List<ReceiptItem> getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(List<ReceiptItem> itemDetail) {
        this.itemDetail = itemDetail;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "itemDetail=" + itemDetail +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
