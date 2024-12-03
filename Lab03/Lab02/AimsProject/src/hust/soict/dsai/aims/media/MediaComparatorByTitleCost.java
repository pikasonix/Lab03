package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        int result = media1.getTitle().compareTo(media2.getTitle());
        if (result != 0) return result;
        else return Float.compare(media1.getCost(), media2.getCost());
    }
}
