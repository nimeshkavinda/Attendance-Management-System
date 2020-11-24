/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ToggleGroup;
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
    private ComboBox<String> comboFaculty;

    ObservableList<String> listFaculty = FXCollections.observableArrayList("Faculty of Business", "Faculty of Computing", "Faculty of Engineering");

    @FXML
    private ComboBox<String> comboBatch;

    ObservableList<String> listBatch = FXCollections.observableArrayList("Plymouth Batch 7", "Plymouth Batch 8", "20.1", "20.2");

    @FXML
    private ComboBox<String> comboDegree;

    ObservableList<String> listDegreeFOB = FXCollections.observableArrayList("Business Management", "Marketing Management", "Accounting and Finance");
    ObservableList<String> listDegreeFOC = FXCollections.observableArrayList("Software Engineering", "Computer Networks", "Computer Security");
    ObservableList<String> listDegreeFOE = FXCollections.observableArrayList("Computer System Engineering", "Interior Design");

    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private Pane paneStudentReg;

    @FXML
    ToggleGroup group = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioMale.setToggleGroup(group);
        radioFemale.setToggleGroup(group);
        comboFaculty.setItems(listFaculty);
        comboBatch.setItems(listBatch);

    }

    @FXML
    private void updateDegreeList(ActionEvent event) {

        String selection = comboFaculty.getValue();

        if (selection != null) {
            switch (selection) {
                case "Faculty of Business":
                    comboDegree.setItems(listDegreeFOB);
                    break;
                case "Faculty of Computing":
                    comboDegree.setItems(listDegreeFOC);
                    break;
                case "Faculty of Engineering":
                    comboDegree.setItems(listDegreeFOE);
                    break;
                default:
                    comboDegree.setPromptText("Failed to fetch degrees");
            }
        }

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneStudentReg.getChildren().setAll(paneMenu);
    }

    @FXML
    private void saveChanges(ActionEvent event) {

        String fname = txtFName.getText();
        String lname = txtLName.getText();
        String dob = dtDob.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String gender;
        if (radioMale.isSelected()) {
            gender = "Male";
        } else if (radioFemale.isSelected()) {
            gender = "Female";
        } else {
            gender = null;
        }

        String nic = txtNic.getText();
        String studentid = txtStdId.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String faculty = comboFaculty.getValue();
        String batch = comboBatch.getValue();
        String degree = comboDegree.getValue();

    }

    @FXML
    private void cancelChanges(ActionEvent event) {
    }

}
