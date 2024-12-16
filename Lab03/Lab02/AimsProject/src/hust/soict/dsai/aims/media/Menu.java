package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void bookDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediaInCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. By Id");
        System.out.println("2. By Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortMediaInCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static Media getMediaInfo(Scanner keyboard) {
        int mediaType;
        int id;
        String title;
        String category;
        float cost;
        String author;
        List<String> authors = new ArrayList<String>();
        int length;
        String director;
        String artist;
        String trackTitle;
        int trackLength;

        System.out.println("Choose type of media:");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2-3");

        do {
            mediaType = keyboard.nextInt();
            keyboard.nextLine();
            if (mediaType < 1 || mediaType > 3)
                System.out.println("Please provide an option between 1 to 3!");
        } while (mediaType < 1 || mediaType > 3);

        System.out.println("Enter the media id: ");
        id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter the media title: ");
        title = keyboard.nextLine();
        System.out.println("Enter the media category: ");
        category = keyboard.nextLine();
        System.out.println("Enter the media cost: ");
        cost = keyboard.nextFloat();
        keyboard.nextLine();

        if (mediaType == 1) {
            while (true) {
                System.out.println("Enter the author name (Enter nothing to stop entering): ");
                author = keyboard.nextLine();
                if (!author.isEmpty())
                    authors.add(author);
                else break;
            }
            Book book = new Book(id, title, category, cost);
            for (String a: authors) {
                book.addAuthor(a);
            }
            return book;
        }

        if (mediaType == 2) {
            System.out.println("Enter the media length: ");
            length = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Enter the media director: ");
            director = keyboard.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
            return dvd;
        }

        System.out.println("Enter the media director: ");
        director = keyboard.nextLine();
        System.out.println("Enter the media artist: ");
        artist = keyboard.nextLine();
        CompactDisc cd = new CompactDisc(id, title, category, director, cost, artist);

        while (true) {
            System.out.println("Enter the track title (Enter nothing to quit): ");
            trackTitle = keyboard.nextLine();
            if (trackTitle.isEmpty())
                break;
            System.out.println("Enter the track length: ");
            trackLength = keyboard.nextInt();
            keyboard.nextLine();
            cd.addTrack(new Track(trackTitle, trackLength));
        }
        return cd;

    }
}
