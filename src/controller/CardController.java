package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import model.*;

public class CardController extends Controller<Card> {
    @FXML private ImageView cardIv;

    public final void initialize() {
        cardIv.setImage(new Image(getCard().getPath()));
    }

    @FXML private Card getCard() {
        return model;
    }

    @FXML private void handleClose() {
        stage.close();
    }
    
}
