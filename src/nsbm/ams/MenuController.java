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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class MenuController implements Initializable {

    @FXML
    private Pane paneMenu;
    @FXML
    private Button btnStudentRegister;
    @FXML
    private Button btnReport;
    @FXML
    private Button btnAllocate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerStudent(ActionEvent event) throws IOException {
        Pane paneStudentReg = FXMLLoader.load(getClass().getResource("RegisterStudent.fxml"));
        paneMenu.getChildren().setAll(paneStudentReg);
    }

    @FXML
    private void studentReport(ActionEvent event) throws IOException {
        Pane paneStudentReport = FXMLLoader.load(getClass().getResource("StudentReport.fxml"));
        paneMenu.getChildren().setAll(paneStudentReport);
    }

    @FXML
    private void allocateResource(ActionEvent event) throws IOException {
        Pane paneAllocateResource = FXMLLoader.load(getClass().getResource("AllocateResource.fxml"));
        paneMenu.getChildren().setAll(paneAllocateResource);
    }
    
}
