/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    DatabaseConnection con;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboAccType.setItems(list);
        con = new DatabaseConnection();
        
        if(con == null){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Connection error");
            alert.setHeaderText("Ah oh!");
            alert.setContentText("Looks like the database connection is not available");

            alert.showAndWait();
            
        }
        
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
                alert.setTitle("Invalid data");
                alert.setHeaderText(null);
                alert.setContentText("Name must contain only letters");

                alert.showAndWait();
                
            }
            else if(!txtPass.getText().equals(txtConPass.getText())){
            
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText("Make sure the passwords match");
                alert.setContentText("Password must contain minimum of 6 chracters");

                alert.showAndWait();
                
            }
            else if(selectedIndex == 0 && !(selectedIndex == -1) && !email.matches("([a-zA-Z0-9\\.]{1,20})\\@nsbm[\\.]lk")){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText("You are required to use NSBM provided email to sign up as an admin");
                alert.setContentText("Email should be ending with nsbm.lk domain suffix");

                alert.showAndWait();
                
            }
            else if(selectedIndex == 1 && !(selectedIndex == -1) && !email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText(null);
                alert.setContentText("Email should be valid");

                alert.showAndWait();
                
            }
            else{
                
                Connection conn = DatabaseConnection.ConnectDatabase();
                
                if(conn != null){
                    
                    try{
                        
                        PreparedStatement ps;
                        ps = (PreparedStatement)
                                conn.prepareStatement("insert into employee (fname, lname, email, password, access_lvl) values (?,?,?,?,"+selectedIndex+")");
                        
                        ps.setString(1, fname);
                        ps.setString(2, lname);
                        ps.setString(3, email);
                        ps.setString(4, pass);
                        
                        int res = ps.executeUpdate();
                        
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Account creation successful");
                        alert.setContentText("Please log in");

                        alert.showAndWait();
                        
                    }
                    catch(SQLException ex){
                        
                        System.out.println(ex);
                        
                    }
                    
                }
                else{
                    
                    System.out.println("db issue");
                    
                }
                
            }
        
        }
    }
}
    

