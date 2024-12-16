package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
//        For test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction",
                "Geoge Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladin", "Animation", 18.99f);
        Book book1 = new Book(4, "Alice", "dont know", 20f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
//
        while (true) {
            Menu.showMenu();
            Scanner keyboard = new Scanner(System.in);
            int option;
            do {
                option = keyboard.nextInt();
                keyboard.nextLine();
                if (option > 3 || option < 0)
                    System.out.println("Please enter a number between 0 - 3!");
            } while (option > 3 || option < 0);

            if (option == 0)
                break;

            switch (option) {
                case 1:
                    while (true) {
                        Menu.storeMenu();
                        do {
                            option = keyboard.nextInt();
                            keyboard.nextLine();
                            if (option > 4 || option < 0)
                                System.out.println("Please enter a number between 0 - 4!");
                        } while (option > 4 || option < 0);

                        if (option == 0)
                            break;

                        switch (option) {
                            case 1:
                                System.out.print("Enter the title of the media: ");
                                String title = keyboard.nextLine();
                                Media m = store.findMediaByTitle(title);

                                if (m == null)
                                    break;

                                if (m instanceof Book) {
                                    Menu.bookDetailsMenu();
                                    do {
                                        option = keyboard.nextInt();
                                        keyboard.nextLine();
                                        if (option > 1 || option < 0)
                                            System.out.println("Please enter a number between 0 - 1!");
                                    } while (option > 1 || option < 0);
                                    if (option == 1) {
                                        cart.addMedia(m);
                                    }
                                    break;
                                }

                                Menu.mediaDetailsMenu();
                                do {
                                    option = keyboard.nextInt();
                                    keyboard.nextLine();
                                    if (option > 2 || option < 0)
                                        System.out.println("Please enter a number between 0 - 2!");
                                } while (option > 2 || option < 0);

                                if (option == 1) {
                                    cart.addMedia(m);
                                } else if (option == 2) {
                                    Disc disc = (Disc) m;
                                    disc.play();
                                }

                                break;


                            case 2:
                                store.showStore();
                                System.out.println("Enter the title: ");
                                title = keyboard.nextLine();
                                m = store.findMediaByTitle(title);
                                if (m != null)
                                    cart.addMedia(m);
                                break;


                            case 3:
                                store.showStore();
                                System.out.println("Enter the title: ");
                                title = keyboard.nextLine();
                                m = store.findMediaByTitle(title);
                                if (m != null) {
                                    if (m instanceof Book) {
                                        System.out.println("Book cant be play!");
                                        break;
                                    }
                                    Disc disc = (Disc) m;
                                    disc.play();
                                }
                                break;


                            case 4:
                                if (!cart.print())
                                    break;

                                while (true) {
                                    Menu.cartMenu();
                                    do {
                                        option = keyboard.nextInt();
                                        keyboard.nextLine();
                                        if (option > 5 || option < 0)
                                            System.out.println("Please enter a number between 0 - 5!");
                                    } while (option > 5 || option < 0);

                                    if (option == 0)
                                        break;

                                    switch (option) {
                                        case 1:
                                            if (cart.isEmpty()) {
                                                System.out.println("No items in cart!");
                                                break;
                                            }
                                            Menu.filterMediaInCartMenu();
                                            do {
                                                option = keyboard.nextInt();
                                                keyboard.nextLine();
                                                if (option > 2 || option < 0)
                                                    System.out.println("Please enter a number between 0 - 2!");
                                            } while (option > 2 || option < 0);

                                            if (option == 0)
                                                break;

                                            if (option==1) {
                                                System.out.println("Enter media's id to filter: ");
                                                int id = keyboard.nextInt();
                                                keyboard.nextLine();
                                                cart.filterById(id);
                                                break;
                                            }

                                            if (option==2) {
                                                System.out.println("Enter media's title to filter: ");
                                                title = keyboard.nextLine();
                                                cart.filterByTitle(title);
                                                break;
                                            }


                                        case 2:
                                            if (cart.isEmpty()) {
                                                System.out.println("No items in cart!");
                                                break;
                                            }

                                            Menu.sortMediaInCartMenu();
                                            do {
                                                option = keyboard.nextInt();
                                                keyboard.nextLine();
                                                if (option > 2 || option < 0)
                                                    System.out.println("Please enter a number between 0 - 2!");
                                            } while (option > 2 || option < 0);

                                            if (option == 0)
                                                break;

                                            if (option==1) {
                                                cart.sortMediaByTitle();
                                                cart.print();
                                                break;
                                            }

                                            cart.sortMediaByCost();
                                            cart.print();
                                            break;


                                        case 3:
                                            if (cart.isEmpty()) {
                                                System.out.println("No items in cart!");
                                                break;
                                            }

                                            System.out.println("Enter the title of the media you want to remove: ");
                                            title = keyboard.nextLine();
                                            m = cart.searchMediaByTitle(title);
                                            cart.removeMedia(m);
                                            cart.print();
                                            break;


                                        case 4:
                                            if (cart.isEmpty()) {
                                                System.out.println("No items in cart!");
                                                break;
                                            }

                                            System.out.println("Enter the title: ");
                                            title = keyboard.nextLine();
                                            m = cart.searchMediaByTitle(title);
                                            if (m != null) {
                                                if (m instanceof Book) {
                                                    System.out.println("Book cant be play!");
                                                    break;
                                                }
                                                Disc disc = (Disc) m;
                                                disc.play();
                                            }
                                            break;


                                        case 5:
                                            if (cart.isEmpty()) {
                                                System.out.println("No items in cart!");
                                                break;
                                            }
                                            System.out.println("An order has been created!");
                                            cart.emptyCart();
                                            break;
                                    }
                                }
                        }
                    }

                    break;


                case 2:
                    while (true) {
                        Menu.updateStoreMenu();
                        do {
                            option = keyboard.nextInt();
                            keyboard.nextLine();
                            if (option > 2 || option < 0)
                                System.out.println("Please enter a number between 0 - 2!");
                        } while (option > 2 || option < 0);

                        if (option == 0)
                            break;

                        if (option == 1) {
                            Media m = Menu.getMediaInfo(keyboard);
                            store.addMedia(m);
                        }

                        if (option == 2) {
                            System.out.println("Enter the media title you want to remove from store: ");
                            String title = keyboard.nextLine();
                            Media m = store.findMediaByTitle(title);
                            store.removeMedia(m);
                        }
                    }

                    break;


                case 3:
                    if (!cart.print())
                        break;

                    while (true) {
                        Menu.cartMenu();
                        do {
                            option = keyboard.nextInt();
                            keyboard.nextLine();
                            if (option > 5 || option < 0)
                                System.out.println("Please enter a number between 0 - 5!");
                        } while (option > 5 || option < 0);

                        if (option == 0)
                            break;

                        switch (option) {
                            case 1:
                                if (cart.isEmpty()) {
                                    System.out.println("No items in cart!");
                                    break;
                                }
                                Menu.filterMediaInCartMenu();
                                do {
                                    option = keyboard.nextInt();
                                    keyboard.nextLine();
                                    if (option > 2 || option < 0)
                                        System.out.println("Please enter a number between 0 - 2!");
                                } while (option > 2 || option < 0);

                                if (option == 0)
                                    break;

                                if (option==1) {
                                    System.out.println("Enter media's id to filter: ");
                                    int id = keyboard.nextInt();
                                    keyboard.nextLine();
                                    cart.filterById(id);
                                    break;
                                }

                                if (option==2) {
                                    System.out.println("Enter media's title to filter: ");
                                    String title = keyboard.nextLine();
                                    cart.filterByTitle(title);
                                    break;
                                }


                            case 2:
                                if (cart.isEmpty()) {
                                    System.out.println("No items in cart!");
                                    break;
                                }

                                Menu.sortMediaInCartMenu();
                                do {
                                    option = keyboard.nextInt();
                                    keyboard.nextLine();
                                    if (option > 2 || option < 0)
                                        System.out.println("Please enter a number between 0 - 2!");
                                } while (option > 2 || option < 0);

                                if (option == 0)
                                    break;

                                if (option==1) {
                                    cart.sortMediaByTitle();
                                    cart.print();
                                    break;
                                }

                                cart.sortMediaByCost();
                                cart.print();
                                break;


                            case 3:
                                if (cart.isEmpty()) {
                                    System.out.println("No items in cart!");
                                    break;
                                }

                                System.out.println("Enter the title of the media you want to remove: ");
                                String title = keyboard.nextLine();
                                Media m = cart.searchMediaByTitle(title);
                                cart.removeMedia(m);
                                cart.print();
                                break;


                            case 4:
                                if (cart.isEmpty()) {
                                    System.out.println("No items in cart!");
                                    break;
                                }

                                System.out.println("Enter the title: ");
                                title = keyboard.nextLine();
                                m = cart.searchMediaByTitle(title);
                                if (m != null) {
                                    if (m instanceof Book) {
                                        System.out.println("Book cant be play!");
                                        break;
                                    }
                                    Disc disc = (Disc) m;
                                    disc.play();
                                }
                                break;


                            case 5:
                                if (cart.isEmpty()) {
                                    System.out.println("No items in cart!");
                                    break;
                                }
                                System.out.println("An order has been created!");
                                cart.emptyCart();
                                break;
                        }
                    }
            }
        }
    }
}