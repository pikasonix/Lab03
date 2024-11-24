package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_STORE = 1000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_STORE];
	
    private int qtyItemsInStore = 0;
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyItemsInStore < MAX_ITEMS_STORE) {
			itemsInStore[qtyItemsInStore++] = dvd;
        	System.out.println("The disc has been added to Store. ID: " + dvd.getId() +" Title: "+ dvd.getTitle());
        } else {
            System.out.println("The store is almost full");
        }
	}
	public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyItemsInStore; i++) {
            if (itemsInStore[i] == dvd) {
            	for (int j = i; j < qtyItemsInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
            	--qtyItemsInStore;
                itemsInStore[qtyItemsInStore] = null;
                System.out.println("dvd" + (i+1) + " has been removed from Store");
                break;
            }
        }
	}
	
	public void print() {
    	System.out.println("***********************STORE***********************");
    	System.out.println("Store Items:");
    	for (int i = 0; i < qtyItemsInStore; i++) {
    		System.out.println(i+1 + itemsInStore[i].toString());  
    	}
    	System.out.println("****************************************************");
    }
}