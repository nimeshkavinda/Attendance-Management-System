/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private ImageView picProfile;
    @FXML
    private Label lblGreeting;
    @FXML
     Label lblName;
    
    Calendar cal;
    int timeOfDay;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cal = Calendar.getInstance();
        timeOfDay = cal.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            lblGreeting.setText("Good Morning");        
        }
        else if(timeOfDay >= 12 && timeOfDay < 16){
            lblGreeting.setText("Good Afternoon"); 
        }
        else if(timeOfDay >= 16 && timeOfDay < 21){
            lblGreeting.setText("Good Evening"); 
        }
        else if(timeOfDay >= 21 && timeOfDay < 24){
            lblGreeting.setText("Good Night"); 
        }
        else{
            lblGreeting.setText("Hello There");
        }
    }

    public void setName(String name){
       lblName.setText(name);
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
    
}
