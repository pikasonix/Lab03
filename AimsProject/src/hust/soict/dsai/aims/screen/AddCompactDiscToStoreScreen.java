package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.IOException;
import javafx.application.Platform;

public class AddCompactDiscToStoreScreen extends JFrame {
    private Store store;
    private StoreScreen storeScreen;

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super();
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add CD");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/AddCDToStoreScreen.fxml"));
                    AddCompactDiscToStoreScreenController controller = new AddCompactDiscToStoreScreenController(store, storeScreen);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
}}
