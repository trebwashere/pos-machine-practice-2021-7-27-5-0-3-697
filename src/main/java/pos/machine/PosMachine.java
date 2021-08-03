package pos.machine;

import java.util.List;

import static pos.machine.ItemDataLoader.loadAllItemInfos;


public class PosMachine {
    public static String printReceipt(List<String> barcodes) {
        return null;
    }

    public static ItemInfo getItemInformation(String barCode) {
        for(ItemInfo item : loadAllItemInfos()) {
            if (item.getBarcode().equals(barCode)) {
                return item;
            }
        }
        return null;
    }

}
