package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> author = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return author;
    }

    public void addAuthor(String authorName) {
        if (!author.contains(authorName)) {
            author.add(authorName);
        }
        else System.out.println("Fail to add! The authorName is existed");
    }

    public void removeAuthor(String authorName) {
        if (author.contains(authorName)) {
            author.remove(authorName);
        }
        else System.out.println("Fail to delete! The authorName is not exist");
    }

    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getAuthors() + " - " + this.getCategory() + " - " + this.getCost() + "$";
    }


}
