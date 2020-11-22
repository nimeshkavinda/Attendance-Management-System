/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class ManageAccountController implements Initializable {

    @FXML
    private Pane paneManageAcc;
    @FXML
    private Hyperlink linkHome;
    @FXML
    private Hyperlink linkChangeDp;
    @FXML
    private Hyperlink linkDelAcc;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtMobile;
    @FXML
    private Button btnSave;
    @FXML
    private PasswordField txtConPass;
    @FXML
    private Circle imgDp;
    
    PreparedStatement pstmt = null;
    Connection con = null;
    String email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setEmail(String empEmail){
        email = empEmail;
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneManageAcc.getChildren().setAll(paneMenu);
    }

    @FXML
    private void saveChanges(ActionEvent event) {
    }

    @FXML
    private void UpdateDp(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(paneManageAcc.getScene().getWindow());
    if (file != null) {
        URL url = file.toURI().toURL();
        
    }
    }

    @FXML
    private void DeleteAcc(ActionEvent event) throws IOException {
        
        con = DatabaseConnection.ConnectDatabase();
        
        String qry = "delete from employee where email = ? ";
        
        try{
            
            pstmt = con.prepareStatement(qry); 
            pstmt.setString(1, email);
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Account update");
                alert.setHeaderText("Your account has been deleted");
                alert.setContentText("You'll be taken back to login window");

                alert.showAndWait();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root,800, 600));
                stage.show();
                stage.centerOnScreen();
                stage.setTitle("Attendance Management System");
                stage.setResizable(false);
                
            } else {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Looks like that didn't work");
                alert.setContentText("Failed to delete your account");

                alert.showAndWait();
                
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();   
        }
        
    }
    
}
