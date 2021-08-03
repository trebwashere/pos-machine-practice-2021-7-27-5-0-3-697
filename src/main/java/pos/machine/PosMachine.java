package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static pos.machine.ItemDataLoader.loadAllItemInfos;


public class PosMachine {
    public static String printReceipt(List<String> barcodes) {
        List<Item> itemList = getItems(barcodes);
        Receipt receipt = generateReceiptDetails(itemList);
        return formatReceipt(receipt);
    }

    public static List<Item> getItems(List<String> barcodeList) {
        List<Item> itemList = new ArrayList<>();
        List<String> barcodeLinkedList = new ArrayList<>(new LinkedHashSet<>(barcodeList));
        for (String currentBarcode : barcodeLinkedList) {
            ItemInfo itemInfo = getItemInformation(currentBarcode);
            if (itemInfo != null) {
                Item item = new Item(){{
                    setName(itemInfo.getName());
                    setUnitPrice(itemInfo.getPrice());
                    setQuantity(getItemCount(currentBarcode,barcodeList));
                }};
                itemList.add(item);
            }
        }
        return itemList;
    }

    public static ItemInfo getItemInformation(String barCode) {
        for(ItemInfo item : loadAllItemInfos()) {
            if (item.getBarcode().equals(barCode)) {
                return item;
            }
        }
        return null;
    }

    public static int getItemCount(String currentBarcode,List<String> barcodeList) {
        return Collections.frequency(barcodeList, currentBarcode);
    }

    public static Receipt generateReceiptDetails(List<Item> itemList) {
        itemList.forEach(item -> item.setSubTotal(getItemSubTotal(item.getUnitPrice(), item.getQuantity())));
        return new Receipt(){{
            setItemList(itemList);
            setTotalPrice(getFinalTotal(itemList));
        }};
    }

    public static int getItemSubTotal(int unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    public static int getFinalTotal(List<Item> itemList) {
        return itemList.stream()
                .map(Item::getSubTotal)
                .collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue).sum();
    }

    public static String formatReceipt(Receipt receipt) {
        String receiptOutput = "***<store earning no money>Receipt***\n";
        for (Item item : receipt.getItemList()) {
            receiptOutput =
                    receiptOutput
                            .concat(String.format("Name: %s, " +
                                            "Quantity: %d, " +
                                            "Unit price: %d (yuan), " +
                                            "Subtotal: %d (yuan)\n", item.getName(),
                                    item.getQuantity(),
                                    item.getUnitPrice(),
                                    item.getSubTotal()));
        }
        receiptOutput = receiptOutput.concat("----------------------\n");
        receiptOutput = receiptOutput.concat(String.format("Total: %d (yuan)\n", receipt.getTotalPrice()));
        receiptOutput = receiptOutput.concat("**********************");
        return receiptOutput;
    }

}
