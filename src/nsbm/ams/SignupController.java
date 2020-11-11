/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class SignupController implements Initializable {

    @FXML
    private AnchorPane paneSignup;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private PasswordField txtConPass;
    @FXML
    private ComboBox<String> comboAccType;
    
    ObservableList<String> list = FXCollections.observableArrayList("Admin","User");
    
    @FXML
    private Button btnSignup;
    @FXML
    private Hyperlink linkLogin;
    @FXML
    private Hyperlink linkBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboAccType.setItems(list);
    }    

    @FXML
    private void toLogin(ActionEvent event) {
    }

    @FXML
    private void toBack(ActionEvent event) throws IOException {
        Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        paneSignup.getChildren().setAll(paneLogin);
    }
    
}
