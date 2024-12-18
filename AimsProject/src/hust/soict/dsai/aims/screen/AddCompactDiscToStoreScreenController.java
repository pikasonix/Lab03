package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.beans.value.*;
import java.util.List;
import java.util.ArrayList;

import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreenController {
    private Store store;
    private Cart cart;
    private StoreScreen storeScreen;

    private String title;
    private String category;
    private float cost;
    private String director;
    private String artist;
    private int id;
    private String trackTitle;
    private int trackLength;
    private ObservableList<Track> trackList = FXCollections.observableArrayList();
    private List<Track> tracks = new ArrayList<>();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAddTrack;

    @FXML
    private TableView<Track> tblTrack;
    
    @FXML
    private TableColumn<Track, Integer> colTrackLength;

    @FXML
    private TableColumn<Track, String> colTrackTitle;

    @FXML
    private TextField tfCDArtist;

    @FXML
    private TextField tfCDCategory;

    @FXML
    private TextField tfCDCost;

    @FXML
    private TextField tfCDDirector;

    @FXML
    private TextField tfCDId;

    @FXML
    private TextField tfCDTitle;

    @FXML
    private TextField tfTrackLength;

    @FXML
    private TextField tfTrackTitle;

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
    void addBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store, storeScreen);
    }

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
        trackLength = Integer.valueOf(tfTrackLength.getText());
        trackTitle = tfTrackTitle.getText();
        Track track = new Track(trackTitle, trackLength);
        trackList.add(track);
        List<Track> tracks = new ArrayList<>(tblTrack.getItems());
        tfTrackTitle.clear();
        tfTrackLength.clear();
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
        CompactDisc cd = new CompactDisc(id, title, category,cost, director, artist, tracks);
        store.addMedia(cd);
        storeScreen.updateDisplay();

    }

    @FXML
    public void initialize() {
        colTrackTitle.setCellValueFactory(
            new PropertyValueFactory<Track, String>("title")
        );

        colTrackLength.setCellValueFactory(
            new PropertyValueFactory<Track, Integer>("length")
        );

        tfCDTitle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                title = newValue;
            }
        });

        tfCDDirector.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                director = newValue;
            }
        });

        tfCDArtist.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                artist = newValue;
            }
        });

        tfCDCost.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                cost = Float.valueOf(newValue);
            }
        });

        tfCDId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                id = Integer.valueOf(newValue);
            }
        });

        tfCDCategory.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                category = newValue;
            }
        });

        tblTrack.setItems(trackList);
    }

    public AddCompactDiscToStoreScreenController(Store store, StoreScreen storeScreen) {
        super();
        this.store = store;
        this.storeScreen = storeScreen;
    }
}

