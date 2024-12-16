package hust.soict.dsai.aims.store;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media... media) {
        itemsInStore.addAll(Arrays.asList(media));
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public Media findMediaByTitle(String title) {
        for (Media m: itemsInStore) {
            if (m.isMatch(title)) {
                System.out.println(m.toString());
                return m;
            }
        }
        System.out.println("not found!");
        return null;
    }

    public void showStore() {
        int i = 1;
        for (Media m : itemsInStore) {
            System.out.println(i + ". " + m.toString());
            i++;
        }
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
