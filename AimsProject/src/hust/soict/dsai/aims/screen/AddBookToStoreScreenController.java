package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.beans.value.*;
import java.util.List;
import java.util.ArrayList;

public class AddBookToStoreScreenController {
    private Store store;
    private Cart cart;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<>();
    private StoreScreen storeScreen;

    @FXML
    private TextArea tfBookAuthors;

    @FXML
    private TextField tfBookCategory;

    @FXML
    private TextField tfBookCost;

    @FXML
    private TextField tfBookTitle;

    @FXML 
    void viewStorePressed(ActionEvent event) {
        new StoreScreen(store, cart);
    }

    @FXML
    void viewCartPressed(ActionEvent event) {
        new CartScreen(cart);
    }

    @FXML
    void addDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, storeScreen);
    }

    @FXML
    void addCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, storeScreen);
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
        Book book = new Book(title, category, cost, authors);
        store.addMedia(book);
        store.display();
        storeScreen.updateDisplay();
    }

    @FXML
    public void initialize() {
        tfBookCategory.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                category = newValue;
            }
        });

        tfBookTitle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                title = newValue;
            }
        });

        tfBookCost.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cost = Float.valueOf(newValue);
            }
        });

        tfBookAuthors.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String input = tfBookAuthors.getText();
                String[] inputArr = input.split("\\n");

                for (String author : inputArr) {
                    authors.add(author);
                }
            }
        });
    }

    public AddBookToStoreScreenController(Store store, StoreScreen storeScreen) {
        super();
        this.store = store;
        this.storeScreen = storeScreen;
    }

}

