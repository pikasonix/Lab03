package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.*;

public class Cart {
    public int cartSize = 0;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public List<Media> addMedia(Media media) {
        itemsOrdered.add(media);
        cartSize++;
        return itemsOrdered;
    }

    public List<Media> removeMedia(Media media) {
        itemsOrdered.remove(media);
        cartSize--;
        return itemsOrdered;
    }

    public float totalCost() {
        float cost = 0; 
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }

    public void printList() {
        System.out.println("***********************CART***********************");
        System.out.println("Items ordered: ");
        for (Media dvd: itemsOrdered) {
                System.out.println(dvd.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int idToMatch) {
        boolean dvdFound = false;
        for (Media dvd: itemsOrdered) {
            if (dvd.getId() == idToMatch) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        } 
    }

    public void searchByTitle(String titleToMatch) {
        boolean dvdFound = false;
        for (Media dvd:itemsOrdered) {
            if (((DigitalVideoDisc) dvd).isMatch(titleToMatch)) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        }
    }
    
    public int size() {
        return cartSize;
    }

    public void clearCart() {
        for (Media media: itemsOrdered) {
            itemsOrdered.remove(media);
        }
    } 
}

