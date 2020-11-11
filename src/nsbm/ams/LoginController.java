/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnUser;
    @FXML
    private Hyperlink linkSignup;
    @FXML
    private Pane paneLogin;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toSignup(ActionEvent event) throws IOException {
        Pane paneSignup = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        paneLogin.getChildren().setAll(paneSignup);
    }

    @FXML
    private void loginAsAdmin(ActionEvent event) throws IOException {
        Pane paneAdminLogin = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        paneLogin.getChildren().setAll(paneAdminLogin);
    }

    @FXML
    private void loginAsUser(ActionEvent event) throws IOException {
        Pane paneUserLogin = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        paneLogin.getChildren().setAll(paneUserLogin);
    }
    
}
