package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        if (media1.getCost() < media2.getCost()) return -1;
        if (media1.getCost() > media2.getCost()) return 1;
        return media1.getTitle().compareTo(media2.getTitle());
    }
}
