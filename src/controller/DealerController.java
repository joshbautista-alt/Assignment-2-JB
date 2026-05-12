package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import model.Dealer;
import model.LoginModel;
import model.exception.EmptyDeckException;
import model.exception.RoundNotReadyException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class DealerController extends Controller<Dealer> {
        
    @FXML private Text p1HealthTxt;
    @FXML private Text p2HealthTxt;
    @FXML private Text p3HealthTxt;
    @FXML private Text p4HealthTxt;
    

    public final void initialize() {
        initializeHealth();
        setupStages();
    }

    private Dealer getDealer() {
        return model;
    }

    @FXML private void handleShowMain(ActionEvent event) {
        ViewLoader.showStage(getDealer().getMainDeck(), "/view/DeckView.fxml", "Main Deck", new Stage());
    }

    @FXML private void handleShowSecondary(ActionEvent event) {
        ViewLoader.showStage(getDealer().getSecondaryDeck(), "/view/DeckView.fxml", "Secondary Deck", new Stage());
    }

    @FXML private void handleCall(ActionEvent event) {
        System.out.println("Calling");
    }

    @FXML private void handleDeal(ActionEvent event) throws EmptyDeckException {
        try {
            getDealer().deal(); 
        } catch (Exception e) {

        }
    }

    @FXML private void handlePlayRound(ActionEvent event) throws RoundNotReadyException {
        try {
            getDealer().play();
            System.out.println("Playing");
        } catch (Exception e) {
            System.out.println("Round itns't reyd");
        }
    }

    @FXML private void handleExit(ActionEvent event) {
        System.out.println("Goodbye!");
    }

    private void initializeHealth() {
        if (getDealer().getPlayers().size() >= 1) {
            p1HealthTxt.textProperty().bind(getDealer().getPlayers().get(0).totalHealthProperty().asString());
        }
        else {
            p1HealthTxt.setText("N/A");
        }
        if (getDealer().getPlayers().size() >= 2) {
            p2HealthTxt.textProperty().bind(getDealer().getPlayers().get(1).totalHealthProperty().asString());
        }
        else {
            p2HealthTxt.setText("N/A");
        }
        if (getDealer().getPlayers().size() >= 3) {
            p3HealthTxt.textProperty().bind(getDealer().getPlayers().get(2).totalHealthProperty().asString());
        }
        else {
            p3HealthTxt.setText("N/A");
        }
        if (getDealer().getPlayers().size() >= 4) {
            p4HealthTxt.textProperty().bind(getDealer().getPlayers().get(3).totalHealthProperty().asString());
        }
        else {
            p4HealthTxt.setText("N/A");
        }
    }

    private void setupStages() {
        for (int i = 0; i < getDealer().getPlayers().size(); i++) {
            ViewLoader.showStage(getDealer().getPlayers().get(i), "/view/PlayerView.fxml", getDealer().getPlayers().get(i).getName(), new Stage());
        }
    }
        
}
