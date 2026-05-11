package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.*;

//Note that this class is not complete!
//This will only add 2 players to the game.
public class LoginController extends Controller<LoginModel> {

    @FXML private TextField player1Tf;
    @FXML private TextField player2Tf;
    @FXML private TextField player3Tf;
    @FXML private TextField player4Tf;

    public final void initialize() {
        player1Tf.setText("Davey");
        player2Tf.setText("Jenny");
        player3Tf.setText("");
        player4Tf.setText("");
        player1Tf.setEditable(false);
        player2Tf.setEditable(false);
    }

    private LoginModel getLoginModel() {
        return model;
    }

    @FXML
    private void handleStart(ActionEvent event) {
        createRoster();
        ViewLoader.showStage(new Dealer(getLoginModel().getPlayers()), "/view/DealerView.fxml", "Dealer", stage);
    }

    private void createRoster() {
        getLoginModel().addToGame(new Player(player1Tf.getText()));
        System.out.println("one");
        getLoginModel().addToGame(new Player(player2Tf.getText()));
        System.out.println("two");
        if(!player3Tf.getText().equals("")) {
            getLoginModel().addToGame(new Player(player3Tf.getText()));
            System.out.println("three");
        }
        if(!player4Tf.getText().equals("")) {
            getLoginModel().addToGame(new Player(player4Tf.getText()));
            System.out.println("four");
        }
    }
}
