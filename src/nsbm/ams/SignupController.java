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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    String selection;
    int selectedIndex;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboAccType.setItems(list);
    }    

    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        
        selection = comboAccType.getValue();
        
        if(selection == null){
            Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
            paneSignup.getChildren().setAll(paneLogin);
        }
        else switch (selection) {
            case "Admin":
                Pane paneAdminLogin = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
                paneSignup.getChildren().setAll(paneAdminLogin);
                break;
            case "User":
                Pane paneUserLogin = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
                paneSignup.getChildren().setAll(paneUserLogin);
                break;
            default:
                Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
                paneSignup.getChildren().setAll(paneLogin);
        }
        
    }

    @FXML
    private void toBack(ActionEvent event) throws IOException {
        Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        paneSignup.getChildren().setAll(paneLogin);
    }

    @FXML
    private void createAcc(ActionEvent event) {
        
        String fname = txtFName.getText();
        String lname = txtLName.getText();
        String email = txtEmail.getText();
        String pass = txtPass.getText();
        String conpass = txtConPass.getText();
        selectedIndex = comboAccType.getSelectionModel().getSelectedIndex();
        
        if(event.getSource() == btnSignup){
            
            if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || conpass.isEmpty() || comboAccType.getSelectionModel().isEmpty()){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Missing");
                alert.setHeaderText("Looks like you have missed something");
                alert.setContentText("Please fill in all the fields");
                
                alert.showAndWait();
                
            }
            else if(!fname.matches("^[a-zA-Z]+$") || !lname.matches("^[a-zA-Z]+$")){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid input");
                alert.setHeaderText(null);
                alert.setContentText("Name must contain only letters");

                alert.showAndWait();
                
            }
            else if(!txtPass.getText().equals(txtConPass.getText())){
            
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid input");
                alert.setHeaderText("Make sure the passwords match");
                alert.setContentText("Password must contain minimum of 6 chracters");

                alert.showAndWait();
                
            }
            else if(!email.matches("([a-zA-Z0-9\\.]{5,15})\\@nsbm[\\.]lk")){
                
                if(!(selectedIndex == 0) && !(selectedIndex == -1)){
                
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Invalid input");
                    alert.setHeaderText(null);
                    alert.setContentText("Your email username should have minimum of 5 chracters and maximum of 15 characters and should end with nsbm.lk domain");

                    alert.showAndWait();
                    
                }
                else{
                    
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Invalid input");
                    alert.setHeaderText("You are required to use NSBM provided email to sign up as an admin");
                    alert.setContentText("Your email username should have minimum of 5 chracters and maximum of 15 characters and should end with nsbm.lk domain");

                    alert.showAndWait(); 
                    
                }
                
            }
            else{
                System.out.println("working");
            }
        }
        
    }
    
}
