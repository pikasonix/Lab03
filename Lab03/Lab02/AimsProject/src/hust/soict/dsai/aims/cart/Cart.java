package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);

	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED && !itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("The media " + media.getTitle() + " has been added");
		}
		else System.out.println("The cart is full. Cannot add to cart!");
	}

	public void addMedia(Media[] mediaList) {
		for (Media m : mediaList) {
			addMedia(m);
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media " + media.getTitle() + " has been removed");
		}
		else System.out.println("This media is not exist");

	}

	public float totalCost() {
		float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
		return total;
	}

	public boolean print() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("No items in cart!");
			return false;
		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
		}
		System.out.printf("%s %.2f$\n", "Total cost:", totalCost());
		System.out.println("**************************************************");
		return true;
	}

	public void filterById(int id) {
		System.out.println("Filter result:");
		int check = 0;
		for (Media m : itemsOrdered) {
			if (m.isMatch(id)) {
				System.out.println(m.toString());
				check = 1;
			}
		}

		if (check == 0)
			System.out.println("No such media in cart!");
	}

	public void filterByTitle(String title) {
		System.out.println("Filter result:");
		int check = 0;
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				System.out.println(m.toString());
				check = 1;
			}
		}

		if (check == 0)
			System.out.println("No such media in cart!");
	}

	public void sortMediaByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortMediaByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public Media searchMediaByTitle(String title) {
		for (Media item: itemsOrdered) {
			if (item.isMatch(title)) return item;
		}
		return null;
	}

	public void emptyCart() {
		itemsOrdered.clear();
	}

	public boolean isEmpty() {
		return itemsOrdered.isEmpty();
	}
}