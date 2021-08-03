package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import static pos.machine.ItemDataLoader.loadAllItemInfos;


public class PosMachine {
    public static String printReceipt(List<String> barcodes) {
        List<Item> itemList = getItems(barcodes);
        return null;
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

}
