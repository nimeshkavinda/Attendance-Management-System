/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import nsbm.ams.models.LectureHall;
import nsbm.ams.models.Student;
import nsbm.ams.services.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class AllocateResourceController implements Initializable {

    @FXML
    private Pane paneResourceAllocate;
    @FXML
    private Hyperlink linkHome;
    @FXML
    private TableView<LectureHall> tblLecHall;
    @FXML
    private TableColumn<LectureHall, String> colLecHall;
    @FXML
    private TableColumn<LectureHall, Integer> colHallSize;
    @FXML
    private TableColumn<LectureHall, String> colModule;
    @FXML
    private Label lblLecHall;
    @FXML
    private Label lblHallSize;
    @FXML
    private Label lblModule;
    @FXML
    private ComboBox<String> comboFaculty;

    ObservableList<String> listFaculty = FXCollections.observableArrayList("Faculty of Business", "Faculty of Computing", "Faculty of Engineering");

    @FXML
    private ComboBox<String> comboDegree;

    ObservableList<String> listDegreeFOB = FXCollections.observableArrayList("Business Management", "Marketing Management", "Accounting and Finance");
    ObservableList<String> listDegreeFOC = FXCollections.observableArrayList("Software Engineering", "Computer Networks", "Computer Security");
    ObservableList<String> listDegreeFOE = FXCollections.observableArrayList("Computer System Engineering", "Interior Design");

    @FXML
    private ComboBox<String> comboModule;

    ObservableList<String> listDegreeBM = FXCollections.observableArrayList("International Business", "Operations Management", "Business Ethics");
    ObservableList<String> listDegreeMM = FXCollections.observableArrayList("International Marketing", "Digital Marketing", "Advertising");
    ObservableList<String> listDegreeAF = FXCollections.observableArrayList("Management Accounting", "Financial Accounting", "Taxation");
    ObservableList<String> listDegreeSE = FXCollections.observableArrayList("SE with Java", "Web Development Platforms", "Databases");
    ObservableList<String> listDegreeCN = FXCollections.observableArrayList("Network Security", "Internet of Things", "Servers and Datacenters");
    ObservableList<String> listDegreeCS = FXCollections.observableArrayList("Incident Prevention", "Network Monitoring", "Penetration Testing");
    ObservableList<String> listDegreeCSE = FXCollections.observableArrayList("Algorithms", "Operating Systems", "Engineering Mathematics");
    ObservableList<String> listDegreeID = FXCollections.observableArrayList("Design Communication", "Building Science", "Design Culture");

    @FXML
    private Button btnAssignLec;

    ObservableList<LectureHall> lectureHallList = FXCollections.observableArrayList();
    @FXML
    private Button btnClearLec;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboFaculty.setItems(listFaculty);
        loadLectureHallList();
    }

    @FXML
    private void updateDegreeList(ActionEvent event) {

        String selectionFac = comboFaculty.getValue();

        if (selectionFac != null) {
            switch (selectionFac) {
                case "Faculty of Business":
                    comboDegree.setItems(listDegreeFOB);
                    break;
                case "Faculty of Computing":
                    comboDegree.setItems(listDegreeFOC);
                    break;
                case "Faculty of Engineering":
                    comboDegree.setItems(listDegreeFOE);
                    break;
            }
        }

    }

    @FXML
    private void updateModuleList(ActionEvent event) {

        String selectionDeg = comboDegree.getValue();

        if (selectionDeg != null) {
            switch (selectionDeg) {
                case "Business Management":
                    comboModule.setItems(listDegreeBM);
                    break;
                case "Marketing Management":
                    comboModule.setItems(listDegreeMM);
                    break;
                case "Accounting and Finance":
                    comboModule.setItems(listDegreeAF);
                    break;
                case "Software Engineering":
                    comboModule.setItems(listDegreeSE);
                    break;
                case "Computer Networks":
                    comboModule.setItems(listDegreeCN);
                    break;
                case "Computer Security":
                    comboModule.setItems(listDegreeCS);
                    break;
                case "Computer System Engineering":
                    comboModule.setItems(listDegreeCSE);
                    break;
                case "Interior Design":
                    comboModule.setItems(listDegreeID);
                    break;
            }
        }

    }

    public ObservableList<LectureHall> getLectureHallList() {

        Connection con = DatabaseConnection.ConnectDatabase();
        String qry = "SELECT * FROM lecturehall";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(qry);
            LectureHall lechall;

            while (rs.next()) {

                lechall = new LectureHall(rs.getString("lhid"), rs.getString("size"), rs.getString("mid"));
                lectureHallList.add(lechall);

            }

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops, that did not work");
            alert.setContentText("Failed to fetch lecture hall data");

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
        return lectureHallList;

    }

    public void loadLectureHallList() {

        ObservableList<LectureHall> lecHallList = getLectureHallList();

        colLecHall.setCellValueFactory(new PropertyValueFactory<>("lecturehall"));
        colHallSize.setCellValueFactory(new PropertyValueFactory<>("hallsize"));
        colModule.setCellValueFactory(new PropertyValueFactory<>("module"));

        tblLecHall.setItems(lecHallList);
        tblLecHall.getSortOrder().add(colHallSize);

    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneResourceAllocate.getChildren().setAll(paneMenu);
    }

    @FXML
    private void selectLecHall(MouseEvent event) {

        LectureHall lechall = tblLecHall.getSelectionModel().getSelectedItem();
        String lecturehall = lechall.getLecturehall();

        Connection con = DatabaseConnection.ConnectDatabase();
        String qry = "SELECT * FROM lecturehall WHERE lhid = '" + lecturehall + "'";

        Statement st;
        ResultSet rs;
        int moduleid;
        String module = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery(qry);

            if (rs.next()) {

                lblLecHall.setText(rs.getString("lhid"));
                lblHallSize.setText(rs.getString("size"));
                moduleid = rs.getInt("mid");

                switch (moduleid) {
                    case 1:
                        module = "International Business";
                        break;
                    case 2:
                        module = "Operations Management";
                        break;
                    case 3:
                        module = "Business Ethics";
                        break;
                    case 4:
                        module = "Management Accounting";
                        break;
                    case 5:
                        module = "International Marketing";
                        break;
                    case 6:
                        module = "SE with Java";
                        break;
                    case 7:
                        module = "Web Development Platforms";
                        break;
                    case 8:
                        module = "Databases";
                        break;
                    case 9:
                        module = "Network Security";
                        break;
                    case 10:
                        module = "Internet of Things";
                        break;
                    case 11:
                        module = "Design Communication";
                        break;
                    case 12:
                        module = "Building Science";
                        break;
                    case 13:
                        module = "Algorithms";
                        break;
                    case 14:
                        module = "Operating Systems";
                        break;
                    case 15:
                        module = "Engineering Mathematics";
                        break;
                    case 16:
                        module = "Digital Marketing";
                        break;
                    case 17:
                        module = "Advertising";
                        break;
                    case 18:
                        module = "Financial Accounting";
                        break;
                    case 19:
                        module = "Taxation";
                        break;
                    case 20:
                        module = "Servers and Datacenters";
                        break;
                    case 21:
                        module = "Incident Prevention";
                        break;
                    case 22:
                        module = "Network Monitoring";
                        break;
                    case 23:
                        module = "Penetration Testing";
                        break;
                    case 24:
                        module = "Design Culture";
                        break;
                    default:
                        module = "No lecture has been assigned";

                }
            }

            lblModule.setText(module);

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Failure to fetch data");

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

    }

    @FXML
    private void assignLec(ActionEvent event) {

        String moduleName = comboModule.getValue();
        int lechallId = Integer.parseInt(lblLecHall.getText());
        int moduleId = 0;

        switch (moduleName) {
            case "International Business":
                moduleId = 1;
                break;
            case "Operations Management":
                moduleId = 2;
                break;
            case "Business Ethics":
                moduleId = 3;
                break;
            case "Management Accounting":
                moduleId = 4;
                break;
            case "International Marketing":
                moduleId = 5;
                break;
            case "SE with Java":
                moduleId = 6;
                break;
            case "Web Development Platforms":
                moduleId = 7;
                break;
            case "Databases":
                moduleId = 8;
                break;
            case "Network Security":
                moduleId = 9;
                break;
            case "Internet of Things":
                moduleId = 10;
                break;
            case "Design Communication":
                moduleId = 11;
                break;
            case "Building Science":
                moduleId = 12;
                break;
            case "Algorithms":
                moduleId = 13;
                break;
            case "Operating Systems":
                moduleId = 14;
                break;
            case "Engineering Mathematics":
                moduleId = 15;
                break;
            case "Digital Marketing":
                moduleId = 16;
                break;
            case "Advertising":
                moduleId = 17;
                break;
            case "Financial Accounting":
                moduleId = 18;
                break;
            case "Taxation":
                moduleId = 19;
                break;
            case "Servers and Datacenters":
                moduleId = 20;
                break;
            case "Incident Prevention":
                moduleId = 21;
                break;
            case "Network Monitoring":
                moduleId = 22;
                break;
            case "Penetration Testing":
                moduleId = 23;
                break;
            case "Design Culture":
                moduleId = 24;
                break;
        }

        Connection con = DatabaseConnection.ConnectDatabase();
        PreparedStatement pstmt;
        String qry = "UPDATE lecturehall SET mid = '" + moduleId + "' WHERE lhid = '" + lechallId + "'";

        try {

            pstmt = con.prepareStatement(qry);
            int result = pstmt.executeUpdate();

            if (result > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Lecture hall updated");
                alert.setContentText("Module has been assigned to to the selected lecture hall");

                alert.showAndWait();

                tblLecHall.getItems().clear();
                loadLectureHallList();
                
                comboFaculty.valueProperty().set(null);
                comboDegree.valueProperty().set(null);
                comboModule.valueProperty().set(null);

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Couldn't update");
                alert.setContentText("Failed to assign the module to the selected lecture hall");

                alert.showAndWait();
                
                comboFaculty.valueProperty().set(null);
                comboDegree.valueProperty().set(null);
                comboModule.valueProperty().set(null);

            }

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops, that did not work");
            alert.setContentText("Failed to make the updates");

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

    }

    @FXML
    private void clearLec(ActionEvent event) {
        
        int lechallId = Integer.parseInt(lblLecHall.getText());
        
        Connection con = DatabaseConnection.ConnectDatabase();
        PreparedStatement pstmt;
        String qry = "UPDATE lecturehall SET mid = NULL WHERE lhid = '" + lechallId + "'";

        try {

            pstmt = con.prepareStatement(qry);
            int result = pstmt.executeUpdate();

            if (result > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Lecture hall updated");
                alert.setContentText("Module has been unassigned from the selected lecture hall");

                alert.showAndWait();

                tblLecHall.getItems().clear();
                loadLectureHallList();
                
                comboFaculty.valueProperty().set(null);
                comboDegree.valueProperty().set(null);
                comboModule.valueProperty().set(null);

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Couldn't update");
                alert.setContentText("Failed to unassign the module from the selected lecture hall");

                alert.showAndWait();
                
                comboFaculty.valueProperty().set(null);
                comboDegree.valueProperty().set(null);
                comboModule.valueProperty().set(null);

            }

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops, that did not work");
            alert.setContentText("Failed to make the updates");

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
        
    }
}
