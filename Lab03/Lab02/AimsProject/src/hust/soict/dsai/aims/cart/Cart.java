package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);
	
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED || itemsOrdered.contains(media)) {
        	System.out.println("The cart is almost full or media" + media.getTitle() + " has already existed");
			return;
        }
        itemsOrdered.add(media);
        System.out.println("The media " + media.getTitle() + " has been added");
    }
    
    public void removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
        	System.out.println("The media" + media.getTitle() + " does not exist");
			return;
        }
        itemsOrdered.remove(media);
        System.out.printf("The media " + media.getTitle() + " has been removed");
    }
    
    
    public void addMedia(Media[] mediaList) {
		for (Media media: mediaList) {
			addMedia(media);
		}
	}
    
    public float totalCost() {
		float total = 0;
        for (Media media: itemsOrdered) {
            total += media.getCost();
        }
		return total;
	}
    
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < itemsOrdered.size(); i++) {
    		System.out.println(i+1 + itemsOrdered.get(i).toString());  
    	}
    	System.out.printf("Total cost: %.2f\n", totalCost());
    	System.out.println("***************************************************");
    }
    
    public void searchMediaById(int id) {
		for (Media media: itemsOrdered) {
			if (media != null && media.getId() == id) {
				System.out.println(media.getId()+media.toString());
				return;
			}
		}
		System.out.println("Not found!");
	}
    
    public Media searchMediaByTitle(String title) {
		for (Media item: itemsOrdered) {
			if (item.isMatch(title)) return item;
		}
		return null;
	}
    
    public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
    public void empty() {
        if (itemsOrdered.size() != 0) {
        	itemsOrdered.clear();
            System.out.println("Order created");
            return;
        }
        System.out.println("Empty");
    }
    
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
}
