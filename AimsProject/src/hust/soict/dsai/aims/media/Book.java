package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    private static int id = 0;

    public Book() {
        
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
        id++;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already in list");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }

    public String toString() {
        return "Book" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + "$";
    }

}
