package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import model.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class DeckController extends Controller<Deck> {
    
    @FXML private ListView<Card> deckLv;

    public final void initialize() {
        deckLv.setItems(getDeck().getCards());
    }
    private Deck getDeck() {
        return model;
    }

    @FXML private void handleClose() {
        stage.close();
    }

    @FXML private void handleShowCard() {
        ViewLoader.showStage(deckLv.getSelectionModel().getSelectedItem(), "/view/CardView.fxml", deckLv.getSelectionModel().getSelectedItem().getName(), new Stage());
    }
}
