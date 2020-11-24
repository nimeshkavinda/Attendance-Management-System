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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class RegisterStudentController implements Initializable {

    @FXML
    private Hyperlink linkHome;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private RadioButton radioMale;
    @FXML
    private RadioButton radioFemale;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtAddress;
    @FXML
    private DatePicker dtDob;
    @FXML
    private TextField txtNic;
    @FXML
    private TextField txtStdId;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtProvince;
    @FXML
    private ComboBox<?> comboFaculty;
    @FXML
    private ComboBox<?> comboBatch;
    @FXML
    private ComboBox<?> comboDegree;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private Pane paneStudentReg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneStudentReg.getChildren().setAll(paneMenu);
    }

    @FXML
    private void saveChanges(ActionEvent event) {
    }

    @FXML
    private void cancelChanges(ActionEvent event) {
    }

}
