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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class UserLoginController implements Initializable {

    @FXML
    private AnchorPane paneUserLogin;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Hyperlink linkBack;
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink linkSignup;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

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
    private void toBack(ActionEvent event) throws IOException {
        Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        paneUserLogin.getChildren().setAll(paneLogin);
    }

    @FXML
    private void loginUser(ActionEvent event) throws IOException {
        
        String email = txtEmail.getText();
        String pass = txtPass.getText();
        
        if(event.getSource() == btnLogin){
            
            if(email.isEmpty() || pass.isEmpty()){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Missing");
                alert.setHeaderText("Looks like you have missed something");
                alert.setContentText("Please fill in all the fields");
                
                alert.showAndWait();
                
            }
            else if(!email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText(null);
                alert.setContentText("Email should be valid");

                alert.showAndWait();
            
            }
            else{
                
                con = DatabaseConnection.ConnectDatabase();
                
                String qry = "select * from employee where email = ? and password = ?";
                
                try{
                    ps = con.prepareStatement(qry);
                    ps.setString(1, email);
                    ps.setString(2, pass);
                    rs = ps.executeQuery();
                    
                    if (rs.next()){
                        
                        Scan scan = new Scan(email);
                        scan.setVisible(true);
                        
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        stage.close();
                        
                    }
                    else{
                            
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Invalid data");
                        alert.setHeaderText("There's no matching user");
                        alert.setContentText("Make sure your email and password combination is correct");

                        alert.showAndWait();
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        
    }

    @FXML
    private void toSignup(ActionEvent event) throws IOException {
        Pane paneSignup = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        paneUserLogin.getChildren().setAll(paneSignup);
    }
    
}
