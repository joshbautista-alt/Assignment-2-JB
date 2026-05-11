package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import model.*;

public class PlayerController extends Controller<Player> {

    @FXML private TableView<Card> handTv;
    @FXML private ListView<Card> tempHandLv;
    @FXML private ImageView currentImg;
    @FXML private Button selectBtn;
    @FXML private Button placeBtn;

    public final void initialize() {
        
    }

    @FXML private void handleSelect(ActionEvent event) {
        currentImg.setImage(new Image("view/image/cards/blindside.png"));
    }

}
