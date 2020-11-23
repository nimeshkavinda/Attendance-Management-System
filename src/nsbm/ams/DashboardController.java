/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class DashboardController implements Initializable {

    @FXML
    private Pane paneNav;
    @FXML
    private Hyperlink linkSignout;
    @FXML
    private Hyperlink linkManageacc;
    @FXML
    private Pane paneMenu;
    @FXML
    private Pane paneUpdates;
    @FXML
    private Circle picProfile;
    @FXML
    private Label lblGreeting;
    @FXML
    private Label lblName;
    @FXML
    private Label lblNameAlt;
    @FXML
    private Pane panePlaceholder;
    @FXML
    private Label lblNameAlt1;
    
    Calendar cal;
    int timeOfDay;
    String email;
    String path;
    String imgpath;
    String doc = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    String dir = "\\NSBMAMS\\";
    Path loc = null;
    Path imgDp = null;
    static ManageAccountController accountctrl;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Pane paneLogin = null;
        try {
            paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        panePlaceholder.getChildren().setAll(paneMenu);
        
        cal = Calendar.getInstance();
        timeOfDay = cal.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            lblGreeting.setText("Good Morning");        
        }
        else if(timeOfDay >= 12 && timeOfDay < 16){
            lblGreeting.setText("Good Afternoon"); 
        }
        else if(timeOfDay >= 16 && timeOfDay < 24){
            lblGreeting.setText("Good Evening"); 
        }
        else{
            lblGreeting.setText("Hello There");
        }
        
        path = doc+dir;
        imgpath = doc+dir+email+".png";
        loc = Paths.get(path);
        imgDp = Paths.get(imgpath);
        
        if (Files.notExists(loc)) {
            try {
                Files.createDirectory(loc);
            
            } catch (IOException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(Files.notExists(imgDp)){
                Image dp = new Image("resources/img/dp.png");
                picProfile.setFill(new ImagePattern(dp));
            }
            else{
                
            }
        }
    }

    public void setName(String name){
        if(timeOfDay >= 0 && timeOfDay < 12){
            lblNameAlt1.setText(name);      
        }
        else if(timeOfDay >= 12 && timeOfDay < 16){
            lblName.setText(name);
        }
        else if(timeOfDay >= 16 && timeOfDay < 24){
            lblNameAlt.setText(name); 
        }
        else{
            lblNameAlt.setText(name);
        }
    }
    
    public void setEmail(String empEmail){
        email = empEmail;
    }

    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,800, 600));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Attendance Management System");
        stage.setResizable(false);
    }

    @FXML
    private void toManageAcc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageAccount.fxml"));
        Pane paneManageAcc = loader.load();
        paneMenu.getChildren().setAll(paneManageAcc);
        accountctrl = (ManageAccountController)loader.getController();
        accountctrl.setEmail(email);
    }
    
}
