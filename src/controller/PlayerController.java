package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import model.*;
import model.exception.FullHandException;
import javafx.beans.binding.*;

public class PlayerController extends Controller<Player> {

    @FXML private TableView<Card> handTv;
    @FXML private ListView<Card> tempHandLv;
    @FXML private ImageView currentImg;
    @FXML private Button selectBtn;
    @FXML private Button placeBtn;

    @FXML private Player getPlayer() {
        return model;
    }

    public final void initialize() {
        tempHandLv.setItems(getPlayer().getTempHand());
        handTv.setItems(getPlayer().getHand());
        handTv.getSelectionModel().selectedItemProperty().addListener(
            (o, oldHand, newHand) -> 
            selectBtn.setDisable(newHand == null));
        tempHandLv.getSelectionModel().selectedItemProperty().addListener(
            (o, oldTempHand, newTempHand) -> 
            placeBtn.setDisable(newTempHand == null));
        getPlayer().selectedCardProperty().addListener(
            (o, preReset, postReset) -> {
            if (postReset == null) {
                currentImg.setImage(new Image("/view/image/cards/empty.png"));
            }
            });
    }

    @FXML private void handleSelect(ActionEvent event) {
        currentImg.setImage(new Image(getSelectedHandCard().getPath()));
        getPlayer().select(getSelectedHandCard());

    }

    @FXML private void handlePlace(ActionEvent event) throws FullHandException {
        try {
            getPlayer().place(getSelectedTempCard());
        } catch (Exception e) {

        }
    }
    
    private Card getSelectedHandCard() {
        return handTv.getSelectionModel().getSelectedItem();
    }

    private Card getSelectedTempCard() {
        return tempHandLv.getSelectionModel().getSelectedItem();
    }

}
