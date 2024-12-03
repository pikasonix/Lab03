package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    
    public Book(String title) {
        super(title);
    }
    
    public Book(String title, String category) {
        super(title, category);
    }
    
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public List<String> getAuthors() {
        return authors;
    }
    
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName +" has already existed");
            return;
        }
        authors.add(authorName);
        System.out.println("Author " + authorName + " has added");
    }
    
    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author " + authorName + " does not exist");
            return;
        }
        authors.remove(authorName);
        System.out.println("Author " + authorName + " has removed");
    }
    
    @Override
    public String toString() {
        return ". Book - " + this.getTitle() + " - " + this.getAuthors() + " - " + this.getCategory() + " - " + this.getCost() + "$";
    }
}