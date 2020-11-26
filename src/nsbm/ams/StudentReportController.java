/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import nsbm.ams.models.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class StudentReportController implements Initializable {

    @FXML
    private Pane paneStudentReport;
    @FXML
    private Hyperlink linkHome;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblFaculty;
    @FXML
    private Label lblBatch;
    @FXML
    private Label lblDegree;
    @FXML
    private Label lblAtdDays;
    @FXML
    private Label lblAtdPercentage;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView<Student> tblStudent;
    @FXML
    private TableColumn<Student, String> colStdId;
    @FXML
    private TableColumn<Student, String> colFName;
    @FXML
    private TableColumn<Student, String> colLName;
    @FXML
    private TableColumn<Student, String> colGender;
    @FXML
    private TableColumn<Student, String> colDob;
    @FXML
    private TableColumn<Student, String> colNic;
    
    String studentid;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadStudentList();

    }

    public ObservableList<Student> getStudentList() {

        ObservableList<Student> studentList = FXCollections.observableArrayList();

        Connection con = DatabaseConnection.ConnectDatabase();
        String qry = "SELECT * FROM student";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(qry);
            Student student;

            while (rs.next()) {

                student = new Student(rs.getString("fname"), rs.getString("lname"), rs.getString("dob"), rs.getString("gender"), rs.getString("nic"), rs.getString("stdid"));
                studentList.add(student);

            }

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops, that did not work");
            alert.setContentText("Failed to fetch student data");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String exceptionText = sw.toString();

            Label label = new Label("The exception stacktrace was:");

            TextArea textArea = new TextArea(exceptionText);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(textArea, 0, 1);

            alert.getDialogPane().setExpandableContent(expContent);

            alert.showAndWait();

        }
        return studentList;

    }

    public void loadStudentList() {

        ObservableList<Student> stdList = getStudentList();

        colStdId.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lname"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        tblStudent.setItems(stdList);

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneStudentReport.getChildren().setAll(paneMenu);
    }

    @FXML
    private void filterStudent(ActionEvent event) {
    }

    @FXML
    private void selectStudent(MouseEvent event) {
        
        Student student = tblStudent.getSelectionModel().getSelectedItem();
        studentid = student.getStudentid();
        
        
        
    }

}
