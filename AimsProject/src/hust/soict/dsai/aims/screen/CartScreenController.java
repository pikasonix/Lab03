package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import java.util.function.Predicate;
import javafx.scene.control.Alert.AlertType;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;

public class CartScreenController {
    private Cart cart;
    private Store store;
    private StoreScreen storeScreen;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    private MenuItem viewCartMenuItem;

    @FXML
    private MenuItem viewStoreMenuItem;

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(String.valueOf(this.cart.totalCost()));
    }

    void showFilteredMedia(String tf) {
        ObservableList<Media> list = cart.getItemsOrdered();
        
        Predicate<Media> predicate = media -> {
            if (tf.isEmpty()) {
                return true;
            }
            if (radioBtnFilterId.isSelected()) {
                return Integer.toString(media.getId()).contains(tf);
            }
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().contains(tf);
            }
            return false;
        };

        FilteredList<Media> filteredList = new FilteredList<>(list);
        filteredList.setPredicate(predicate);
        tblMedia.setItems(filteredList);
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML 
    void btnPlaceOrderPressed(ActionEvent event) {
        if (this.cart.size() > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success!");
			alert.setContentText("Your order has been placed.");
			alert.showAndWait();
			this.cart.clearCart();
			costLabel.setText(String.valueOf(this.cart.totalCost()));
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("ERROR: Failed to place order.");
			alert.setContentText("Your cart is empty");
			alert.showAndWait();
		}
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable)media).play();
        } catch (PlayerException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    void viewStoreMenuItemPressed(ActionEvent event) {
        new StoreScreen(store, cart);
    }
    
    @FXML
    void addCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, storeScreen);
    }

    @FXML
    void addDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, storeScreen);
    }

    @FXML 
    void addBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, storeScreen);
    }

    void updateCost() {
        costLabel.setText(String.valueOf(cart.totalCost()));
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost")
        );
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> change) {
                updateCost();
            }
    });
        updateCost();
    }

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
}
